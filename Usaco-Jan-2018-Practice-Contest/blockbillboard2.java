import java.util.*;
import java.io.*;
class blockbillboard2{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner( new File("billboard.in"));
            pw = new PrintWriter( new FileWriter("billboard.out"));

        }catch(IOException e){

        }
        String[] lawn = s.nextLine().split(" ");
        String[] feed = s.nextLine().split(" ");
        int lawnlbotx = Integer.parseInt(lawn[0]);
        int lawnlboty = Integer.parseInt(lawn[1]);
        int lawnrtopx = Integer.parseInt(lawn[2]);
        int lawnrtopy = Integer.parseInt(lawn[3]);
        int feedlbotx = Integer.parseInt(feed[0]);
        int feedlboty = Integer.parseInt(feed[1]);
        int feedrtopx = Integer.parseInt(feed[2]);
        int feedrtopy = Integer.parseInt(feed[3]);
        int tarpheight = 0;
        int tarpwidth = 0;
        boolean width1 = false;
        boolean height1 = false;
        boolean a = false;
        boolean b = false;
        if(lawnlbotx<feedlbotx && lawnrtopx>feedlbotx && feedlboty<lawnrtopy && feedrtopy>lawnrtopy){
            width1 = true;
        }
        if(lawnlbotx<feedrtopx && lawnrtopx>feedrtopx && feedlboty<lawnrtopy && feedrtopy>lawnrtopy){
            width1 = true;
            a = true;
        }
        if(width1 = true){
            tarpwidth = lawnrtopx-lawnlbotx;
        }else{
            if(feedlboty<lawnlboty && feedrtopy>lawnlboty) {
                tarpwidth = lawnrtopx - lawnlbotx;
            }else{
                if(a == true){
                    tarpwidth = lawnrtopx-feedrtopx;
                }else{
                    tarpwidth = feedrtopx-lawnlbotx;
                }
            }
        }
        if(feedlbotx<lawnrtopx && feedrtopx>lawnrtopx && lawnlboty<feedrtopy && lawnrtopy>feedrtopy){
            height1 = true;
        }
        if(feedrtopx<lawnrtopx && feedlbotx>lawnrtopx && lawnlboty<feedrtopy && lawnrtopy>feedrtopy){
            height1 = true;
            b = true;
        }
        if(height1 = true){
            tarpheight = lawnrtopy-lawnlboty;
        }else{
            if(lawnlboty<feedlboty && lawnrtopy>feedlboty) {
                tarpheight = lawnrtopy - lawnlboty;
            }else{
                if(b == true){
                    tarpheight = lawnrtopy-feedrtopy;
                }else{
                    tarpheight = feedrtopy-lawnlboty;
                }

            }
        }
        pw.println(tarpheight*tarpwidth);
        pw.close();
    }
}