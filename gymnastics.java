import java.util.*;
import java.io.*;
class gymnastics{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner( new File("gymnastics.in"));
            pw = new PrintWriter( new FileWriter ("gymnastics.out"));
        }catch (Exception e){

        }

        String[] scanLine = s.nextLine().split(" ");
        int pracSessions = Integer.parseInt(scanLine[0]);
        int cows = Integer.parseInt(scanLine[1]);
        int[][] rankings = new int[pracSessions][cows];
        for(int i = 0;i<pracSessions;i++){
            scanLine = s.nextLine().split(" ");
            for(int j = 0;j<cows;j++){
                rankings[i][j] = Integer.parseInt(scanLine[j]);
            }
        }
        int firstNum = 0;
        int lastNum = 0;
        int count = 0;
        boolean isConsistent = true;
        for(int k = 0;k<cows;k++){

            for(int l = k+1;l<cows;l++){

                for(int m = 0;m<pracSessions;m++){
                    for(int n = 0;n<cows;n++){
                        if(m == 0){
                            if(rankings[m][n] == l+1){
                                firstNum = l+1;
                                lastNum = k+1;
                                break;
                            }
                            if(rankings[m][n] == k+1){
                                firstNum = k+1;
                                lastNum = l+1;
                                break;
                            }
                        }else{
                            if(rankings[m][n] == firstNum){
                                break;
                            }
                            if(rankings[m][n] == lastNum){
                                isConsistent = false;
                                break;
                            }
                        }
                    }
                    if(isConsistent == false){
                        break;
                    }
                }
                if(isConsistent == true){
                    count++;
                }
                isConsistent = true;
            }
        }
        pw.println(count);
        pw.close();
    }
}