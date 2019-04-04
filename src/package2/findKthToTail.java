package package2;


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}

public class findKthToTail {
    /*
    输入一个链表，输出该链表中倒数第k个结点。
     */


    //自己的代码
    /*
     * 通过获取链表的长度，即可知倒数第k个节点是整数第length - k个节点
     * 直接顺序遍历链表即可
     */
    public ListNode FindKthToTail1(ListNode head, int k) {
        int length = 0;
        for (ListNode h = head; h != null; h = h.next){
            length++;
        }
        if(k > length || k <0)
            return null;
        else{
            int i = length - k;
            ListNode t = head;
            for (; i > 0; i--, t = t.next);
            return t;
        }
    }

    //推荐代码
    /*
     * 定义了两个指针，且两个指针相隔k
     * 当后面的指针指向尾节点时，前面的指针指向倒数第k个节点
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if(head == null || k < 0)
            return null;
        ListNode pre = head;
        ListNode last = head;
        for(int i = 1; i < k; i++){
            if(pre.next != null)
                pre = pre.next;
            else
                return null;
        }
        while(pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
