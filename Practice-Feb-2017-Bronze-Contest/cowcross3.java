import java.util.*;
import java.io.*;
class cowcross3{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner( new File("cowqueue.in"));
            pw = new PrintWriter( new PrintWriter("cowqueue.out"));
        }catch(Exception e){

        }
        Scanner s = new Scanner(System.in);
        int cows = Integer.parseInt(s.nextLine());
        HashMap<Integer,Integer> sort = new HashMap<Integer,Integer>();
        int[] arrivalsort = new int[cows];
        for(int i = 0;i<cows;i++){
            String[] line = s.nextLine().split(" ");
            arrivalsort[i] = Integer.parseInt(line[0]);
            sort.put(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
        }
        Arrays.sort(arrivalsort);
        int time = 0;
        int time2 = 0;
        for(int j = 0;j<cows;j++){
            if(j == 0){
                time = arrivalsort[j]+ sort.get(arrivalsort[j]);
            }else{
                if(arrivalsort[j]<time){
                    time2 = time;

                }else{
                    time2 = arrivalsort[j];
                }


                time = time2+sort.get(arrivalsort[j]);

            }
        }

        pw.println(time);
       pw.close();
    }
}