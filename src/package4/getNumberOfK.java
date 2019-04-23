package package4;

public class getNumberOfK {
    /*
     统计一个数字在排序数组中出现的次数。
     */
    public int GetNumberOfK(int [] array , int k) {
        return binarySearch(array, k+0.5) - binarySearch(array, k-0.5);
    }

    public int binarySearch(int[] array, double num){
        int lo = 0;
        int hi = array.length-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(array[mid] < num)
                lo = mid + 1;
            else if(array[mid] > num)
                hi = mid - 1;
        }
        return lo;
    }
}
