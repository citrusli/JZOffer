package package2;


class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int val){
        this.val = val;
    }
}

public class merge {
    /*
    输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */

    //自己的代码
    /*
     * 代码比较凌乱
     * 首先建立一个新的链表，然后比对两个链表首元素，将较小值放在新链表中
     * 以此类推，遍历两条链表，当有一条为空时停止
     * 当仍存在非空的链表时，直接添加到新链表的尾部
     */
    public ListNode3 Merge1(ListNode3 list1, ListNode3 list2){
        if(list1 == null && list2 == null)
            return null;
        else if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;

        ListNode3 l1 = list1, l2 = list2;
        ListNode3 temp = new ListNode3(0);
        ListNode3 m = new ListNode3(0);
        if(list2.val < list1.val){
            temp = list2;
            l2 = l2.next;
            m = temp;
        }

        if(list1.val <= list2.val){
            temp = list1;
            l1 = l1.next;
            m = temp;
        }

        for(; l1 != null && l2 != null; ){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            else if(l1.val > l2.val){
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
            else{
                temp.next = l1;
                l1 = l1.next;
                temp.next.next = l2;
                l2 = l2.next;
                temp = temp.next.next;
            }
        }
        if(l1 != null) { temp.next = l1; }
        if(l2 != null) { temp.next = l2; }
        return m;
    }

    //推荐代码
    /*
     * 采用递归实现，先取出首元素较小值，再用递归将求得的链表连接到该节点的尾部
     */
    public ListNode3 Merge2(ListNode3 list1, ListNode3 list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val <= list2.val){
            list1.next = Merge2(list1.next, list2);
            return list1;
        }
        else{
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }

}
