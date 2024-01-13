import java.util.*;
class herdle{
    public static void main (String args[]){
        Scanner s = new Scanner(System.in);
        char[][] guess = new char[3][3];
        char[][] actual = new char[3][3];
        HashMap<String,Integer> count = new HashMap<String,Integer>();
        for(int i = 0;i<3;i++){
            String[] line = s.nextLine().split("");
            for(int j = 0;j<3;j++){
                actual[i][j] = line[j].charAt(0);
                if(count.containsKey(line[j])) {
                    count.replace(line[j],count.get(line[j])+1);
                }else{
                    count.put(line[j],1);
                }
            }
        }
        int yellow = 0;
        for(int k = 0;k<3;k++){
            String[] line2 = s.nextLine().split("");
            for(int l = 0;l<3;l++){
                guess[k][l] = line2[l].charAt(0);
                if(count.containsKey(line2[l])){
                    if(count.get(line2[l]) != 0){
                        yellow++;
                        count.replace(line2[l],count.get(line2[l])-1);
                    }
                }
            }
        }
        int green = 0;
        for(int m= 0;m < 3;m++){
            for(int n = 0; n<3;n++){
                if(actual[m][n] == guess[m][n]){
                    green++;
                    yellow--;
                }
            }
        }
        System.out.println(green);
        System.out.println(yellow);

    }
}