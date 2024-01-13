import java.util.*;
import java.io.*;
class fencepainting{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("paint.in"));
            pw = new PrintWriter(new FileWriter("paint.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        String[] firstLine = s.nextLine().split(" ");
        String[] secondLine = s.nextLine().split(" ");
        int farmstart = Integer.parseInt(firstLine[0]);
        int farmend = Integer.parseInt(firstLine[1]);
        int besstart = Integer.parseInt(secondLine[0]);
        int bessend = Integer.parseInt(secondLine[1]);
        boolean[] paint = new boolean[101];
        for(int i = farmstart;i<farmend;i++){
            paint[i] = true;
        }
        for(int j = besstart;j<bessend;j++){
            paint[j] = true;
        }
        int count = 0;
        for(int k = 0;k<paint.length;k++){
            if(paint[k]){
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }
}