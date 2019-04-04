package package2;

import java.util.ArrayList;

public class printMatrix {
    /*
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */

    //自己的代码
    /*
     * 利用flag 表示当前的遍历数组的方向
     * 根据改变方向顺时针遍历数组，将元素添加到结果中，再将数组原位置置为-1
     * 代码较为复杂
     */
    public ArrayList<Integer> printMatrix1(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0,j = 0,flag = 4;
        if(matrix == null)
            return null;
        if(matrix.length == 1){       //数组只有一行，一行有多个元素
            for(int k = 0; k < matrix[0].length; k++)
                result.add(matrix[0][k]);
            return result;
        }
        if(matrix[0].length == 1){    //数组有多行，每行只有一个元素
            for(int k = 0; k < matrix.length; k++)
                result.add(matrix[k][0]);
            return result;
        }

        while(flag != -1){
            switch (flag)
            {
                case 1:{         //flag = 1 代表向上的方向
                    result.add(matrix[i][j]);
                    if(i == 0 || matrix[i-1][j] == -1){
                        if(j == matrix[i].length-1 || matrix[i][j+1] == -1)
                            flag = -1;
                        else{
                            matrix[i][j] = -1;
                            j++;
                            flag = 4;
                        }
                    }
                    else{
                        matrix[i][j] = -1;
                        i--;
                    }
                }break;
                case 2:{         //flag = 2 代表向下的方向
                    result.add(matrix[i][j]);
                    if(i == matrix.length-1 || matrix[i+1][j] == -1){
                        if(i == 0 || matrix[i][j-1] == -1)
                            flag = -1;
                        else{
                            matrix[i][j] = -1;
                            j--;
                            flag = 3;
                        }
                    }
                    else {
                        matrix[i][j] = -1;
                        i++;
                    }
                }break;
                case 3:{         //flag = 3 代表向左的方向
                    result.add(matrix[i][j]);
                    if(j == 0 || matrix[i][j-1] == -1)
                    {
                        if(i == 0 || matrix[i-1][j] == -1)
                            flag = -1;
                        else
                        {
                            matrix[i][j] = -1;
                            i--;
                            flag = 1;
                        }
                    }
                    else{
                        matrix[i][j] = -1;
                        j--;
                    }
                }break;
                case 4:{       //flag = 4 代表向右的方向
                    result.add(matrix[i][j]);
                    if(j == matrix[i].length-1 || matrix[i][j+1] == -1)
                    {
                        if(i == matrix.length-1 || matrix[i+1][j] == -1)
                            flag = -1;
                        else
                        {
                            matrix[i][j] = -1;
                            i++;
                            flag = 2;
                        }
                    }
                    else{
                        matrix[i][j] = -1;
                        j++;
                    }
                }break;
            }
        }
        return result;
    }


    //推荐代码
    /*
     * 定义四个变量，限定遍历的矩阵范围
     */
    public ArrayList<Integer> printMatrix2(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(row == 0 || col == 0)
            return res;
        int left = 0, top = 0, right = col-1, bottom = row-1;
        while(left <= right && top <= bottom){
            //left to right
            for(int i = left+1; i <= right; i++)
                res.add(matrix[top][i]);
            for(int i = top+1; i <= bottom; i++)
                res.add(matrix[i][right]);
            if(top != bottom){
                for(int i = right-1; i >= left; i--)
                    res.add(matrix[bottom][i]);
            }
            if(left != right){
                for(int i = bottom-1; i >= top; i--)
                    res.add(matrix[i][left]);
            }
            left++; top++; right--; bottom--;
        }
        return res;
    }
}
