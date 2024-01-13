import java.util.*;
import java.io.*;
public class Arena{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] fline = s.nextLine().split(" ");
        int size = Integer.parseInt(fline[0]);
        int[] peoinrom = new int[size];
        for(int i = 0;i<size;i++){
            String[] line2 = s.nextLine().split(" ");
            int line = Integer.parseInt(line2[0]);
            peoinrom[i] = line;
        }
        int count = 0;
        int best = Integer.MAX_VALUE;
        for(int j = 0;j<size;j++){
            for(int k = 0;k<size;k++){
                //System.out.println(k+j%size);
                count += k*peoinrom[(k+j) % size];
            }
            if(count<best){
                best = count;
            }
            System.out.println(count);
            count = 0;
        }
        System.out.println(best);
    }
}