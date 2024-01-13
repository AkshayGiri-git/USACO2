import java.util.*;
import java.io.*;
class speedticket{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
             s = new Scanner(new File("speeding.in"));
             pw = new PrintWriter(new FileWriter("speeding.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        String[] firstLine = s.nextLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int[] road = new int[100];
        int[][] input = new int [m+n][2];
        for(int i = 0;i<m+n;i++) {
                String[] in = s.nextLine().split(" ");
                input[i][0] = Integer.parseInt(in[0]);
                input[i][1] = Integer.parseInt(in[1]);
        }
        int place = 0;
        for(int j =0;j<m;j++){
            for(int k = place;k<place+input[j][0];k++){
                road[k] = input[j][1];
            }
            place += input[j][0];
        }
        int max = 0;
        int place2 = 0;
        for(int l = m;l<m+n;l++){

            for(int o = place2;o<place2+input[l][0];o++){

                if(input[l][1]-road[o] > max){
                    max = input[l][1]-road[o];
                }

            }
            place2 += input[l][0];

        }
        pw.println(max);
        pw.close();
    }
}