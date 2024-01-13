import java.util.*;
import java.io.*;


class mixingmilk{
    static Scanner a;
    static PrintWriter pw;
    public static void main(String args[]){
        try{

            a = new Scanner (new File("mixmilk.in"));

            pw = new PrintWriter(new FileWriter("mixmilk.out"));

        }catch(IOException e){
        }
        String[] bucket12 = a.nextLine().split(" ");
        int[] bucket1 = new int[bucket12.length];
        for(int j = 0;j<bucket1.length;j++){
            bucket1[j] = Integer.parseInt(bucket12[j]);
        }
        String[] bucket22 = a.nextLine().split(" ");
        int[] bucket2 = new int[bucket22.length];
        for(int k = 0;k<bucket2.length;k++){
            bucket2[k] = Integer.parseInt(bucket22[k]);
        }
        String[] bucket32 = a.nextLine().split(" ");
        int[] bucket3 = new int[bucket32.length];
        for(int l = 0;l<bucket1.length;l++){
            bucket3[l] = Integer.parseInt(bucket32[l]);
        }
        int bucketon = 1;
        int storage1 = 0;
        int storage2 = 0;
        int storage3 = 0;
        for(int i = 0;i<100;i++){
            if(bucketon == 4){
                bucketon = 1;
            }
            if(bucketon == 1){
                if(bucket2[0]<bucket1[1]+bucket2[1]){
                    storage1 = bucket2[1];
                    bucket2[1] = bucket2[0];
                    bucket1[1] = bucket1[1]-(bucket2[0]-storage1);
                }else{
                    bucket2[1] = bucket2[1]+bucket1[1];
                    bucket1[1] = 0;
                }
            }
            if(bucketon == 2){
                if(bucket3[0]<bucket2[1]+bucket3[1]){
                    storage2 = bucket3[1];
                    bucket3[1] = bucket3[0];
                    bucket2[1] = bucket2[1]-(bucket3[0]-storage2);
                }else{
                    bucket3[1] = bucket3[1]+bucket2[1];
                    bucket2[1] = 0;
                }
            }
            if(bucketon == 3){
                if(bucket1[0]<bucket3[1]+bucket1[1]){
                    storage3 = bucket1[1];
                    bucket1[1] = bucket1[0];
                    bucket3[1] = bucket3[1]-(bucket1[0]-storage3);
                }else{
                    bucket1[1] = bucket1[1]+bucket3[1];
                    bucket3[1] = 0;
                }
            }
            bucketon++;
        }
        pw.println(bucket1[1]);
        pw.println(bucket2[1]);
        pw.println(bucket3[1]);
        pw.close();
    }
}