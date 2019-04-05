package package3;



public class convert {
    /*
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */


    //推荐代码
    /*
     * 通过中序遍历实现指针的变换
     * 将左节点的右指针指向本节点，将本节点的左指针指向左节点
     * 遍历过程中，head 代指左节点， 参数 pRootOfTree 代指本节点
     */
    TreeNode head = null;               //head 用于遍历过程中对各个节点的引用
    TreeNode realHead = null;          //realHead 代表初始的节点，也是最终返回的结果
    public TreeNode Convert(TreeNode pRootOfTree) {
        CovertSub(pRootOfTree);
        return realHead;
    }

    public void CovertSub(TreeNode pRootOfTree){
        if(pRootOfTree == null)
            return;
        CovertSub(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
            realHead = pRootOfTree;
        }
        else{
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        CovertSub(pRootOfTree.right);
    }
}
