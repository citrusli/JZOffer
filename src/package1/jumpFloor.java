package package1;

public class jumpFloor {
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */

    //自己的代码
    /*
     * 采用动态规划法分为跳一步和跳两步两种情况，采用递归算出两种情况的和，即为总跳法
     */
    public int JumpFloor1(int target){
        if(target == 0 || target == 1 || target == 2)
            return target;
        int type1 = 0, type2 = 0;
        type1++;
        if(target-1 == 1){}
        else
            type1 *= JumpFloor1(target-1);

        type2++;
        if(target-2 == 1){}
        else
            type2 *= JumpFloor1(target-2);

        return type1+type2;
    }

    //推荐代码
    /*
     *   每次跳台阶只有一级和两级两种情况，可以分析出
     *           1  (n = 1)
     *   f(n) =  2  (n = 2)
     *           f(n-1) + f(n-2)  (n > 2)
     *   本代码虽然较简洁，但由于递归，开销很大
     *   观察表达式，可以发现是斐波拉契序列
     *   因此可以探索求斐波拉契序列且开销较小的方法
     */
    public int JumpFloor2(int target) {
        if(target <= 0)
            return -1;
        else if(target == 1 || target == 2)
            return target;
        else
            return JumpFloor2(target-1)+JumpFloor2(target-2);
    }
}
