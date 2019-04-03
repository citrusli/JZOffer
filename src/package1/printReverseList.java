package package1;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class printReverseList {
    /*
     输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */

    //自己的代码
    /*
     * 使用递归的方法求倒置的链表，调用本函数获得第二个数开始的倒置链表，再在
     * 结尾添加第一个数，即为倒置的链表
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();      //结果
        if(listNode == null)
            return result;
        if(listNode.next == null) {
            result.add(listNode.val);
            return result;
        }
        result = printListFromTailToHead1(listNode.next);
        result.add(listNode.val);
        return result;
    }

}
