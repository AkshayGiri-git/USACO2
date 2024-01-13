import java.util.*;
public class photo2{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int length = Integer.parseInt(s.nextLine());
        String [] a = s.nextLine().split(" ");
        String[] b = s.nextLine().split(" ");
        boolean[] moved = new boolean[length+1];
        int acount = 0;
        int answer = 0;
        for(int i = 0;i<length;i++){
            while(moved[Integer.parseInt(a[acount])]){
                acount++;
            }
            if(b[i] .equals( a[acount])){
                acount++;
            }else{
                moved[Integer.parseInt(b[i])] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
}