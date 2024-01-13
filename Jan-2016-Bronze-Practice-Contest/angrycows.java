import java.util.*;
import java.io.*;
class angrycows{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("angry.in"));
            pw = new PrintWriter(new FileWriter("angry.out"));
        }catch(Exception e){

        }
        int num = Integer.parseInt(s.nextLine());
        int[] baleloc = new int[num];
        for(int i = 0;i<num;i++){
            baleloc[i] = Integer.parseInt(s.nextLine());
        }
        Arrays.sort(baleloc);
        int exbales = 0;

        int exradius = 1;
        int maxbales = 0;
        for(int j = 0;j<num;j++){
            int expos = baleloc[j];
            for(int k = j+1;k<num;k++){
                if(k == num-1){
                    if(baleloc[k]-exradius <= baleloc[k-1]){
                        exbales = k-j;
                    }
                }else {
                    if(expos+exradius < baleloc[k]){
                        break;
                    }
                    if (expos < (baleloc[k + 1] - exradius)) {
                            expos = baleloc[k];
                            exradius++;
                            exbales = (k - j);
                    }
                }
            }
            exradius = 1;
            expos = baleloc[j];
            int exbales2 = 0;
            for(int l = j-1;l>=0;l--){
                if(l == 0){
                    if(exradius+baleloc[0] >= baleloc[1]) {
                        exbales2 = j;
                    }
                }else {
                    if (expos > baleloc[l]+exradius) {
                        break;
                    }
                    if (expos > (baleloc[l - 1] + exradius)) {

                            expos = baleloc[l];
                            exradius++;
                            exbales2 = (j-l);
                    }
                }
            }

            if(exbales2+exbales+1>maxbales){
                maxbales = exbales+exbales2+1;
            }
            exbales = 0;
            exbales2 = 0;
            exradius = 1;
        }
        pw.println(maxbales);
        pw.close();
    }
}