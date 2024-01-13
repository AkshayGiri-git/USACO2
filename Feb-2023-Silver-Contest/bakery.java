import java.util.*;
public class bakery{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int testcases = Integer.parseInt(s.nextLine());
        int[] anses = new int[testcases];

        for(int i = 0;i<testcases;i++){
            s.nextLine();
            String[] line = s.nextLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int cookt = Integer.parseInt(line[1]);
            int mufft = Integer.parseInt(line[2]);
            int[][] input = new int[num][3];
            for(int j = 0;j<num;j++){
                String[] line2 = s.nextLine().split(" ");
                input[j][0] = Integer.parseInt(line2[0]);
                input[j][1] = Integer.parseInt(line2[1]);
                input[j][2] = Integer.parseInt(line2[2]);
            }
            int best = 0;
            boolean exit = false;
            for(int k = 0;k<=cookt;k++){
                int besty = Integer.MAX_VALUE;
                int x = 0;
                for(int l = 0;l<num;l++){
                    if(input[l][0]*k>input[l][2]){
                        exit = true;
                        break;
                    }

                    int y = (input[l][2]-(input[l][0]*k))/input[l][1];

                    if(y<besty){
                        besty = y;
                    }


                }
                if(exit){
                    break;
                }
                x = k;
                if(x>cookt){
                    x = cookt;
                }
                if(besty>mufft){
                    besty = mufft;
                }
                if(x+besty>best){
                    best = x+besty;

                }
            }
            anses[i] = (cookt+mufft)-best;
        }
        for(int z = 0;z<anses.length;z++){
            System.out.println(anses[z]);
        }
    }
}