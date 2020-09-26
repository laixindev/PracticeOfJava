package MustKnow.IO;

import java.util.Scanner;

//2
//4 1 2 3 4
//5 1 2 3 4 5
public class MulSum3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1) return;
        for (int i=0; i < n; i++) {
            String[] sa = in.nextLine().split(" ");
            int sum = 0;
            for (int j = 1; j < sa.length; j++) {
                sum += Integer.parseInt(sa[j]);
            }
            System.out.println(sum);
        }
    }
}
