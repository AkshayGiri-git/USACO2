import java.util.*;
import java.io.*;
class COW{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("cow.in"));
            pw = new PrintWriter(new FileWriter("cow.out"));
        }catch(Exception e){

        }
        String size = s.nextLine();
        String str = s.nextLine();
        long count1 = 0;
        long count2 = 0;
        long count3 = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == 'C'){
                count1++;
            }
            if(str.charAt(i) == 'O'){
                count2+=count1;
            }
            if(str.charAt(i) == 'W'){
                count3+= count2;
            }
        }
        pw.println(count3);
        pw.close();
    }
}