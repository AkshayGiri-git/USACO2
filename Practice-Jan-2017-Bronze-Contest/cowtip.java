import java.util.*;
import java.io.*;
class cowtip{
static Scanner s;
static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner( new File("cowtip.in"));
            pw = new PrintWriter( new FileWriter("cowtip.out"));
        }catch(Exception e){

        }
        int n = Integer.parseInt(s.nextLine());
        int[][] tipped = new int[n][n];
        for(int i = 0;i<n;i++){
            String[] line = s.nextLine().split("");
            for(int j = 0;j<n;j++){
                tipped[i][j] = Integer.parseInt(line[j]);
            }
        }
        boolean turnopp = false;
        int whenturn = 0;
        boolean noones = true;
        int k = 0;
        for(k = 0;true;k++){
            for(int j = n-1;j>=0;j--){
                for(int l = n-1;l>=0;l--){
                    System.out.println(turnopp);
                    if(turnopp == true && tipped[j][whenturn] == 0){
                        break;
                    }

                        if (turnopp == true && l<= whenturn) {
                            System.out.println("hello2");
                            if (tipped[j][l] == 0) {
                                tipped[j][l] = 1;
                            } else {
                                tipped[j][l] = 0;
                            }
                        } else {

                            if(turnopp != true) {
                                if (tipped[j][l] == 1) {
                                    turnopp = true;
                                    System.out.println("hello");
                                    //System.out.println(l);
                                    //System.out.println(j);
                                    whenturn = l;
                                    tipped[j][l] = 0;
                                    noones = false;
                                }
                            }
                        }

                }

            }

            if(noones == true){
                break;
            }
            turnopp = false;
            whenturn = 0;
        }
        pw.println(k-1);
        pw.close();
    }
}