import java.util.*;
import java.io.*;
class bovileshuffle{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner( new File("shuffle.in"));
            pw = new PrintWriter( new FileWriter("shuffle.out"));
        }catch(Exception e){

        }

        int cows = Integer.parseInt(s.nextLine());
        String[] order = s.nextLine().split(" ");
        String[] ids = s.nextLine().split(" ");
        String[] transfer = new String[cows];

        for(int i = 0;i<3;i++){

            for(int j = 0;j<cows;j++) {

                 transfer[j] = ids[Integer.parseInt(order[j])-1] ;
            }
            for(int k = 0;k<cows;k++){
                ids[k] = transfer[k];
            }
        }
        for(int l = 0;l<cows;l++){
            pw.println(transfer[l]);
        }
        pw.close();
    }
}