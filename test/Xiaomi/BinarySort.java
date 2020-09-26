package test.Xiaomi;


import java.util.Scanner;
public class BinarySort {
    public static void main(String[] args) {
        int res = 0;
        int []arr = new int[]{1,2,3,4,5};
        res = BinarySort(arr,1);
        System.out.println(res);

    }
    public static int BinarySort(int[] arr, int target){
        int left =0;
        int right = arr.length-1;
        int mid  = (left+right)/2;
        while(arr[mid]!=target){

            if(arr[mid]>target){
                right = mid - 1;
            }
            else if(arr[mid]<target){
                left = mid + 1;
            }
            if(left>right) return -1;
            mid = (left+right)/2;
        }


        return mid;
    }
}
