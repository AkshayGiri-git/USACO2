import java.util.*;
import java.io.*;
class mowingfield{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("mowing.in"));
            pw = new PrintWriter(new FileWriter("mowing.out"));
        }catch(Exception e){

        }
        int[][] field = new int[2002][2002];
        int time = 1;
        int num = Integer.parseInt(s.nextLine());
        String[][] input = new String[num][2];
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            input[i][0] = line[0];
            input[i][1] = line[1];
        }
        int x = 1001;
        int y = 1001;
        int minval = Integer.MAX_VALUE;
        field[1001][1001] = 1;
        for(int j = 0;j<num;j++){
            if(input[j][0].equals("N")){
                int l = 0;
                while(l<Integer.parseInt(input[j][1])){
                    y++;
                    l++;
                    time++;
                    if(field[x][y]!=0){
                        if(time-field[x][y]<minval){
                            minval = time-field[x][y];
                            field[x][y] = time;
                        }

                    }else{
                        field[x][y] = time;
                    }
                }
            }else if(input[j][0].equals("E")){
                int m = 0;
                while(m<Integer.parseInt(input[j][1])){
                    x++;
                    m++;
                    time++;
                    if(field[x][y]!=0){
                        if(time-field[x][y]<minval){
                            minval = time-field[x][y];
                            field[x][y] = time;
                        }
                    }else{
                        field[x][y] = time;
                    }
                }
            }else if(input[j][0].equals("S")){
                int n = 0;
                while(n<Integer.parseInt(input[j][1])){
                    y--;
                    n++;
                    time++;
                    if(field[x][y]!=0){
                        if(time-field[x][y]<minval){
                            minval = time-field[x][y];
                            field[x][y] = time;
                        }
                    }else{
                        field[x][y] = time;
                    }
                }
            }else{
                int o = 0;
                while(o<Integer.parseInt(input[j][1])){
                    x--;
                    o++;
                    time++;
                    if(field[x][y]!=0){
                        if(time-field[x][y]<minval){
                            minval = time-field[x][y];
                            field[x][y] = time;
                        }
                    }else{
                        field[x][y] = time;
                    }
                }
            }

        }
        if(minval == Integer.MAX_VALUE){
            pw.println(-1);
        }else{
            pw.println(minval);
        }
        pw.close();
    }
}