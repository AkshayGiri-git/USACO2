import java.util.*;
import java.io.*;
public class milkingorder {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("coworder.in"));
            pw= new PrintWriter(new FileWriter("coworder.out"));
        }catch(Exception e){
            System.out.println("hello");

        }
        String[] firstLine = s.nextLine().split(" ");
        int cows = Integer.parseInt(firstLine[0]);
        int numhigh = Integer.parseInt(firstLine[1]);
        int numpos = Integer.parseInt(firstLine[2]);
        int[] idealpos = new int[cows];
        int[] startzones = new int[numhigh];
        int[] endzones = new int[numhigh];
        int[] numempty = new int[cows];
        String[] hierarchy2 = s.nextLine().split(" ");
        int[] hierarchy = new int[numhigh];
        for(int i = 0;i<numpos;i++){
            String[] line = s.nextLine().split(" ");
            idealpos[Integer.parseInt(line[1])-1] = Integer.parseInt(line[0]);
        }
        int emspots = cows-numpos;
        for(int j = 0;j<cows;j++){
            if(idealpos[j] == 0) {
                emspots--;
            }
            numempty[j] = emspots;
            if(j<numhigh){
                hierarchy[j] = Integer.parseInt(hierarchy2[j]);
            }
        }
        int highpoint = 0;

        for(int k = 0;k<cows;k++){
            if(highpoint != hierarchy.length-1) {
                if(numempty[k] != hierarchy.length-highpoint)
                if (idealpos[k] == hierarchy[highpoint]) {
                    startzones[k] = hierarchy[highpoint];

                }
                if(idealpos[k] == hierarchy[highpoint+1]){
                    endzones[k] = hierarchy[highpoint+1];
                    highpoint++;
                }
            }


        }
    }
}
