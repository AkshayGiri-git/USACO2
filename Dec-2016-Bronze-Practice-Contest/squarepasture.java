import java.util.*;
import java.io.*;
public class squarepasture{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("square.in"));
            pw = new PrintWriter(new FileWriter("square.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        String[] pasture1 = s.nextLine().split(" ");
        String[] pasture2 = s.nextLine().split(" ");
        int maxx = Math.max(Math.max(Integer.parseInt(pasture1[0]),Integer.parseInt(pasture1[2])),Math.max(Integer.parseInt(pasture2[0]),Integer.parseInt(pasture2[2])));
        int minx = Math.min(Math.min(Integer.parseInt(pasture1[0]),Integer.parseInt(pasture1[2])),Math.min(Integer.parseInt(pasture2[0]),Integer.parseInt(pasture2[2])));
        int maxy = Math.max(Math.max(Integer.parseInt(pasture1[1]),Integer.parseInt(pasture1[3])),Math.max(Integer.parseInt(pasture2[1]),Integer.parseInt(pasture2[3])));
        int miny = Math.min(Math.min(Integer.parseInt(pasture1[1]),Integer.parseInt(pasture1[3])),Math.min(Integer.parseInt(pasture2[1]),Integer.parseInt(pasture2[3])));
        pw.println((int) Math.pow((double) Math.max(Math.abs(maxx-minx),Math.abs(maxy-miny)),2));
        pw.close();
    }
}