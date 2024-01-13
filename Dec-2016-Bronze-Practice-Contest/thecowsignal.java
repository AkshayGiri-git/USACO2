import java.util.*;
import java.io.*;
public class thecowsignal{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("cowsignal.in"));
            pw = new PrintWriter(new FileWriter("cowsignal.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        String[] fline = s.nextLine().split(" ");
        String[][] input = new String[Integer.parseInt(fline[0])][Integer.parseInt(fline[1])];
        int amplify = Integer.parseInt(fline[2]);
        for(int i = 0;i<input.length;i++){
            String[] line = s.nextLine().split("");
            for(int j = 0;j<line.length;j++){
                input[i][j] = line[j];
            }
        }
        String line2 = "";
        for(int k = 0;k<input.length;k++){
            for(int l = 0;l<input[0].length;l++){
                for(int m = 0;m<amplify;m++) {
                    if (input[k][l].equals("X")) {
                        line2 += "X";
                    } else {
                        line2 += ".";
                    }
                }
            }
            for(int n = 0;n<amplify;n++){
                pw.println(line2);
            }
            line2 = "";
        }
        pw.close();
    }
}