package package3;

import java.util.Hashtable;

public class moreThanHalfNum {

    /*
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */


    //自己的代码
    /*
     * 通过Hashtable 来记录每个元素出现的个数
     * key 代表元素，value 代表其出现的次数
     * 当第一次出现时，put操作，次数为1
     * 多次出现时，put操作，次数加一，覆盖之前的数据
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        Hashtable<String,Integer> table = new Hashtable<String,Integer>();
        for(int i = 0; i < array.length; i++){
            if(table.get(array[i]+"") == null){
                table.put(array[i]+"",1);
            }
            else{
                table.put(array[i]+"",table.get(array[i]+"")+1);
            }
            if(table.get(array[i]+"") != null && table.get(array[i]+"") > array.length/2)
                return array[i];
        }
        return 0;
    }
}
