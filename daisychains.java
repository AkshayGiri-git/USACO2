import java.util.*;
public class daisychains{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        int[] input = new int[num];
        String[] input2 = s.nextLine().split(" ");
        for(int i = 0;i<num;i++){
            input[i] = Integer.parseInt(input2[i]);
        }
        int num2 = 0;
        int ans = num;
        for(int j = 0;j<num;j++){
            num2 = input[j];
            for(int k = j+1;k<num;k++){
                num2+=input[k];

                for(int l = j;l<=k;l++){
                    if(num2%(k-j+1) != 0){
                        break;
                    }else{
                        if(input[l] == num2/(k-j+1)){
                            ans++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}