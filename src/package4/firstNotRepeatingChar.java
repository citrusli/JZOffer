package package4;


import java.util.Hashtable;
import java.util.HashMap;

public class firstNotRepeatingChar {
    /*
    在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
    如果没有则返回 -1（需要区分大小写）.
     */

    //自己的代码
    /*
     * 借用一个Hashtable，用来保存所有字符第一次出现的位置
     * 遍历字符串，当Hashtable中不存在当前字符时，将字符与位置添加到其中
     * 当Hashtable中存在当前字符时，将当前字符替换为'0'，将表中对应的value位置的字符替换为'0'
     * 重新遍历字符串，找到第一个字母，返回索引值
     * 本段代码的时间复杂度较大，不推荐使用
     */
    public int FirstNotRepeatingChar(String str) {
        StringBuffer string = new StringBuffer(str);
        Hashtable<Character,Integer> strTimes = new Hashtable<Character, Integer>();
        for(int i = 0; i < string.length(); i++){
            if(strTimes.get(string.charAt(i)) == null){
                strTimes.put(string.charAt(i),i);
            }
            else{
                int index = Integer.parseInt(strTimes.get(string.charAt(i))+"");
                string.replace(i,i+1,"0");
                string.replace(index,index+1,"0");
            }
        }
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) != '0')
                return i;
        }
        return -1;
    }

    public boolean isLetter(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;
        return false;
    }

    //推荐代码
    HashMap<Character, Integer> map = new HashMap<>();

    public int FirstNotRepeatingChar2(String str) {
        if (str==null)return -1;
        int length = str.length();
        for(int i = 0;i<length;i++) {

            if(map.containsKey(str.charAt(i))){
                int value = map.get(str.charAt(i));
                map.remove(str.charAt(i));
                map.put(str.charAt(i),value+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i = 0;i<length;i++){
            if(map.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
