import java.util.*;
import java.io.*;
class cowtipping {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args) {
        try{
            s = new Scanner(new File("cowtip.in"));
            pw = new PrintWriter(new FileWriter("cowtip.out"));
        }catch(Exception e){

        }

        int num = Integer.parseInt(s.nextLine());
        int[][] input = new int[num][num];
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split("");
            for(int j = 0;j<num;j++){
                input[i][j] = Integer.parseInt(line[j]);
            }
        }
        int row = num-1;
        int column = num-1;
        int ans = 0;
        for(int k = column;k>=0;k--){
            column = k;
            row = num-1;
            while(row< num && column<num && row>=0 && column>=0){
                if(input[row][column] == 1){
                    ans++;
                    for(int m = 0;m<=row;m++){
                        for(int n = 0;n<=column;n++){
                            if(input[m][n] == 0){
                                input[m][n] = 1;
                            }else{
                                input[m][n] = 0;
                            }
                        }
                    }

                }
                row--;
                column++;
            }
        }
        for(int z = num-1;z>=0;z--){
            row = z;
            column = 0;
            while(row< num && column<num && row>=0 && column>=0){
                if(input[row][column] == 1){
                    ans++;
                    for(int m = 0;m<=row;m++){
                        for(int n = 0;n<=column;n++){
                            if(input[m][n] == 0){
                                input[m][n] = 1;
                            }else{
                                input[m][n] = 0;
                            }
                        }
                    }

                }
                row--;
                column++;
            }
        }
        pw.println(ans);
        pw.close();
    }
}