import java.util.*;
import java.io.*;
class hps{
static Scanner s;
static PrintWriter pw;
    public static void main( String[] args){
        try{
            s = new Scanner( new File("hps.in"));
            pw = new PrintWriter( new FileWriter("hps.out"));
        }catch(Exception e){

        }
        int n = Integer.parseInt(s.nextLine());
        int win = 0;
        int win2 = 0;
        String[] plays = new String[n];
        for(int i = 0;i<n;i++){
            plays[i] = s.nextLine();
            String[] line = plays[i].split(" ");
            int p1 = Integer.parseInt(line[0]);
            int p2 = Integer.parseInt(line[1]);
            if(p1 == 1 && p2 == 2){
                win++;
            }else if(p1 == 2 && p2 == 3){
                win++;
            }else if(p1 == 3 && p2 == 1){
                win++;
            }
        }
        for(int j = 0;j<n;j++){
            String[] line2 = plays[j].split(" ");
            int p1 = Integer.parseInt(line2[0]);
            int p2 = Integer.parseInt(line2[1]);
            if(p1 == 2 && p2 == 1){
                win2++;
            }else if(p1 == 3 && p2 == 2){
                win2++;
            }else if(p1 == 1 && p2 == 3){
                win2++;
            }
        }
        if(win>win2){
            pw.println(win);
        }else{
            pw.println(win2);
        }
        pw.close();
    }
}