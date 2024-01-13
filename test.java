import java.util.*;
public class test{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] freqx1 = new int[m+1];
        int[] freqx2 = new int[m+1];

        for(int i = 0;i<n;i++){
            String[] line2 = s.nextLine().split(" ");
            freqx1[Integer.parseInt(line2[0])]++;
            freqx2[Integer.parseInt(line2[1])]++;
        }
        int[] diffA = new int[(2*m)+1];
        for(int j = 0;j<m;j++){
            for(int k = 0;k<m;k++){
                diffA[j+k] += freqx1[j]*freqx1[k];
                diffA[j+k+1] -= freqx2[j]*freqx2[k];
            }
        }
        int sum = 0;
        for(int z = 0;z<diffA.length;z++){
            sum+=diffA[z];
            System.out.println(sum);
        }
    }
}
