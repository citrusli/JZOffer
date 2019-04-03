package package1;

public class replaceSpace {
    /*
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     * */

    //自己的代码
    /*
    *  遍历字符串，当出现空格字符时，将空格替换为"%20"
    *  时间复杂度为 n
    *  */
    public String replaceSpace1(StringBuffer str){
        if(str == null || str.length() == 0)
            return str.toString();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                str = str.delete(i, i+1);
                str = str.insert(i, "%20");
            }
        }
        return str.toString();
    }

    //推荐代码
    public String replaceSpace2(StringBuffer str){
        return str.toString().replaceAll(" " , "%20");
    }
}
