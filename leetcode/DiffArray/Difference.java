package leetcode.DiffArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
    public class Difference {
        private int[]diff;
        private int[]res;
        public Difference(int[] nums){
            if(nums.length>0)
                diff = new int[nums.length];

            diff[0] = nums[0];
            for(int i=1;i< nums.length;i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }
        public int[] result(){
            if(diff.length>0){
                int[] res = new int[diff.length];
            }

            res[0] = diff[0];
            for(int i=1;i<diff.length;i++){
                res[i] = res[i-1]+diff[i];
            }
            return res;
        }

    }
    public int[] corpFlightBookings(int[][] bookings, int n){
        int[]nums = new int[n];
        Difference df = new Difference(nums);

        for(int[] booking:bookings){
            int i = booking[0]-1;
            int j = booking[1]-1;
            int val = booking[2];

            df.increment(i,j,val);

        }
        return df.result();
    }

    public static void main(String[] args) {

        int[][]bookings = new int[3][3];
        Scanner in = new Scanner(System.in);

        for(int i=0;i<3;i++){
            for(int j =0;j<3;j++)
                bookings[i][j] = in.nextInt();
        }



        Solution solution = new Solution();
        solution.corpFlightBookings(bookings,5);
    }

    
}
