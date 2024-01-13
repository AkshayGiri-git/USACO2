import java.util.*;
public class secretmeetings {
    public static void main(String[] args){
        boolean[] time = new boolean[1000];
        Scanner s = new Scanner(System.in);
        String[] bessienum2 = s.nextLine().split(" ");
        int bessienum = Integer.parseInt(bessienum2[0]);
        String[] elsienum2 = s.nextLine().split(" ");
        int elsienum = Integer.parseInt(elsienum2[0]);
        int[][] bessietime = new int[bessienum][2];
        int[][] elsietime = new int[elsienum][2];
        for(int i = 0;i<bessienum*2;i=i+2){
            bessietime[i/2][0] = Integer.parseInt(bessienum2[i+1]);
            bessietime[i/2][1] = Integer.parseInt(bessienum2[i+2]);
            System.out.println(bessietime[i/2][0]);
            System.out.println(bessietime[i/2][1]);
        }
        for(int j = 0;j<elsienum*2;j=j+2){
            elsietime[j/2][0] = Integer.parseInt(elsienum2[j+1]);
            elsietime[j/2][1] = Integer.parseInt(elsienum2[j+2]);
        }

        for(int k = 0;k<bessienum;k++){
            for(int l = bessietime[k][0];l<bessietime[k][1];l++){

                time[l] = true;
            }
        }
        int count = 0;
        for(int m = 0;m<elsienum;m++){
            for(int n = elsietime[m][0];n<elsietime[m][1];n++) {
                if(time[n]){
                    System.out.println(n);
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
