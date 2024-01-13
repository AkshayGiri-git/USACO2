import java.util.*;
import java.io.*;
class Bull{
static Scanner s;
static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner(new File("bcs.in"));
            pw = new PrintWriter(new FileWriter("bcs.out"));
        }catch(Exception e){

        }
        String[] nextLine = s.nextLine().split(" ");
        int n = Integer.parseInt(nextLine[0]);
        int k = Integer.parseInt(nextLine[1]);
        int[][] pieces = new int[n*k][n];
        for(int i = 0;i<n*k;i++){
            String [] line = s.nextLine.split(" ");
            for(int j = 0;j<n;j++){
                pieces[i][j] == Integer.parseInt(line[j]);
            }
        }

    }
}