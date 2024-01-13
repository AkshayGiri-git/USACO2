import java.util.*;
import java.io.*;
class cowcross2{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try {
            s = new Scanner(new File("circlecross.in"));
            pw = new PrintWriter(new FileWriter("circlecross.out"));

        }catch(Exception e){

        }

        String[] sequence = s.nextLine().split("");
        int [] noends = new int[52];
        int noends2 = 0;
        int crosses = 0;
        HashMap<String,Integer> pos = new HashMap<String,Integer>();
        for(int i = 0;i<52;i++){
            if(pos.containsKey(sequence[i])){

                 crosses += noends2- noends[pos.get(sequence[i])];

                 noends2--;
                 for(int j = pos.get(sequence[i]);j<i;j++){
                     noends[j] = noends[j]-1;
                 }
            }else{
                pos.put(sequence[i],i);
                noends2++;
                noends[i] = noends2;
            }
        }


        pw.println(crosses);
        pw.close();

    }
}