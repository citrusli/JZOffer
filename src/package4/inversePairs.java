package package4;

public class inversePairs {
    /*
    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     */

    //推荐代码
    /*
     * 一般思路中，使用两层循环判断数组中逆序对的数目时间复杂度为n*n，会超时
     * 推荐代码中，使用归并排序对数组进行排序，并在排序过程中计算逆序对的值
     */
    int cnt;
    public int InversePairs(int[] array){
        cnt = 0;
        if(array != null){
            mergeSortUp2Down(array,0,array.length-1);
        }
        return cnt;
    }

    public void  mergeSortUp2Down(int[] a, int start, int end){
        if(start >= end)
            return;
        int mid = (start+end)/2;

        mergeSortUp2Down(a,start,mid);
        mergeSortUp2Down(a,mid+1,end);
        merge(a,start,mid,end);
    }

    public void merge(int[] a, int start, int mid, int end){
        int[] tmp = new int[end-start+1];
        int i = start, j = mid+1, k = 0;
        while(i <= mid && j <= end){
            if(a[i] <= a[j])
                tmp[k++] = a[i++];
            else{
                tmp[k++] = a[j++];
                cnt += mid - i + 1;
                cnt%=1000000007;
            }
        }

        while(i <= mid)
            tmp[k++] = a[i++];
        while(j <= end)
            tmp[k++] = a[j++];
        for(k = 0; k < tmp.length; k++)
            a[start+k] = tmp[k];
    }
}
