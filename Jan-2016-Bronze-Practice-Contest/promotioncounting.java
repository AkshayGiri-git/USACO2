import java.util.*;
import java.io.*;
class promotioncounting{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s =  new Scanner(new File("promote.in"));
            pw = new PrintWriter(new FileWriter("promote.out"));
        }catch(Exception e){

        }
        int[][] input = new int[4][2];
        for(int i = 0;i<4;i++){
            String[] line = s.nextLine().split(" ");
            input[i][0] = Integer.parseInt(line[0]);
            input[i][1] = Integer.parseInt(line[1]);
        }
        int count1 = 0;
        int count2 = 0;
        for(int j = 0;j<4;j++){
            count1+= input[j][0];
            count2+= input[j][1];
        }
        int join = count2-count1;
        int promote = 0;
        for(int k = 0;k<3;k++){
            if(k == 0){
                input[k][0]+=join;
                promote = input[k][0]- input[k][1];
                pw.println(promote);
            }else{
                input[k][0] += promote;
                promote = input[k][0]-input[k][1];
                pw.println(promote);
            }
        }
        pw.close();
    }
}