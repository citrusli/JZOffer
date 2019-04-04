package package3;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}


class Queue {
    public TreeNode[] node;
    public int size;
    public Queue(){
        node = new TreeNode[10];
        for(int i = 0; i < node.length; i++)
            node[i] = null;
        size = 0;
    }
    public void offer(TreeNode n){
        if(size == node.length){
            TreeNode[] temp = new TreeNode[node.length*2];
            for(int i = 0; i < node.length; i++)
                temp[i] = node[i];
            node = temp;
        }
        node[size++] = n;
    }
    public TreeNode poll(){
        TreeNode temp = node[0];
        size--;
        for(int i = 0; i < size; i++)
            node[i] = node[i+1];
        return temp;
    }
}

public class printFromTopToBottom {
    /*
    从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */

    //自己的代码
    /*
     * 为本题创建一个队列结构（类型为TreeNode）
     * 首先遍历根节点，将根节点放进队列中
     * 当队列不为空时，从其中取出元素，同时将取出节点的左右节点（不为空）放进队列
     * 循环上述操作，直至队列为空
     */
    public ArrayList<Integer> printFromTopToBottom(TreeNode root){
        Queue queue = new Queue();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root != null){
            queue.offer(root);
            TreeNode n;
            while (queue.size != 0){
                n = queue.poll();
                result.add(n.val);
                if(n.left != null)
                    queue.offer(n.left);
                if(n.right != null)
                    queue.offer(n.right);
            }
        }
        return result;
    }
}
