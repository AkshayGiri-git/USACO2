import java.util.*;
import java.io.*;
class traffic{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner(new File("traffic.in"));
            pw = new PrintWriter(new FileWriter("traffic.out"));
        }catch(Exception e){

        }

    }
}