import java.util.*;
public class feedingthecows{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int testcases = Integer.parseInt(s.nextLine());
        int[] answers = new int[testcases];
        String[][] answers2 = new String[testcases][];
        for(int i = 0;i<testcases;i++){
            String[] fline = s.nextLine().split(" ");
            int num = Integer.parseInt(fline[0]);
            int move = Integer.parseInt(fline[1]);

            String[] cows = s.nextLine().split("");
            if(move == 0){
                answers[i] = num;
                answers2[i] = cows;
                continue;
            }
            boolean visitg = false;
            int lastg = 0;
            int firstg = 0;
            int count = 0;
            String[] ans = new String[num];
            for(int x = 0;x<num;x++){
                ans[x] = ".";
            }
            int dist = 0;
            for(int j = 0;j<num;j++){
                if(!visitg){
                    dist = 0;
                    if(cows[j].equals("G")){
                        if(j == num-1){
                            ans[num-1] = "G";
                            count++;
                        }
                        visitg = true;
                        firstg = j;
                        lastg = j;

                    }
                }else{
                    dist++;
                    if (cows[j].equals("G")) {
                        lastg = j;
                    }
                    if(dist> move*2){
                        ans[(lastg-firstg)/2] = "G";
                        visitg = false;
                        count++;
                    }else {
                        if (j == num - 1) {
                            if (cows[j].equals("G")) {
                                ans[num-(j - firstg) / 2-1] = "G";
                            } else {
                                ans[firstg] = "G";
                            }
                            count++;
                        }

                    }

                }
            }
             visitg = false;
             lastg = 0;
             firstg = 0;
             dist = 0;
            for(int k = 0;k<num;k++){
                if(!visitg){
                    if(cows[k].equals("H")){
                        dist = 0;
                        if(k == num-1){
                            if(ans[num-1].equals("G")){
                                ans[num-2] = "H";
                            }else {
                                ans[num - 1] = "H";
                            }
                            count++;
                        }
                        visitg = true;
                        firstg = k;
                        lastg = k;
                    }
                }else{
                    dist++;
                    if (cows[k].equals("H")) {
                        lastg = k;
                    }
                    if(dist>move*2){
                        if(ans[(lastg-firstg)/2].equals("G") && (lastg-firstg)/2!=0){
                            ans[(lastg-firstg)/2-1] = "H";
                        }else if(ans[(lastg-firstg)/2].equals("G") && (lastg-firstg)/2 != num-1) {
                            ans[(lastg-firstg)/2+1] = "H";
                        }else{
                            ans[(lastg-firstg)/2] = "H";
                        }
                        count++;
                        visitg = false;
                    }else {
                        if (k == num - 1) {
                            if (cows[k].equals("H")) {
                                if (ans[num-(k - (firstg / 2))-1].equals("G") && num-(k - firstg) / 2 -1!= 0) {
                                    ans[num-(k - (firstg) / 2 - 2)] = "H";
                                } else if (ans[num-(k - firstg) / 2-1].equals("G") && num-(k - firstg) / 2-1 != num - 1) {
                                    ans[num-(k - firstg / 2) ] = "H";
                                } else {
                                    ans[num-(k - firstg / 2)-1] = "H";
                                }
                            } else {
                                if (ans[firstg].equals("G") && firstg != 0) {
                                    ans[firstg - 1] = "H";
                                } else if (ans[firstg].equals("G") && firstg != num - 1) {
                                    ans[firstg + 1] = "H";
                                } else {
                                    ans[firstg] = "H";
                                }

                            }
                            count++;
                        }

                    }

                }
            }
            answers2[i] = ans;
            answers[i] = count;
        }
        for(int z = 0;z<testcases;z++){
            System.out.println(answers[z]);
            for(int y = 0; y<answers2[z].length; y++){
                    System.out.print(answers2[z][y]);
            }
            System.out.println();
        }
    }
}