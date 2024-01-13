import java.util.*;
class drought{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int testcases = Integer.parseInt(s.nextLine());
        int[] ans = new int[testcases];
        for(int i = 0;i<testcases;i++){
            int cows = Integer.parseInt(s.nextLine());
            String pattern3 = s.nextLine();
            String[] pattern2 = pattern3.split(" ");
            int[] difference = new int[cows-1];
            boolean pass = true;

            int[] pattern = new int[pattern2.length];
            int least = 0;
            for(int j = 0;j<cows;j++){
                if(cows % 2 == 0) {

                    pattern[j] = Integer.parseInt(pattern2[j]);

                    if(j == 0){
                        least = pattern[j];
                    }else{
                        if(pattern[j]<least){
                            least = pattern[j];
                        }
                    }
                    if(j != 0){
                        difference[j-1] = pattern[j]-pattern[j-1];
                    }
                    if (j >= (cows / 2)+1) {
                        if(difference[j-(cows/2)-1] != pattern[j]){
                            ans[i] = -1;
                            pass = false;
                            break;
                        }
                    }
                }else{
                    pattern[j] = Integer.parseInt(pattern2[j]);
                    if(j == 0){
                        least = pattern[j];
                    }else{
                        if(pattern[j]<least){
                            least = pattern[j];
                        }
                    }
                    if(j>= (cows/2)+1){
                        if(pattern[j-cows/2] != pattern[j]) {
                            if(cows == 3){
                                if(pattern[1]>pattern[0] && pattern[1]>pattern[2]){

                                }else{
                                    ans[i] = -1;
                                    pass = false;
                                    break;
                                }
                            }else {
                                ans[i] = -1;
                                pass = false;
                                break;
                            }
                        }
                    }
                }
            }
            for(int l = 0;l<1;l++){

                if(pass == false){
                    break;
                }
                if(pattern[pattern.length-2]<pattern[pattern.length-1]){

                    break;
                }else{


                    boolean a = false;
                    int cornbags = 0;
                    int[] pattern4 = pattern;

                    for(int n = least;n>=0;n--) {
                        for (int m = cows - 1; m >= 1;m--) {

                            if (pattern4[m] > pattern4[m - 1]) {

                                break;
                            }

                                pattern4[m] = pattern4[m] - (pattern4[m]-n);
                                pattern4[m - 1] = pattern4[m-1] - (pattern4[m]-n);
                                cornbags += pattern4[m]- n;
                                if (i == 0) {
                                    System.out.println(pattern4[m]);
                                    System.out.println(pattern4[m-1]);
                                }
                            if (m == 1) {
                                ans[i] = cornbags;
                                break;
                            }
                            if(n == 0){
                                ans[i] = -1;
                            }
                        }
                        pattern4 = pattern;
                    }
                }
            }
        }
        for(int z = 0;z<testcases;z++){
            System.out.println(ans[z]);
        }
    }
}