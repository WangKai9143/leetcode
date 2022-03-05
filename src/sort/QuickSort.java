package sort;

/**
 * Created by Administrator on 2020/5/1.
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr [] = {2,4,1,2,3,6,5};
        sort(arr);
        System.out.println(arr);
    }

    public static void sort(int arr []){
        if (arr == null || arr.length == 0){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int start , int end) {
        if (start>=end){
            return;
        }
        int i = start;
        int j = end;
        int flag = arr[start];
        while (i<j){
            while (i<j && arr[j] >=flag){
                j--;
            }
            if (i<j){
                arr[i++] = arr[j];
            }
            while (i<j && arr[i] <= flag){
                i++;
            }
            if (i<j){
                arr[j--] = arr[i];
            }
        }
        arr[i] = flag;
        quickSort(arr, start, i-1);
        quickSort(arr, i+1, end);
    }
}
