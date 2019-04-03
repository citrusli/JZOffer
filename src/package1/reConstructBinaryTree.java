package package1;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class reConstructBinaryTree {
    /*
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */

    //自己的代码
    /*
     * 通过祖先节点，将中序队列分为左右两颗子树，
     * 对于左子树，获取它的先序和中序队列，调用本函数获取二叉树(递归)，添加到祖先节点
     * 右子树同理
     */
    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if(pre.length == 0 || pre == null)
            return null;
        TreeNode result = new TreeNode(pre[0]);

        int resultP = 0;
        for(int i = 0; i < in.length; i++) {      //在中序队列中找到祖先节点，将队列分为前后两部分，即左右两棵树
            if(in[i] == result.val) {
                resultP = i;                       //resultP 代表祖先节点在中序队列中的位置
                break;
            }
        }

        //获取左子树
        if(resultP == 0)
            result.left = null;
        else{
            int[] leftPre = new int[resultP];         //左子树的先序队列
            int leftPN = 0;
            int[] leftIn = new int[resultP];          //左子树的中序队列
            int leftIN = 0;
            for(int i = 0; i < pre.length; i++) {
                if(pre[i] == result.val) {}
                else if(leftPN < leftPre.length){
                    leftPre[leftPN++] = pre[i];        //获取先序队列
                }

                if(in[i] == result.val) {}
                else if(leftIN < leftIn.length) {
                    leftIn[leftIN++] = in[i];           //获取中序队列
                }
            }
            result.left = reConstructBinaryTree1(leftPre, leftIn);
        }

        //获取右子树
        if(pre.length - 1 - resultP == 0)
            result.right = null;
        else{
            int[] rightPre = new int[pre.length - 1 - resultP];         //右子树的先序队列
            int rightPN = 0;
            int[] rightIn = new int[pre.length - 1 - resultP];          //右子树的中序队列
            int rightIN = 0;
            for(int i = 0; i < pre.length; i++) {
                if(pre[i] == result.val) {}
                else if(rightPN < rightPre.length && pre.length - i <= in.length - resultP - 1){
                    rightPre[rightPN++] = pre[i];        //获取先序队列
                }

                if(in[i] == result.val) {}
                else if(rightIN < rightIn.length && i > resultP) {
                    rightIn[rightIN++] = in[i];           //获取中序队列
                }
            }
            result.right = reConstructBinaryTree1(rightPre, rightIn);
        }

        return result;
    }

    //推荐代码
    /*
     * 思路基本与1相同，都是先确定根节点，再通过递归获取左右子树
     * 不过本代码重写了调用函数，不用再为子树建立先序中序数组，可直接在原数组的基础上实现
     * 代码更加清晰明了
     */
    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree2(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    public TreeNode reConstructBinaryTree2(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if(startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for(int i = startIn; i <= endIn; i++) {
            if(in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree2(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = reConstructBinaryTree2(pre, i-startIn+startPre+1, endPre, in, i+1, endIn);
                break;
            }
        }
        return root;
    }
}
