import java.util.*;
class juststalling{
    public static void main(String args[]){
        Scanner a = new Scanner(System.in);
        int size = Integer.parseInt(a.nextLine());

        String cowheight = a.nextLine();
        String barnheight = a.nextLine();

        String[] cowheight2 = cowheight.split(" ");
        String[] barnheight3 = barnheight.split(" ");
        int[] barnheight2 = new int[barnheight3.length];
        for(int k = 0;k<barnheight2.length;k++){
            barnheight2[k] = Integer.parseInt(barnheight3[k]);
        }
        Arrays.sort(barnheight2);
        long count = 0;
        long ans = 0;
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(Integer.parseInt(cowheight2[j])<=barnheight2[i]){
                    count++;
                }
            }
            if(ans == 0){
                ans = count;
            }else{
                count = count-i;
                ans = ans*count;
            }
            count = 0;

        }

        System.out.println(ans);
    }
}