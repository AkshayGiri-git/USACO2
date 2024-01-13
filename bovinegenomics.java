import java.util.*;
import java.io.*;
public class bovinegenomics {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("cownomics.in"));
            pw = new PrintWriter(new FileWriter("cownomics.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        String[] firstLine = s.nextLine().split(" ");
        int num1 = Integer.parseInt(firstLine[0]);
        int num2 = Integer.parseInt(firstLine[1]);
        String[][] input = new String[num1*2][num2];
        for(int i = 0;i<num1*2;i++){
            String[] line = s.nextLine().split("");
            for(int j = 0;j<num2;j++){
                input[i][j] = line[j];
            }
        }
        boolean c = false;
        boolean g = false;
        boolean t = false;
        boolean a = false;
        boolean done = false;
        int ans = 0;
        for(int l = 0;l<num2;l++) {
            for (int k = 0; k < num1*2; k++) {
                if(k<num1){
                    if(input[k][l].equals("A")){
                        a = true;
                    }else if(input[k][l].equals("T")){
                        t = true;
                    }else if(input[k][l].equals("C")){
                        c = true;
                    }else{
                        g = true;
                    }
                }else{
                    if(input[k][l].equals("A") && a){
                        done = true;
                        break;
                    }else if(input[k][l].equals("T") && t){
                        done = true;
                        break;
                    }else if(input[k][l].equals("C") && c){
                        done = true;
                        break;
                    }else if(input[k][l].equals("G") && g){
                        done = true;
                        break;
                    }
                }
            }
            if(!done){
                ans++;
            }
            a = false;
            t = false;
            c = false;
            g = false;
            done = false;

        }
        pw.println(ans);
        pw.close();
    }
}
