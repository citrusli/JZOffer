package package1;

import java.util.*;

public class searchInArray {
    /*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
    判断数组中是否含有该整数。*/

    //自己的代码
    /*主要思路是通过数组的横向有序性和竖向有序性缩小查找范围，在缩短的范围中遍历判断目标数的存在
    * 时间复杂度 n*n */
    public boolean Find1(int target, int [][] array) {
        //target为要查找的整数，array为给定的二维数组
        //判定数组中是否含有数据
        if(array == null || array.length == 0 || (array.length == 1 && array[0].length == 0))
            return false;
        //设置   a 指target大于等于第a行的第一个数，b 指target小于等于第b行的最后一个数
        int a=-1,b=-1;
        for(int i = 0; i < array.length; i++){
            if(a != -1 && b != -1)
                break;
            else{
                if(a == -1 && target >= array[i][0])
                    a = i;
                if(b == -1 && target <= array[array.length-1-i][array[i].length-1])
                    b = array.length-1-i;
            }
        }//遍历数组，确定a,b的值
        if(a > b || a == -1 || b == -1)     //a,b的值不正常，则不存在target
            return false;
        //遍历第a行到第b行的数据，确定其中是否存在target
        for(int i=a; i <= b; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == target)
                    return true;
            }
        }
        return false;
    }


    //推荐代码1
    /* 数组是有序的，从右上角来看，左边的数比它小，下边的数比它大，
    *  因此，选定右上角的数为参考点，当目标数比它大时，向下移，当
    *  目标数比它小时，向左移
    *  时间复杂度为 m*n （m行，n列）*/
    public boolean Find2(int[][] array, int target){
        int row = 0;
        int col = array[0].length - 1;         //(row,col)为右上角的坐标
        while(row <= array.length-1 && col >= 0){
            if(target == array[row][col])
                return true;
            else if(target > array[row][col])
                row++;
            else
                col--;
        }
        return false;
    }

    //推荐代码2
    /* 遍历每一行，在行中利用二分查找判断目标数的存在
    *  时间复杂度为 nlogn*/
    public boolean Find3(int[][] array, int target){
        for(int i = 0; i < array.length; i++){
            int low = 0;
            int high = array[i].length-1;    //每一行的low, high
            while(low <= high){
                int mid = (low + high)/2;
                if(target == array[i][mid])
                    return true;
                else if(target > array[i][mid])
                    low = mid +1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
