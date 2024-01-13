/*
ID: superak3
LANG: JAVA
TASK: test
*/
import java.util.*;
import java.io.*;
class rideishere {
    static Scanner s;
    static PrintWriter pw;
    public static void main (String[] args){
        try{
            s = new Scanner(new File("ride.in"));
            pw = new PrintWriter(new FileWriter("ride.out"));
        }catch(Exception e){

        }
        String [] comet = s.nextLine().split("");
        String [] group = s.nextLine().split("");
        int cometint = 1;
        int groupint = 1;
        char a = 'c';
        int b = 0;
        char c = 'c';
        int d = 0;
        for(int i = 0;i<6;i++){
            if(i != comet.length) {
                a = comet[i].charAt(0);
                b = ((int) a) - 64;
                cometint *= b;
            }
            if(i != group.length){
                c = group[i].charAt(0);
                d = ((int) c) - 64;
                groupint *= d;
            }
        }
        cometint = cometint%47;
        groupint = groupint%47;
        if(cometint == groupint){
            pw.println("GO");
            pw.close();
        }else{
            pw.println("STAY");
            pw.close();
        }
    }
}
