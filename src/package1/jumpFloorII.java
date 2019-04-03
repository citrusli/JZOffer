package package1;

public class jumpFloorII {
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */

    //自己的代码
    /*
     * 已经看不懂了
     */
    public int JumpFloorII1(int target) {
        if(target == 1 || target == 0 || target == 2)
            return target;
        int type = 0;
        for(int i = 1; i <= target; i++){

            type += JumpFloorII1(target-i);
        }
        type++;
        return type;
    }

    //推荐代码
    /*
     * n = 1时，f(1)=1
     * n = 2时，f(2)= f(2-1) + f(2-2)
     * n = 3时，f(3)= f(3-1) + f(3-2) + f(3-3)
     * ...
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-n)
     * 化简表达式可以得到f(n) = 2*f(n-1)
     *         1  (n=0)
     * f(n) =  1  (n=1)
     *         2*f(n-1)  (n>1)
     */
    public int JumpFloorII2(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII2(target - 1);
        }
    }
}
