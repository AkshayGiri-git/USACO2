import java.util.*;
public class secretmeetingsv2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] bessie2 = s.nextLine().split(" ");
        String[] elsie2 = s.nextLine().split(" ");
        int[][] bessie = new int[(bessie2.length-1)/2][2];
        int[][] elsie = new int[(elsie2.length-1)/2][2];
        for(int i = 0;i<bessie2.length-1;i=i+2){
            bessie[i/2][0] = Integer.parseInt(bessie2[i+1]);
            bessie[i/2][1] = Integer.parseInt(bessie2[i+2]);
        }
        for(int j = 0;j<elsie2.length-1;j=j+2){
            elsie[j/2][0] = Integer.parseInt(elsie2[j+1]);
            elsie[j/2][1] = Integer.parseInt(elsie2[j+2]);
        }


        int count = 0;
        for(int k = 0;k<(bessie2.length-1)/2;k++){
            for(int l = 0;l<(elsie2.length-1)/2;l++){
                if(bessie[k][0] >= elsie[l][0] && elsie[l][1]>bessie[k][0]){
                    if(bessie[k][1] > elsie[l][1]){

                        count += elsie[l][1]-bessie[k][0];
                    }else{

                        count+= bessie[k][1] - bessie[k][0];

                    }
                }
                else if(elsie[l][0] >= bessie[k][0] && bessie[k][1]>elsie[l][0]){
                    if(elsie[l][1] > bessie[k][1]){

                        count+= bessie[k][1] - elsie[l][0];
                    }else{

                        count+= elsie[l][1] - elsie[l][0];
                    }

                }
            }
        }
        System.out.println(count);
    }
}
