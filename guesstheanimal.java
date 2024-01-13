import java.util.*;
import java.io.*;
public class guesstheanimal {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("guess.in"));
            pw = new PrintWriter(new FileWriter("guess.out"));
        }catch(Exception e){
            System.out.println("hello");

        }
        int animals = Integer.parseInt(s.nextLine());
        String[][] character = new String[animals][];
        for(int i = 0;i<animals;i++){
            String[] line = s.nextLine().split(" ");
            character[i] = new String[Integer.parseInt(line[1])];
            for(int j = 0;j<character[i].length;j++){
                character[i][j] = line[j+2];
            }
        }
        int best = 0;
        int count = 0;
        boolean exit = false;
        for(int k = 0;k<animals;k++){
            for(int l = 0;l<character[k].length;l++){
                for(int m = 0;m<animals;m++){
                    if(m != k) {
                        for (int n = 0; n < character[m].length; n++) {
                            if (character[m][n].equals(character[k][l])) {
                                exit = true;
                                count++;
                                break;
                            }
                        }
                        if (exit) {
                            break;
                        }
                    }
                }
                exit = false;
            }
            if(count<character[k].length){
                count++;
            }

            if(count>best){
                best = count;
            }
            count = 0;
        }
        pw.println(best);
        pw.close();
    }
}
