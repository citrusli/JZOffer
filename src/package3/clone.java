package package3;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}

public class clone {
    /*
    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    返回结果为复制后复杂链表的head。
    （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */

    //推荐代码
    /*
     * 在原有的链表结构中构建新的链表结构
     * 首先根据next指针遍历链表，在原有的节点的后方插入新的节点
     * 然后根据原来的random指针构建新的random指针关系
     * 完成后，直接删除原来的节点
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        //RandomListNode temp;
        RandomListNode h = pHead;
        while(h != null){
            RandomListNode temp = new RandomListNode(h.label);
            temp.next = h.next;
            h.next = temp;
            h = temp.next;
        }
        h = pHead;
        while(h != null){
            h.next.random = (h.random == null?null:h.random.next);
            h = h.next.next;
        }
        h = pHead;
        RandomListNode res = h.next;
        RandomListNode clone;
        while(h != null){
            clone = h.next;
            h.next = clone.next;
            clone.next = clone.next == null?null:clone.next.next;
            h = h.next;
        }
        return h;
    }
}
