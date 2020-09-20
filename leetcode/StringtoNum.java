package leetcode;

import java.util.Scanner;
import java.util.*;

import static java.lang.Character.isDigit;

public class StringtoNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.next();
        System.out.println(Stn(a));

        in.close();
    }


    public static long Stn(String str) {
        // corner case
        if (str == null || str.length() == 0) return 0;

        final int n = str.length(); // length of the str

        int i = 0;
        while (i < n && str.charAt(i) == ' ') ++i;
        if (i >= n) return 0;

        if (!isDigit(str.charAt(i))
                && str.charAt(i) != '+'
                && str.charAt(i) != '-')
            return 0;

        char sign = isDigit(str.charAt(i)) ? '+' : str.charAt(i++);

        long num = 0;
        while (i < n && isDigit(str.charAt(i))) {
            num = num * 10 + (str.charAt(i) - '0');
            if (sign == '+' && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == '-' && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            ++i;
        }
        return sign == '+' ?  num : -num;
    }
}
