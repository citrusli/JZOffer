package package2;

public class minStack {
    /*
    定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */

    //自己的代码
    int[] stack = new int[10];     //利用数组存储数据
    int num = 0;                    //栈中元素的个数
    int minni;                      //栈中最小的元素
    public void push(int node){
        if(num == stack.length){
            int[] temp = new int[stack.length*2];
            for(int i = 0; i < stack.length; i++)
                temp[i] = stack[i];
            stack = temp;
        }
        stack[num++] = node;
        if(num == 1)
            minni = node;
        else if(node < minni)
            minni = node;
    }
    public void pop(){
        if(num == 0)
            return;
        if(stack[num-1] == minni){
            minni = stack[0];
            if(num > 2){
                for(int i = 0; i < num-1; i++){
                    if(stack[i] < minni)
                        minni = stack[i];
                }
            }
        }
        num--;
    }
    public int top(){
        return stack[num-1];
    }
    public int min(){
        return minni;
    }
}
