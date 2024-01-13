import java.util.*;
import java.io.*;
public class blockgame{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("blocks.in"));
            pw = new PrintWriter(new FileWriter("blocks.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        int num = Integer.parseInt(s.nextLine());
        String[][] input = new String[num][2];
        int[] ans = new int[26];
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            input[i][0] = line[0];
            input[i][1] = line[1];
        }
        //97
        for(int j = 0;j<num;j++){
            for(int k = 0;k<26;k++){
                int count1 = 0;
                int count2 = 0;
                for(int l = 0;l<input[j][0].length();l++){
                    if(input[j][0].charAt(l) == (char)k+97){
                        count1++;
                    }
                }
                for(int m = 0;m<input[j][1].length();m++){
                    if(input[j][1].charAt(m) == (char)k+97){
                        count2++;
                    }
                }
                ans[k] += Math.max(count1,count2);
            }
        }
        for(int z = 0;z<26;z++){
            pw.println(ans[z]);
        }
        pw.close();
    }
}