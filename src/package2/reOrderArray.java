package package2;

public class reOrderArray {
    /*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    //自己的代码
    /*
     * 设置变量JPoint为零，遍历数组，当找到下一个奇数时将下一个奇数移至首位，且JPoint加一
     * 继续遍历数组，当找到下一个奇数时，将奇数移至JPoint，且加一
     * 以此类推
     * 算法时间复杂度 n*n
     * 元素移动太频繁，可以寻求更好的解决方法
     */
    public void reOrderArray(int[] array) {
        int JPoint = 0;
        if(array == null || array.length == 0 || array.length == 1)
            return;
        if(array[0]%2 == 1)
            JPoint++;
        for(int i = 1; i < array.length; i++){
            if(array[i]%2 == 1 && JPoint != i){
                int temp = array[i];
                for(int j = i-1; j >= JPoint; j--){
                    array[j+1] = array[j];
                }
                array[JPoint++] = temp;
            }
            if(array[i]%2 == 1 && JPoint == i)
                JPoint++;
        }
    }
}
