import java.util.*;
public class cowshoes {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] want = {"B","B","B","B","D","D","D","D","E","E","E","E"};
        String[] have = s.nextLine().split(" ");
        int count = 0;
        for(int i = 0;i<12;i++){
            if(want[i].equals (have[i])){

            }else{
                count++;
            }
        }

        System.out.println(count/2);
    }
}
