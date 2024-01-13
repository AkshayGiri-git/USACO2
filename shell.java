import java.util.*;
import java.io.*;
public class shell {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("shell.in"));
            pw = new PrintWriter(new FileWriter("shell.out"));
        }catch(Exception e){

        }
        int num = Integer.parseInt(s.nextLine());
        int[][] input = new int [num][3];
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            input[i][0] = Integer.parseInt(line[0]);
            input[i][1] = Integer.parseInt(line[1]);
            input[i][2] = Integer.parseInt(line[2]);
        }
        int ans = Integer.MIN_VALUE;
        int curr = 0;
        for(int i = 0;i<3;i++){
            int shell = i+1;
            for(int j = 0;j<num;j++){
                if(input[j][0] == shell) {
                    shell = input[j][1];
                }else if(input[j][1] == shell){
                    shell = input[j][0];
                }
                if(input[j][2] == shell){
                    curr++;
                }
            }
            if(curr>ans){
                ans = curr;
            }
            curr = 0;
        }
        pw.println(ans);
        pw.close();
    }
}
