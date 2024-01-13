import java.util.*;
public class sleeping{
    static Scanner s = new Scanner(System.in);
    static int[] a;
    static int pos = 0;
    public static void solve (){

        int length = Integer.parseInt(s.nextLine());
        String[] log2 = s.nextLine().split(" ");
        int sum = 0;
        int[] log = new int[log2.length];
        for(int j = 0;j<log.length;j++){
            log[j] = Integer.parseInt(log2[j]);
            sum += log[j];
        }
        for(int i = length;i>0;i--){
            if(sum % i == 0){
                boolean split = true;
                int currsum = 0;
                for(int k = 0;k<length;k++){
                    currsum += log[k];
                    if(currsum > sum/i){
                        split = false;
                    }
                    if(currsum == sum/i){
                        currsum = 0;
                    }

                }
                if(split){
                    a[pos] = length-i;
                    return;
                }
            }
        }
    }
    public static void main(String[] args){
        int testnum = Integer.parseInt(s.nextLine());
        a = new int[testnum];
        for(int i = 0;i<testnum;i++){
            solve();
            pos++;
        }
        for (int i : a) {
            System.out.println(i);
        }
    }
}