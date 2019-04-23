package package4;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class findFirstCommonNode {
    /*
     输入两个链表，找出它们的第一个公共结点。
    */

    //自己的代码
    /*
     * 编写函数isSubList判断p2是否是p1的子链表，函数equal判断两个链表是否相等
     * 首先判断pHead2是否是pHead1的子链表，
     * 然后pHead2后移，直至pHead2是pHead1的子链表，直接返回pHead2即可
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        while(pHead2 != null){
            if(isSubList(pHead1,pHead2))
                break;
            else
                pHead2 = pHead2.next;
        }
        return pHead2;
    }
    public boolean isSubList(ListNode p1, ListNode p2){
        ListNode tmp = p1;
        while(tmp != null){
            if(equal(tmp,p2)){
                return true;
            }
            else
                tmp = tmp.next;
        }
        return false;
    }
    public boolean equal(ListNode p1, ListNode p2){
        while(true){
            if(p1 == null && p2 == null)
                break;
            if(p1.val != p2.val)
                return false;
            if((p1 == null && p2 != null) || (p1 != null && p2 == null))
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    //推荐代码
    /*
     * 测试未通过，尚未理解算法思路
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2){
            p1 = p1 == null?pHead1:p1.next;
            p2 = p2 == null?pHead1:p2.next;
        }
        return p1;
    }
}
