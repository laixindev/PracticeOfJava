package MustKnow.IO;

import java.util.Scanner;

//4 1 2 3 4
//5 1 2 3 4 5
public class MulSum2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while(in.hasNext()){
            String[] sa = in.nextLine().split(" ");
            int sum =0;
            for(int i=1;i<sa.length;i++){
                sum+=Integer.parseInt(sa[i]);
            }
            System.out.println(sum);
        }
    }
}
