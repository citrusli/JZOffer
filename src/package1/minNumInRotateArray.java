package package1;

public class minNumInRotateArray {
    /*
      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
      输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
      例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
      NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */

    //自己的代码
    /*
     * 若数组为旋转的，则可将其分为前后两部分，（0，i）(i+1,n)
     * 两部分均为非递减序列，且array[i] > array[i+1]，当满足这个条件时array[i+1]为最小值
     * 若整个数组为完全有序，则最小值为第一个数
     * 时间复杂度 n
     */
    public int minNumberInRotateArray1(int[] array) {
        if(array.length == 0 || array == null)
            return 0;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1])
                return array[i+1];
        }
        return array[0];
    }

    //推荐代码
    /*
     * 使用二分查找来确定最小值在哪个区间，逐渐缩小区间最终找到最小值
     * 时间复杂度 logN
     */
    public int minNumberInRotateArray2(int[] array) {
        int low = 0;
        int high = array.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(array[mid] > array[high])       //最小值在后面的区间
                low = mid+1;
            else if(array[mid] == array[high]) //存在重复
                high = high-1;
            else                               //最小值在前面的区间
                high = mid;
        }
        return array[low];
    }
}
