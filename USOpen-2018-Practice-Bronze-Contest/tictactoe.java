import java.util.*;
import java.io.*;
class tictactoe{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("tttt.in"));
            pw = new PrintWriter(new FileWriter("tttt.out"));
        }catch(Exception e){

        }
        String[][] input = new String[3][3];
        for(int i = 0;i<3;i++){
            String[] line = s.nextLine().split("");
            input[i][0] = line[0];
            input[i][1] = line[1];
            input[i][2] = line[2];
        }
        int induvidual = 0;
        int team = 0;
        String cow1 = "";
        String cow2 = "";
        String cow3 = "";
        HashMap<String,Integer> won = new HashMap<String,Integer>();
        for(int i = 0;i<3;i++) {
             cow1 = input[i][0];
             cow2 = input[i][1];
             cow3 = input[i][2];
            if (cow1.equals(cow2) && cow2.equals(cow3)) {
                if (!won.containsKey(cow1)) {
                    won.put(cow1, 0);
                    induvidual++;
                }
            } else if (cow1.equals(cow2)) {
                if (!won.containsKey(cow1 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow1)) {
                    won.put(cow1+"+"+cow3,0);
                    team++;
                }
            }else if(cow2.equals(cow3)){
                if (!won.containsKey(cow1 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow1)) {
                    won.put(cow1+"+"+cow3,0);
                    team++;
                }
            }else if(cow1.equals(cow3)){
                if (!won.containsKey(cow2 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow2)) {
                    won.put(cow2+"+"+cow3,0);
                    team++;
                }
            }
        }
        for(int j = 0;j<3;j++) {
             cow1 = input[0][j];
             cow2 = input[1][j];
             cow3 = input[2][j];
            if (cow1.equals(cow2) && cow2.equals(cow3)) {
                if (!won.containsKey(cow1)) {
                    won.put(cow1, 0);
                    induvidual++;
                }
            } else if (cow1.equals(cow2)) {
                if (!won.containsKey(cow1 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow1)) {
                    won.put(cow1+"+"+cow3,0);
                    team++;
                }
            }else if(cow2.equals(cow3)){
                if (!won.containsKey(cow1 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow1)) {
                    won.put(cow1+"+"+cow3,0);
                    team++;
                }
            }else if(cow1.equals(cow3)){
                if (!won.containsKey(cow2 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow2)) {
                    won.put(cow2+"+"+cow3,0);

                    team++;
                }
            }
        }
        for(int k = 0;k<2;k++) {
            if(k == 0) {
                 cow1 = input[0][0];
                 cow2 = input[1][1];
                 cow3 = input[2][2];
            }else{
                 cow1 = input[0][2];
                 cow2 = input[1][1];
                 cow3 = input[2][0];
            }
            if (cow1.equals(cow2) && cow2.equals(cow3)) {
                if (!won.containsKey(cow1)) {
                    won.put(cow1, 0);
                    induvidual++;
                }
            } else if (cow1.equals(cow2)) {
                if (!won.containsKey(cow1 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow1)) {
                    won.put(cow1 + "+" + cow3, 0);

                    team++;
                }
            } else if (cow2.equals(cow3)) {
                if (!won.containsKey(cow1 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow1)) {
                    won.put(cow1 + "+" + cow3, 0);

                    team++;
                }
            } else if (cow1.equals(cow3)) {
                if (!won.containsKey(cow2 + "+" + cow3) && !won.containsKey(cow3 + "+" + cow2)) {
                    won.put(cow2 + "+" + cow3, 0);
                    team++;
                }
            }
        }
        pw.println(induvidual);
        pw.println(team);
        pw.close();
    }
}