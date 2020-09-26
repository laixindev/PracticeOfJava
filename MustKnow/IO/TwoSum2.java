package MustKnow.IO;

import java.util.Scanner;
//2
//1 5
//10 20
//
//6
//30
public class TwoSum2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            for(int i=0;i<n;i++){
                int a =in.nextInt();
                int b =in.nextInt();
                System.out.println(a+b);
            }
        }
    }
}
