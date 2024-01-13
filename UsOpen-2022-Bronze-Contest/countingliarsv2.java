import java.util.*;
class countingliarsv2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        String[] dir = new String[num];
        int[] point = new int[num];

        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            dir[i] = line[0];
            point[i] = Integer.parseInt(line[1]);
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0;j<num;j++){

            int lies = 0;
            for(int k = 0;k<num;k++){
                if(dir[k].equals("G") && point[j]<point[k]){
                    lies++;
                }else if(dir[k].equals("L") && point[j]>point[k]){
                    lies++;
                }
            }
            if(ans>lies){
                ans = lies;
            }
        }
        System.out.println(ans);
    }
}