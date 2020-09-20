package test.JD;

import java.util.Scanner;
//蜗牛爬井 每天上升n，下滑n/2，第二天上升n，下滑n/2+n/4
public class test1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Solution solution = new Solution();
        double ans = solution.ans(n,m);
        System.out.println((int)ans);
    }
    public static  class Solution{
        public double ans(int n,int m){
            double res = 1.0;//当前天数
            int cur =0;//当前位置
            int step = n/2;//下滑距离
            while(cur<m*100){
                cur+=n;//白天往上爬n 厘米
                if(cur>m*100) break;
                cur-=step;//每晚下滑n/2厘米
                res += 1.0;//仍未出井就天数+1
                step = (int) (step +(n/(Math.pow(2.0,res))));//下滑距离更新
            }
            return res;
        }
    }
}
