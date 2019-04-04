package package2;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int val){
        this.val = val;
    }
}

public class reverseList {
    /*
    输入一个链表，反转链表后，输出新链表的表头。
     */

    //自己的代码
    /*
     * 本题通过递归实现，使用递归求得head.next的反转链表，再将表头添加到反转链表的表尾
     * 即可获得反转链表
     */
    public ListNode2 ReverseList1(ListNode2 head){
        if(head == null || head.next == null)
            return head;
        else{
            ListNode2 h = head.next;
            ListNode2 head1 = ReverseList1(h);
            h.next = head;
            head.next = null;
            return head1;
        }
    }

    //推荐代码
    /*
     * 生成一个新链表，顺序读取原链表，将读到的节点插入到新链表的首部
     * 直至原链表为空，返回新链表即可
     */
    public ListNode2 ReverseList2(ListNode2 head) {
        if(head == null)
            return null;
        ListNode2 pre = null;
        ListNode2 next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
