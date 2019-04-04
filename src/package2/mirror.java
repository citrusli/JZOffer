package package2;


class TreeNode2 {
    int val = 0;
    TreeNode2 left = null;
    TreeNode2 right = null;
    public TreeNode2(int val){
        this.val = val;
    }
}

public class mirror {
    /*
    操作给定的二叉树，将其变换为源二叉树的镜像。
    二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
     */


    //自己的代码
    /*
     * 将二叉树的左子树与右子树交换
     * 然后分别对两个子树递归调用本函数，将两个子树镜像化
     */
    public void Mirror1(TreeNode2 root){
        TreeNode2 temp;
        if(root == null)
            return;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null)
            Mirror1(root.left);
        if(root.right != null)
            Mirror1(root.right);
    }
}
