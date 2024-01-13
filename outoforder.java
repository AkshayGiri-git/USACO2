import java.util.*;
import java.io.*;
class outoforder{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
       try{
           s = new Scanner( new File ("outofplace.in"));
           pw = new PrintWriter( new FileWriter("outofplace.out"));
       }catch(Exception e){

       }

       int cows = Integer.parseInt(s.nextLine());
       int[] order = new int[cows];
       for( int i = 0;i<cows;i++){
           order[i] = Integer.parseInt(s.nextLine());
       }
       int bessiePos = -1;
       for(int j = 0;j< cows-1;j++){
           if(order[j]>order[j+1]){
               bessiePos = j+1;
               break;
           }
       }
       int orgBessie = 0;
       for(int k = 0;k<cows;k++){

           if(order[k]>=order[bessiePos]){
               orgBessie = k;
               break;
           }
       }
       System.out.println(orgBessie);

       int count = bessiePos-orgBessie;
       for(int l = bessiePos;l>orgBessie;l--){
           if(order[l] == order[l-1]){
               count--;
           }
       }
       pw.println(count);
       pw.close();
    }
}