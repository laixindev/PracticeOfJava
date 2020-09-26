package MustKnow.IO;

import java.util.Scanner;
//1 2 3
//4 5
//0 0 0 0 0
public class MulSum4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String[] sa = in.nextLine().split(" ");
            int sum = 0;
            for(int i=0;i<sa.length;i++){
                sum+=Integer.parseInt(sa[i]);
            }
            System.out.println(sum);
        }
    }
}
