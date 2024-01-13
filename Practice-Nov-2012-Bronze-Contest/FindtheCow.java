import java.io.*;
import java.util.*;
class FindtheCow{

    static Scanner s;
    static PrintWriter pw;


    public static void main(String [] args){
            try{

                s = new Scanner (new File("cowfind.in"));

                pw = new PrintWriter(new FileWriter("cowfind.out"));

            }catch(IOException e){
            }
            String pattern = s.next();
            char[] charpattern = pattern.toCharArray();
            int hindcount = 0;
            int count = 0;
            for(int i = 1;i<charpattern.length;i++){
                if(charpattern[i-1] == ')'&& charpattern [i] == ')'){
                    count = count+hindcount;
                }
                if(charpattern[i-1] == '(' && charpattern[i] == '('){
                    hindcount++;
                }
            }

            pw.println(count);
            pw.close();



    }
}


