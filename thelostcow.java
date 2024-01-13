import java.util.*;
import java.io.*;
class thelostcow {
    static Scanner s;
    static PrintWriter pw;
    public static void main (String args[] ){
        try{
            s = new Scanner ( new File("lostcow.in"));
            pw = new PrintWriter( new FileWriter("lostcow.out"));
        }catch(Exception e){

        }

        String[] line = s.nextLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        int prevdist = 0;
        int posdir = 1;
        int dist = 0;
        int prevx = 0;

        for(int i = 1;true;i = i*2){
            prevx = x;
            x += (i*posdir)+(prevdist*posdir);
            dist += i+prevdist;
            prevdist = i;

            System.out.println(x);
            System.out.println(dist);
            System.out.println(prevdist);
            if(posdir == 1){
                if(x>=y && y>prevx){
                    dist = dist-(x-y);
                    break;
                }else{
                    posdir = -1;
                }
            }else{
                if(x<=y && y<prevx){
                    dist = dist-(y-x);
                    break;
                }else{
                    posdir = 1;
                }
            }

        }

        pw.println(dist);
        pw.close();
    }
}