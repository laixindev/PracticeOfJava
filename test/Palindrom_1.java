package test;

import java.util.Scanner;
public class Palindrom_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            StringBuffer str =new StringBuffer( in.nextLine());
            int n = in.nextInt();
            for(int i =0;i<n;i++){
                int start = in.nextInt();
                int end = start + in.nextInt();
                StringBuffer buffer = new StringBuffer(str.substring(start, end));
                str.insert(end, buffer.reverse().toString());
            }
            System.out.println(str);
        }
    }
}
