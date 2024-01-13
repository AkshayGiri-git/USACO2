import java.util.*;
import java.io.*;
public class bucketbrigade{
    static Scanner s;
    static PrintWriter pw;
    public static void main (String[] args){
        try{
            s = new Scanner (new File ("buckets.in"));
            pw = new PrintWriter(new FileWriter("buckets.out"));
        }catch(Exception e){

        }
        String[][] input = new String[10][10];
        for(int i = 0;i<10;i++){
            input[i] = s.nextLine().split("");
        }
        int barnposx = 0;
        int barnposy = 0;
        int rockposx = 0;
        int rockposy = 0;
        int lakeposx = 0;
        int lakeposy = 0;
        for(int j = 0;j<10;j++){
            for(int k = 0;k<10;k++){
                if(input[j][k].equals("B")){
                    barnposx = j;
                    barnposy = k;
                }
                if(input[j][k].equals("R")){
                    rockposx = j;
                    rockposy = k;
                }
                if(input[j][k].equals("L")){
                    lakeposx = j;
                    lakeposy = k;
                }
            }
        }
        if(barnposx == lakeposx && barnposx == rockposx){
            if(barnposy>rockposy){
                if(rockposy>lakeposy){
                    pw.println(Math.abs(barnposy-lakeposy)+1);
                    pw.close();
                }
            }else{
                if(lakeposy>rockposy){
                    pw.println(Math.abs(barnposy-lakeposy)+1);
                    pw.close();
                }
            }

        }
        if(barnposy == lakeposy && barnposy == rockposy){
            if(barnposx>rockposx){
                if(rockposx>lakeposx){
                    pw.println(Math.abs(barnposx-lakeposx)+1);
                    pw.close();
                }
            }else{
                if(lakeposx>rockposx){
                    pw.println(Math.abs(barnposx-lakeposx)+1);
                    pw.close();
                }
            }
        }
        pw.println(Math.abs(barnposx-lakeposx)+Math.abs(barnposy-lakeposy)-1);
        pw.close();

    }
}