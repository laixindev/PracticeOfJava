package MustKnow.IO;

import java.util.Scanner;
//输入包括两个整数，输入数据包括多组
//input
//1 5
//10 20
//output
//6
//30
public class TwoSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] sa = s.split(" ");
            System.out.println(Integer.parseInt(sa[0])+Integer.parseInt(sa[1]));
        }
    }
}
