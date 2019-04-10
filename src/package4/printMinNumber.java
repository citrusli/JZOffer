package package4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class printMinNumber {
    /*
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */

    /*
     * 自己的代码
     * 使用冒泡排序的算法，比较第i和第j个数哪个放在i的位置连结成的数更小，
     * 根据结果判断是否需要调换两个数的位置
     * 本代码的时间复杂度较大，不推荐使用
     */
    public String PrintMinNumber(int [] numbers) {
        String s1,s2;
        int a,b,temp;
        int index = 0;
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(isBetter(i,j,numbers)){
                    switchNum(numbers,i,j);
                    continue;
                }
            }
        }
        String str = "";
        for(int i = 0; i < numbers.length; i++){
            str += numbers[i];
        }
        return str;
    }

    public void switchNum(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isBetter(int i, int j, int[] array){
        String str1 = "";
        String str2 = "";
        String si = array[i]+"", sj = array[j]+"";
        for(int a = i; a < array.length; a++){
            if(a == i){
                str1 += si;
                str2 += sj;
            }
            else if(a == j){
                str1 += sj;
                str2 += si;
            }
            else{
                str1 += array[a];
                str2 += array[a];
            }
        }
            if(str1.compareTo(str2) > 0)
                return true;

        return false;
    }

    //推荐代码
    public String PrintMinNumber2(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>(){

            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s+=j;
        }
        return s;

    }
}
