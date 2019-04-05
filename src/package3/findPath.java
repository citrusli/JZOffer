package package3;

import java.util.ArrayList;

public class findPath {
    /*
    输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    (注意: 在返回值的list中，数组长度大的数组靠前)
     */

    //推荐代码
    /*
     * 利用二叉树的先序遍历序列，只需添加判断根节点的条件
     */
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curResult = new ArrayList<Integer>();
        if(root == null)
            return result;
        int curSum = 0;
        FindPathCore(root, target, curResult, result, curSum);
        return result;
    }
    public void FindPathCore(TreeNode root, int target, ArrayList<Integer> curResult, ArrayList<ArrayList<Integer>> result, int curSum)
    {
        if(root == null)
            return;
        boolean isLeaf = (root.left == null && root.right == null);
        curSum += root.val;
        if(isLeaf){
            if(curSum == target){
                curResult.add(root.val);
                result.add(new ArrayList(curResult));
                curResult.remove(curResult.size()-1);
            }
            curSum -= root.val;
            return;
        }
        curResult.add(root.val);
        FindPathCore(root.left, target, curResult, result, curSum);
        FindPathCore(root.right, target, curResult, result, curSum);
        curResult.remove(curResult.size()-1);
    }

    //推荐代码
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target){
        if(root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;                       //target在递归调用中，下一层的操作不会影响上一层的值
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath2(root.left, target);
        FindPath2(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }
}
