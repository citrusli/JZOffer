package package1;

public class numberOf1 {
    /*
    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */

    //自己的代码
    /*
     * 当n大于0时，可通过十进制转二进制的方法获取1的个数
     * 当n小于0时，可通过补码的特征知 n + 补码(n)
     */
    public int NumberOf1(int n) {
        if(n == 0 || n == 1)
            return n;
        if(n > 0)
            return n%2 + NumberOf1(n/2);
        else{
            n = (int)(n + Math.pow(2,31));
            return NumberOf1(n) + 1;
        }
    }
}
