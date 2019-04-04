package package3;

import java.lang.reflect.Array;

public class verifySequenceOfBST {
    /*
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */


    //自己的代码
    /*
     * 由于是后序序列，因此可以直接获得根节点的值
     * 顺序遍历序列，当遇到大于根节点的数时停止，标志为k，将序列分为左右二叉查找树
     * 判断k节点后面的数是否都大于根节点，若否，则返回false
     * 递归调用本函数判断左右序列是否都为二叉查找树的后序序列
     * 将结果相与并返回
     */
    public boolean verifySequenceOfBST1(int[] sequence){
        boolean leftFlag = true;
        boolean rightFlag = true;
        if(sequence.length == 1 || sequence.length == 2)
            return true;
        if(sequence.length == 0)
            return false;
        int root =sequence[sequence.length-1];
        int k = 0;
        while(k < sequence.length-1){
            if(sequence[k] < root)
                k++;
            else
                break;
        }
        if(k != 0){
            leftFlag = true;
            int[] left = new int[k];
            for(int i = 0; i < k; i++)
                left[i] = sequence[i];
            leftFlag = verifySequenceOfBST1(left);
        }

        if(k == sequence.length-1)
            rightFlag = true;
        else{
            for(int i = k; i < sequence.length-1; i++){
                if(sequence[i] < root) {
                    rightFlag = false;
                    break;
                }
            }
            if(rightFlag){
                int[] right = new int[sequence.length-1-k];
                for(int i = k; i < sequence.length-1; i++)
                    right[i-k] = sequence[i];
                rightFlag = verifySequenceOfBST1(right);
            }
        }
        if(leftFlag && rightFlag)
            return true;
        return false;
    }

    //推荐代码
    /*
     * 本代码与我的思路基本相同，代码方面更为简洁
     */
    public boolean judge(int[] root, int l, int r){
        if(l >= r)
            return true;
        int i = r;
        while(i > l && root[i-1] > root[r])
            i--;
        for(int j = i-1; j >= l; j--){
            if(root[j] > root[r])
                return false;
        }
        return judge(root, l, i-1) && judge(root, i, r-1);
    }
    public boolean verifySequenceOfBST2(int[] root){
        if(root.length == 0)
            return false;
        return judge(root, 0, root.length-1);
    }
}
