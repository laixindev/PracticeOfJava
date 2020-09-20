package MustKnow.IO;



//    输入一个二维数组到matrix[][]
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        if(num<1)return;
        String[] str = new String[num];
        String res = new String();
        for (int i = 0; i < num; i++) {
            str[i] = sc.nextLine();
            res=get_ans(str[i]);
            System.out.println(res);
        }


    }

    private static String get_ans(String str) {
        String sub = str.substring(0,3);
        //System.out.println(sub);
        char[]chars = sub.toCharArray();


        if(1==1){
            return "Yes";
        }
        else
            return "No";
    }
}