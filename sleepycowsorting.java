import java.util.*;
import java.io.*;
public class sleepycowsorting {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
             s = new Scanner(new File("sleepy.in"));
             pw = new PrintWriter(new FileWriter("sleepy.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        int num = Integer.parseInt(s.nextLine());
        String[] input = s.nextLine().split(" ");
        int ans = num-1;
        for(int i = num-2;i>=0;i--){
            if(Integer.parseInt(input[i])<Integer.parseInt(input[i+1])){
                ans--;
            }else{
                break;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
