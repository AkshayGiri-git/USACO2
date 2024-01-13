import java.util.*;
import java.io.*;
public class censoring{
    static Scanner s;
    static PrintWriter pw;
   public static void main(String[] args){
       try{
           s = new Scanner(new File("censor.in"));
           pw = new PrintWriter(new FileWriter("censor.out"));
       }catch(Exception e){

       }
       String str = s.nextLine();
       String t = s.nextLine();
       int pointer = 0;
       StringBuilder str2 = new StringBuilder();
       for(int i = 0;i<str.length();i++){
           str2.append(str.charAt(i));
           if(str2.length()<t.length()){
               continue;
           }


           if(str2.substring(str2.length()-t.length()).equals(t)) {
               str2.delete(str2.length()-t.length(),str2.length());
           }

       }

       pw.println(str2.toString());
       pw.close();
   }
}