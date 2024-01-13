import java.util.*;
import java.io.*;
public class blockedbillboard {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("billboard.in"));
            pw = new PrintWriter(new FileWriter("billboard.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        String[] bill1 = s.nextLine().split(" ");
        String[] bill2 = s.nextLine().split(" ");
        String[] bill3 = s.nextLine().split(" ");
        boolean [][] coor = new boolean[2001][2001];
        for(int i = Integer.parseInt(bill1[1]);i<Integer.parseInt(bill1[3]);i++) {
            for (int j = Integer.parseInt(bill1[0]); j < Integer.parseInt(bill1[2]); j++) {
                coor[i+1000][j+1000] = true;
            }
        }
        for(int i = Integer.parseInt(bill2[1]);i<Integer.parseInt(bill2[3]);i++) {
            for (int j = Integer.parseInt(bill2[0]); j < Integer.parseInt(bill2[2]); j++) {
                coor[i+1000][j+1000] = true;
            }
        }
        for(int i = Integer.parseInt(bill3[1]);i<Integer.parseInt(bill3[3]);i++) {
            for (int j = Integer.parseInt(bill3[0]); j < Integer.parseInt(bill3[2]); j++) {
                coor[i+1000][j+1000] = false;
            }
        }
        int count = 0;
        for(int i = Integer.parseInt(bill1[1]);i<Integer.parseInt(bill1[3]);i++) {
            for (int j = Integer.parseInt(bill1[0]); j < Integer.parseInt(bill1[2]); j++) {
                if(coor[i+1000][j+1000]){
                    count++;
                }
            }
        }
        for(int i = Integer.parseInt(bill2[1]);i<Integer.parseInt(bill2[3]);i++) {
            for (int j = Integer.parseInt(bill2[0]); j < Integer.parseInt(bill2[2]); j++) {
                if(coor[i+1000][j+1000]){
                    count++;
                }
            }
        }
        pw.println(count);
        pw.close();
    }
}
