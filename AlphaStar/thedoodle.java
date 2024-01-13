import java.util.*;
import java.io.*;
public class thedoodle{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] fline = s.nextLine().split(" ");
        int x = Integer.parseInt(fline[0]);
        int y = Integer.parseInt(fline[1]);
        int multiplier = Integer.parseInt(fline[2]);
        String[][] input = new String[x][y];
        for(int i = 0;i<x;i++){
            String[] line = s.nextLine().split(" ");
            for(int j = 0;j<y;j++){
                input[i][j] = line[j];
            }
        }
        String ans = "";
        for(int k = 0;k<x;k++){
            for(int l = 0;l<y;l++){
                for(int m = 0;m<multiplier;m++){
                    ans = ans+input[k][l];
                }

            }
            for(int n = 0;n<multiplier;n++){
                System.out.println(ans);
            }
            ans = "";
        }
    }
}