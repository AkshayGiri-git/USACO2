import java.util.*;
public class aircownditioning2{
    static ArrayList<String> combs = new ArrayList<String>();
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] firstline = s.nextLine().split(" ");
        int numcows = Integer.parseInt(firstline[0]);
        int numacs = Integer.parseInt(firstline[1]);
        int[] stalls = new int[100];
        int [][] acs = new int[numacs][4];
        String[] line;
        for(int j = 0;j<numcows;j++){
            line = s.nextLine().split(" ");
            for(int k = Integer.parseInt(line[0])-1;k<=Integer.parseInt(line[1])-1;k++){
                stalls[k] = Integer.parseInt(line[2]);
            }
        }

        for(int i = 0;i<numacs;i++){
            line = s.nextLine().split(" ");
            acs[i][0] = Integer.parseInt(line[0])-1;
            acs[i][1] = Integer.parseInt(line[1])-1;
            acs[i][2] = Integer.parseInt(line[2]);
            acs[i][3] = Integer.parseInt(line[3]);
        }
        recursion(1,"",numacs);
        int[] stalls2 = new int[100];
        int cost = 0;
        int best = Integer.MAX_VALUE;
        boolean pass = true;
        for(int l = 0;l<combs.size();l++){
            String[] combs2 = combs.get(l).substring(1).split(" ");
            for(int o = 0;o<100;o++){
                stalls2[o] = stalls[o];
            }
            for(int m = 0;m<combs2.length;m++){
                int num = Integer.parseInt(combs2[m])-1;
                cost += acs[num][3];
                for(int n = acs[num][0];n<=acs[num][1];n++){
                    stalls2[n] = stalls2[n]-acs[num][2];
                }
            }
            for(int x = 0;x<100;x++){
                if(stalls2[x]>0){
                    pass = false;
                }
            }
            if(pass){
                if(cost<best){
                    best = cost;
                }
            }
            cost = 0;
            pass = true;
        }
        System.out.println(best);
    }
    public static void recursion(int startval,String a, int length){
        if(startval>= length+1){
            return;
        }
        for(int i = startval;i<length+1;i++){
            combs.add(a + " "+ i);
            recursion(i+1, a+ " "+ i,length);
        }
    }
}