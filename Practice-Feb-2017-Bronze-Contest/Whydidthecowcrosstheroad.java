import java.util.*;
import java.io.*;
class Whydidthecowcrosstheroad{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner( new File("crossroad.in"));
            pw = new PrintWriter( new PrintWriter("crossroad.out"));
        }catch(Exception e){

        }
        int sightings = Integer.parseInt(s.nextLine());
        HashMap<Integer,Integer> cows = new HashMap<Integer,Integer>();
        int crosses = 0;
        for(int i = 0;i<sightings;i++){
            String[] line = s.nextLine().split(" ");
            if(cows.containsKey(Integer.parseInt(line[0]))){
                int prevside = cows.get(Integer.parseInt(line[0]));
                if(Integer.parseInt(line[1]) != prevside){
                    crosses++;
                    cows.replace(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
                }

            }else{
                cows.put(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
            }
        }
        pw.println(crosses);
        pw.close();
    }
}