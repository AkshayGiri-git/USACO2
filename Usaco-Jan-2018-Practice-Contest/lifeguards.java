import java.util.*;
import java.io.*;
class lifeguards{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        boolean[] time = new boolean[1001];
        try{
            s = new Scanner( new File ("lifeguards.in"));
            pw = new PrintWriter( new FileWriter("lifeguards.out"));
        }catch(Exception e){

        }
        int lifeguardsnum = Integer.parseInt(s.nextLine());
        int[][] input = new int[lifeguardsnum][2];
        for(int j = 0;j<lifeguardsnum;j++){
            String[] line = s.nextLine().split(" ");
            input[j][0] = Integer.parseInt(line[0]);

            input[j][1] = Integer.parseInt(line[1]);

        }
        int timecount = 0;
        int maxtimecount = 0;
        for(int i = 0;i<lifeguardsnum;i++){
            for(int k = 0;k<lifeguardsnum;k++){
                if(i == k){

                }else {
                    for (int l = input[k][0]; l < input[k][1]; l++) {
                        time[l] = true;

                    }
                }
            }
            for(int m = 0;m<1001;m++){
                if(time[m] == true){
                    timecount++;
                }
            }
            if(timecount>maxtimecount){
                maxtimecount = timecount;
            }
            System.out.println(timecount);
            timecount = 0;
            time = new boolean [1001];
        }
        pw.println(maxtimecount);
        pw.close();

    }
}