import java.util.*;
import java.io.*;


class photoshoot {
    static Scanner s;
    static PrintWriter pw;

    public static void main(String args[]) {
        try {

            s = new Scanner(new File("photo.in"));

            pw = new PrintWriter(new FileWriter("photo.out"));

        } catch (IOException e) {
        }
        int cows = Integer.parseInt(s.nextLine());

        String[] numbers1 = s.nextLine().split(" ");
        int[] numbers2 = new int[numbers1.length];
        int[] answer = new int[cows];
        boolean[] taken = new boolean[cows];

        boolean worked = true;
        for(int i = 0;i<numbers1.length;i++){
            numbers2[i] = Integer.parseInt(numbers1[i]);


        }
        for(int j = 1;j<numbers2[0];j++){
            answer[0] = j;

            taken[j-1] = true;
            for(int k = 1;k<cows;k++){
                if(numbers2[k-1]-answer[k-1]>taken.length || numbers2[k-1]-answer[k-1]< 1 ){
                    worked = false;
                    break;
                }
                if(taken[numbers2[k-1]-answer[k-1]-1] == false){

                    answer[k] = numbers2[k-1]-answer[k-1];
                    taken[numbers2[k-1]-answer[k-1]-1] = true;
                }else{

                    worked = false;
                    break;
                }
            }
            if(worked == true){
                break;
            }else{
                taken = new boolean[cows];

            }
            worked = true;
        }
        for(int l = 0;l<cows;l++){
            if(l == cows-1){
                pw.print(answer[l]);
            }else {
                pw.print(answer[l] + " ");
            }
        }
        pw.close();
    }
}