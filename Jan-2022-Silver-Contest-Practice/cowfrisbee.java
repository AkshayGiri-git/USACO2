import java.util.*;
public class cowfrisbee{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());
        String[] input = s.nextLine().split(" ");
        int maxheight = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0;i<size;i++){
            for(int j = i+1;j<size;j++){
                if(Integer.min(Integer.parseInt(input[i]),Integer.parseInt(input[j]))>maxheight){
                    ans+= (j-i)+1;
                }
                if(Integer.parseInt(input[j])>maxheight){
                    maxheight = Integer.parseInt(input[j]);
                }
            }
            maxheight = Integer.MIN_VALUE;
        }
        System.out.println(ans);
    }
}