package package1;

import java.util.Stack;

public class queueAchievedByStack {
    /*
      用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //自己的代码
    /*
     * 栈为先进后出的数据结构，序列经过栈的一次处理后为倒置的序列，
     * 那么经过两个栈的处理后，得到的序列两次倒置，顺序不变，可作为队列
     */
    public void push(int node) {
        stack1.push(node);
    }
    public int pop(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        return stack2.pop();
    }
}
