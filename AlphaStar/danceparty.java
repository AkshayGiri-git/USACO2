import java.util.*;
import java.io.*;
public class danceparty {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        int[] x = new int[a];
        int[] y = new int[a];
        for(int i = 0;i<a;i++){
            String[] line = s.nextLine().split(" ");
            x[i] = Integer.parseInt(line[0]);
            y[i] = Integer.parseInt(line[1]);
        }
        int best1 = 0;
        int best2 = 0;
        double bestnum = 0;
        double curr = 0;
        for(int j = 0;j<a;j++){
            for(int k = j+1;k<a;k++){
                curr = Math.sqrt(Math.pow((double)Math.abs(x[j]-x[k]),2)+Math.pow((double)Math.abs(y[k]-y[j]),2));

                if(curr>bestnum){
                    bestnum = curr;
                    best1 = j;
                    best2= k;
                }
            }
        }
        System.out.println(best1+1+" "+best2);
    }
}
