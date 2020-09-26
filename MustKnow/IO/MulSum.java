package MustKnow.IO;

import java.util.Scanner;

//4 1 2 3 4
//5 1 2 3 4 5
//0
public class MulSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n==0)break;
            int sum = 0;
            while(n>0){
                sum +=in.nextInt();
                n--;
            }
            System.out.println(sum);
        }
    }
}
