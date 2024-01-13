import java.util.*;
import java.io.*;
class race{
    static Scanner s;
    static PrintWriter pw;
    public static int getSlowdownDist(int speed , int finishspeed) {
        if (speed<=finishspeed){
            return 0;
        } else{
            return (((speed-1)*speed)/2)-(((finishspeed-1)*finishspeed)/2);
        }
    }
    public static void main(String args[]){
        try {
            s = new Scanner( new File("race.in"));
            pw = new PrintWriter(new FileWriter("race.out"));
        } catch(Exception e){

        }
        String[] firstline = s.nextLine().split(" ");
        int distance = Integer.parseInt(firstline[0]);
        int races = Integer.parseInt(firstline[1]);
        int[] finishspeeds = new int[races];
        for(int i = 0;i<races;i++){
            finishspeeds[i] = Integer.parseInt(s.nextLine());
        }
        int traveled = 0;
        int currSpeed = 0;
        int endSpeed = 0;
        int time = 0;



        for(int j = 0;j<races;j++){
            endSpeed = finishspeeds[j];

            while(distance-traveled > 0){
                traveled += currSpeed;
                if(getSlowdownDist(currSpeed+1,endSpeed) < distance-traveled){
                    currSpeed++;
                    traveled++;
                }else if(getSlowdownDist(currSpeed,endSpeed) > distance-traveled){
                    currSpeed--;
                    traveled--;
                }
                //System.out.println((distance-traveled) + " " + currSpeed + " "+ endSpeed + " " + getSlowdownDist(currSpeed,endSpeed));

                time++;
            }
            currSpeed = 0;
            traveled = 0;

            pw.println(time);
            time = 0;
        }

        pw.close();
    }
}