package package2;

public class power {
    /*
    给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */


    //自己的代码
    /*
     * 判断指数的符号，分为下面三种情况
     * 利用递归实现，直至最终指数为0时返回1
     */
    public double Power(double base, int exponent) {
        if(exponent == 0)
            return 1;
        else if(exponent > 0)
            return base*Power(base, exponent-1);
        else
            return (1/base)*Power(base, exponent+1);
    }
}
