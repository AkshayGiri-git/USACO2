import java.util.*;
public class primesquares {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        int i = 1;
        int numincol = num;
        int numforcol = 1;
        int colnum = 1;
        int sum;
        int ans = 0;
        while(i <= 3*num*(num-1)+1){

            if(numforcol>numincol){
                if(colnum>=num){
                    numincol--;
                }else {
                    numincol++;
                }
                numforcol = 1;
                colnum++;
            }

            if(numincol != num && numforcol != 1) {
                if(colnum<num){
                    sum = i+(i-1)+(i-numincol)+(i+numincol);
                }else if(colnum == num){
                    sum = i+(i-1)+(i-numincol)+(i+(numincol-1));
                }else{
                    sum = i+(i-1)+(i-(numincol+1))+(i+(numincol-1));
                }
                if(isprime(sum)){
                    ans++;

                }
            }
            numforcol++;
            i++;
        }
        System.out.println(ans);
    }
    public static boolean isprime(int num){
        int sqroot = (int) Math.sqrt(num);
        for(int i = 2;i<=sqroot;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
