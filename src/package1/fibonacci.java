package package1;

public class fibonacci {
    /*
      大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
       n<=39
     */

    //自己的代码
    /*
     * 定义一个静态Fibonacci表，对于表中不存在的数，可通过递归的方法求得其值，并存在表中
     * 对于表中已存在的数，直接读取即可
     */
    public static int[] fib = new int[40];
    public int Fibonacci(int n) {
        if(n == 0 || n == 1){
            fib[n] = n;
            return fib[n];
        }
        if(fib[n] != 0)
            return fib[n];
        else{
            fib[n] = Fibonacci(n-1)*Fibonacci(n-2);
            return fib[n];
        }
    }
}
