package package3;

public class numberOf1Between1AndN {
    /*
    求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
    ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     */



    public int NumberOf1Between1AndN_Solution(int n) {
        int low,cur,temp,i=1;
        int high = n;//记录高位数
        int total = 0; //总的1的数量
        if(n < 1)
            return 0;
        while(high!=0) {
            //记忆2593 此时i=2，依次拆分25 9 3
            high = n/powerBaseof10(i);//// 获取第i位的高位
            temp = n%powerBaseof10(i);
            cur = temp/powerBaseof10(i-1);// 获取第i位
            low = temp%powerBaseof10(i-1);// 获取第i位的低位
            if(cur ==1) {
                total += high * powerBaseof10(i-1) + low +1;
            }
            else if (cur > 1) {
                total += (high + 1) * powerBaseof10(i -1);
            }
            else {
                total += high * powerBaseof10(i-1);
            }
            i++;
        }
        return total;
    }

    public int powerBaseof10(int base) {
        return (int)Math.pow(10, base);
    }
}
