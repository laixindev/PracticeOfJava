package leetcode;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            ArrayList<String> list = Permutation(a);
            for(int i = 0 ; i<list.size();i++){
                System.out.println(list.get(i));
            }
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    private static void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }
        else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j =i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
