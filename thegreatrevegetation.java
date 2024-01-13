import java.util.*;
import java.io.*;
class thegreatrevegetation{
    static Scanner s;
    static PrintWriter pw;
    public static void main (String[] args){
        try{
            s = new Scanner(new File("revegetate.in"));
            pw = new PrintWriter(new FileWriter("revegetate.out"));
        }catch (Exception e){

        }
        String[] line1 = s.nextLine().split(" ");
        int cows = Integer.parseInt(line1[1]);
        int[][] input = new int[cows][2];
        int pastures = Integer.parseInt(line1[0]);
        int[] ans = new int[pastures];
        for(int i = 0;i<cows;i++){
            String[] line = s.nextLine().split(" ");
            input[i][0] = Integer.parseInt(line[0]);
            input[i][1] = Integer.parseInt(line[1]);
        }
        boolean exit = false;
        int changes = 0;
        while(!exit){
            for(int j = 0;j<input.length;j++){
                if(ans[input[j][0]-1] == ans[input[j][1]-1]){
                    ans[Integer.max(input[j][0],input[j][1])-1]++;
                    changes++;
                }
            }
            if(changes == 0){
                exit = true;
            }
            changes = 0;
        }
        for(int k = 0;k<ans.length;k++){
            pw.print(ans[k]+1);
        }
        pw.close();
    }
}