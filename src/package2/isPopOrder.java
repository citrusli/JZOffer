package package2;

import java.util.Stack;

public class isPopOrder {
    /*
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
    序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
    （注意：这两个序列的长度是相等的）
     */

    //自己的代码
    Stack<Integer> stack = new Stack<Integer>();
    public boolean IsPopOrder(int[] push, int[] pop){
        int len = push.length;
        int m = 0,n = 0;
        while(m < len && n < len){
            if(push[m] != pop[n]){
                stack.push(push[m]);
                m++;
            }
            else{
                m++;
                n++;
                if(!stack.isEmpty()){
                    do{
                        int temp = stack.pop();
                        if(temp == pop[n])
                            n++;
                        else{
                            stack.push(temp);
                            break;
                        }
                    }while (!stack.isEmpty());
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
