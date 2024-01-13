import java.util.*;
class aircownditioning{
    static Scanner s;
    public static void main (String[] args){
        s = new Scanner(System.in);
        int cows = Integer.parseInt(s.nextLine());
        String[] pTemp = s.nextLine().split(" ");
        String[] temp = s.nextLine().split(" ");
        int[] tempDiff = new int[cows];
        for(int i = 0;i<cows;i++){
            tempDiff[i] = Integer.parseInt(pTemp[i]) - Integer.parseInt(temp[i]);

        }
        boolean addOrSub = true;
        int streak = 0;
        int k = 0;
        while(true) {
            for (int j = 0; j < cows; j++) {

                if (tempDiff[j] > 0) {
                    if(streak != 0){
                        if(addOrSub == false){
                            break;
                        }
                    }
                    addOrSub = true;
                    tempDiff[j]--;
                    streak = 1;
                }else if(tempDiff[j] < 0){
                    if(streak != 0){
                        if(addOrSub == true){
                            break;
                        }
                    }
                    addOrSub = false;
                    tempDiff[j]++;
                    streak = 1;
                }else if(tempDiff[j] == 0){
                    if(streak == 1){
                        break;
                    }
                }

            }

            if(streak == 0){
                break;
            }
            streak = 0;
            k++;
        }
        System.out.println(k);
    }

}