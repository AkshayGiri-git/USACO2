import java.util.*;
import java.io.*;
class teleport{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("teleport.in"));
            pw = new PrintWriter(new FileWriter("teleport.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        String[] line = s.nextLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);
        int tstart = Integer.parseInt(line[2]);
        int tend = Integer.parseInt(line[3]);
        int ans1 = Math.abs(start-end);
        int ans2 = Math.abs(start-tstart)+Math.abs(tend-end);
        int ans3 = Math.abs(start-tend)+Math.abs(tstart-end);
        int ans4 = Math.min(ans1,ans2);
        pw.println(Math.min(ans4,ans3));
        pw.close();


    }
}