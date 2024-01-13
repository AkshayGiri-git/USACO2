import java.util.*;
import java.io.*;
public class wallpainting{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        int ans = 0;
        int a = -1;
        boolean g = false;
        while(true){
            a++;
            if(x==1 || y == 1){
                g = true;
            }

            if((x-1) %2 == 1 || (y-1) %2 == 1||g){
                if(g){
                    ans += Math.pow(4,a);
                }
                System.out.println(ans);
                break;
            }else{
                ans += Math.pow(4,a);
                x = (x-1)/2;
                y = (y-1)/2;


            }
        }
    }
}