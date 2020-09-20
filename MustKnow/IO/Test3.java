package MustKnow.IO;

import java.util.Scanner;
import java.util.*;

public class Test3 {
    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();//目标和 n
        int k=scan.nextInt();//填入的数 [1,k]
        int d=scan.nextInt();// 填入的数的最大值必须大于d
        int []nums = new int [n];
        scan.nextLine();//用来跳过行列后的回车符
        for(int i=0;i<n;i++){

            nums[i]=scan.nextInt();
            //System.out.print(nums[i]+" ");
        }
        //System.out.println("");
    }
}
