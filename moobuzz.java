import java.util.*;
import java.io.*;
public class moobuzz{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("moobuzz.in"));
            pw = new PrintWriter(new FileWriter("moobuzz.out"));
        }catch(Exception e){

        }
        int num = Integer.parseInt(s.nextLine());
        num--;
        int[] nums = {1,2,4,7,8,11,13,14};
        int num1 = num/8;
        int num2 = num%8;
        int ans = (num1*15)+nums[num2];
        pw.println(ans);
        pw.close();
    }
}