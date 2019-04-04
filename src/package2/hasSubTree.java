package package2;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}

public class hasSubTree {
    /*
    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */

    //自己的代码
    /*
     * 添加一个判断二叉树是否相等的函数
     * 首先判断两棵树是否相等，是则返回真
     * 再判断root1的左子树是否与root2相等，右边也同样判断
     */
    public boolean HasSubTree1(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null)
            return false;
        if(Equal(root1, root2))
            return true;
        if(HasSubTree1(root1.left,root2))
            return true;
        if(HasSubTree1(root1.right,root2))
            return true;
        return false;
    }

    public boolean Equal(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 != null)
            return false;
        if(root2 == null)
            return true;
        if(root1.val == root2.val){
            if(Equal(root1.left, root2.left) && Equal(root1.right, root2.right))
                return true;
        }
        return false;
    }
}
