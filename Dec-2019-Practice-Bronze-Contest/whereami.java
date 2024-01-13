import java.util.*;
import java.io.*;
public class whereami {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("whereami.in"));
            pw = new PrintWriter(new FileWriter("whereami.out"));
        }catch(Exception e){

        }
        int size = Integer.parseInt(s.nextLine());
        String input = s.nextLine();
        HashMap<String,Integer> duplicate = new HashMap<String,Integer>();
        boolean pass = true;
        boolean pass2 = false;
        for(int i = 1;i<size+1;i++){
            for(int j = 0;j<size+1-i;j++){

                if(duplicate.containsKey(input.substring(j,j+i))){
                    pass = false;
                    break;
                }
                duplicate.put(input.substring(j,j+i),0);
            }
            if(pass){
                pass2 = true;
                pw.println(i);
                pw.close();
                break;
            }
            pass = true;
        }

    }
}