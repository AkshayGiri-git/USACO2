import java.util.*;
class photoshootusopen{
    public static void main(String[] args){
        Scanner s = new Scanner (System.in);
        int num = Integer.parseInt(s.nextLine());
        String[] chars = s.nextLine().split("");
        int ans = 0;
        for(int i = num-1;i>=0;i= i-2){
            if(ans %2 == 0){
                if(chars[i].equals("H") && chars[i-1].equals("G")){
                    ans++;
                }
            }else{
                if(chars[i].equals("G") && chars[i-1].equals("H")){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}