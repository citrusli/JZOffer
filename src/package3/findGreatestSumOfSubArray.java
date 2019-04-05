package package3;

public class findGreatestSumOfSubArray {

    /*
    HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
    今天测试组开完会后,他又发话了:
    在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
    但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
    例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
    给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     */

    //自己的代码
    /*
     * 最大子段和问题，采用分治法实现
     * 每个问题都可以分为三种情况：
     * 1.最大序列在数组的左边
     * 2.最大序列在数组的右边
     * 3.最大序列跨越左右两边
     * 1，2情况可以递归实现
     * 3，可以从中点向两边遍历，分别求最大和
     * 最终比较三种情况的最大和，取最大值为最终结果
     * 主要难点在于sum,leftSum,rightSum等比较变量的初始化
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        return MaxSum(array,0,array.length-1);
    }
    public int MaxSum(int[] array, int left, int right){
        int sum = array[left],midSum,leftSum = array[left],rightSum = array[right];
        int center,s1,s2,lefts,rights;
        if(left == right)
            sum = array[left];
        else{
            center = (left+right)/2;
            leftSum = MaxSum(array,left,center);
            rightSum = MaxSum(array,center+1,right);
            midSum = array[center];
            s1 = array[center];lefts = array[center];
            for(int i = center-1; i >= left; i--){
                lefts += array[i];
                if(lefts > s1)
                    s1 = lefts;
            }
            s2 = array[center];rights = array[center];
            for(int i = center+1; i <= right; i++){
                rights += array[i];
                if(rights > s2)
                    s2 = rights;
            }
            midSum = s1+s2-array[center];
            if(midSum < leftSum)
                sum = leftSum;
            else
                sum = midSum;
            if(sum < rightSum)
                sum = rightSum;
        }
        return sum;
    }

    //推荐代码
    /*
    使用动态规划
     F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     F（i）=max（F（i-1）+array[i] ， array[i]）
     res：所有子数组的和的最大值
     res=max（res，F（i））

     如数组[6, -3, -2, 7, -15, 1, 2, 2]
     初始状态：
        F（0）=6
        res=6
    i=1：
        F（1）=max（F（0）-3，-3）=max（6-3，3）=3
        res=max（F（1），res）=max（3，6）=6
    i=2：
        F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
        res=max（F（2），res）=max（1，6）=6
     */
    public  int FindGreatestSumOfSubArray2(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }
}
