import java.util.*;
import java.io.*;
public class cowatehomework {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("homework.in"));
            pw = new PrintWriter(new FileWriter("homework.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        int num = Integer.parseInt(s.nextLine());
        String[] score2 = s.nextLine().split(" ");

        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        double max = 0;
        int least = Integer.MAX_VALUE;
        for(int i = 1;i<=num-2;i++){
            for(int j = i;j<num;j++){
                sum += Integer.parseInt(score2[j]);
                if(Integer.parseInt(score2[j])<least){
                    least = Integer.parseInt(score2[j]);
                }
            }
            double score = ((double) sum-least)/( (double) num-i-1);
            System.out.println(score);
            System.out.println(max);
            if(score> max){
                max =  score;
                ans.clear();
                ans.add(i);
            }
            else if(score == max){
                ans.add(i);
            }
            sum = 0;
            least = Integer.MAX_VALUE;
        }
        for (Integer k : ans) {
            pw.println(k);
        }
        pw.close();
    }
}
