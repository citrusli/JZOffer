package package3;

import java.util.ArrayList;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Comparator;

public class getLeastNumbers {

    /*
    输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */

    //自己的代码
    /*
     * 采用栈实现数据的排序，最终栈顶到栈底数据递增
     * 每次读取到数据时，与栈顶元素相比较，较小时直接入栈
     * 较大时，栈顶元素入辅助栈，继续比较原栈顶元素，找到合适的位置使数据入栈，再将辅助栈的元素入栈
     * 最终直接在栈顶读取元素即可
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k <= 0 || k > input.length)
            return res;
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> help = new Stack<Integer>();
        int temp;
        for(int i = 0; i < input.length; i++){
            if(stack.size() == 0){
                stack.push(input[i]);
            }
            else{
                temp = stack.pop();
                while(temp < input[i] && stack.size() != 0){
                    help.push(temp);
                    temp = stack.pop();
                }
                if(stack.size() == 0 && temp >= input[i]){
                    stack.push(temp);
                }
                else {
                    if (stack.size() != 0)
                        stack.push(temp);
                    else
                        help.push(temp);
                }
                stack.push(input[i]);
                while(help.size() != 0){
                    stack.push(help.pop());
                }
            }
        }
        while(k-- != 0 && stack.size() != 0)
            res.add(stack.pop());
        return res;
    }


    //推荐代码
    /*
     * 采用最大堆实现，每次元素和堆顶元素比较，如果较小，则删除堆顶，新数入堆
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
