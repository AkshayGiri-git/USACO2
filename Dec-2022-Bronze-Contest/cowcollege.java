import java.util.*;
public class cowcollege{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        String[] input = s.nextLine().split(" ");
        long[] pay = new long[num];
        for(int i = 0;i<num;i++){
            pay[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(pay);
        long max = 0;
        long pay2 = 0;
        for(int j = 0;j<num;j++){
            if(pay[j]*(num-j)>max){
                max = pay[j]*(num-j);
                pay2 = pay[j];
            }
        }
        System.out.println(max+" "+pay2);
    }
}