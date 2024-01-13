import java.util.*;
import java.io.*;
class Bucketlist{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{

            s = new Scanner (new File("blist.in"));

            pw = new PrintWriter(new FileWriter("blist.out"));

        }catch(IOException e){
        }
        int cows = Integer.parseInt(s.nextLine());
        int[] startTimes = new int[cows];
        int[] endTimes = new int[cows];
        int[] numBuckets = new int[cows];
        HashMap<Integer,Integer> starttoposition = new HashMap<Integer,Integer>();
        int maxval = 0;
        int bucketsUsed = 0;
        for(int i = 0;i<cows;i++){
            String[] insert = s.nextLine().split(" ");
            startTimes[i] = Integer.parseInt(insert[0]);

            endTimes[i] = Integer.parseInt(insert[1]);
            if(maxval<Integer.parseInt(insert[1])){
                maxval = Integer.parseInt(insert[1]);
            }
            numBuckets[i] = Integer.parseInt(insert[2]);
            starttoposition.put(Integer.parseInt(insert[0]),i);
        }
        int minBuckets = 0;
        int iterator = 0;
        Arrays.sort(startTimes);

        for(int j = 0;j<maxval;j++){
            if(startTimes[iterator] == j){
                bucketsUsed = numBuckets[starttoposition.get(startTimes[iterator])]+bucketsUsed;

                if(minBuckets<bucketsUsed){
                    minBuckets = bucketsUsed;
                }
                if(iterator != cows-1) {
                    iterator++;
                }
            }
            for(int k = 0;k<cows;k++){
                if(j == endTimes[k]){
                    bucketsUsed = bucketsUsed-numBuckets[k];
                }
            }
        }
        pw.println(minBuckets);
        pw.close();
    }
}