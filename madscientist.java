import java.util.*;
import java.io.*;
class madscientist{
    static PrintWriter pw;
    static Scanner s;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("breedflip.in"));
            pw = new PrintWriter(new FileWriter("breedflip.out"));
        }catch(Exception e){

        }
        int num = Integer.parseInt(s.nextLine());
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        int[] diffs = new int[str1.length()];
        int count = 0;
        for(int i = 0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                diffs[i] = 1;
            }else{
                diffs[i] = 0;
            }
        }
        boolean on = false;
        for(int j = 0;j<diffs.length;j++){
            if(!on && diffs[j] == 1) {
                count++;
                on = true;
            }else if(on && diffs[j] == 0){
                on = false;
            }
        }
        pw.println(count);
        pw.close();
    }
}