import java.util.*;
import java.io.*;
public class Backandforth {
    static Scanner s;
    static PrintWriter pw;
    int ans = 0;

    public static void main(String args[]){
        try{
            s = new Scanner(new File("backforth.in"));
            pw = new PrintWriter(new FileWriter("backforth.out"));
        }catch(Exception e){

        }

        HashSet<Integer> answers = new HashSet<Integer>();
        ArrayList<Integer> firstbarn = new ArrayList<Integer>();
        ArrayList<Integer> secondbarn = new ArrayList<Integer>();
        String[] line1 = s.nextLine().split(" ");
        String[] line2 = s.nextLine().split(" ");
        for(int i = 0;i<10;i++){
            firstbarn.add(Integer.parseInt(line1[i]));
            secondbarn.add(Integer.parseInt(line2[i]));
        }
        Backandforth backandforth = new Backandforth();
        backandforth.recursion(firstbarn,secondbarn,answers,1,1000);
        pw.println(backandforth.ans);
        pw.close();
    }
    public void recursion(ArrayList<Integer> firstbarn, ArrayList<Integer> secondbarn,HashSet<Integer> answers
            ,int level,int value){
        if(level == 5){
            if(!answers.contains(value)){
                ans++;
                answers.add(value);
            }
            return;
        }
        if(level % 2 == 1) {
            for (int i = 0; i < firstbarn.size(); i++) {
                int bucket = firstbarn.get(i);
                ArrayList<Integer> firstbarn2 = (ArrayList<Integer>) firstbarn.clone();
                ArrayList<Integer> secondbarn2 = (ArrayList<Integer>) secondbarn.clone();
                firstbarn2.remove(i);
                secondbarn2.add(bucket);
                recursion(firstbarn2,secondbarn2,answers,level+1,value-bucket);
            }
        }else{
            for(int j = 0;j<secondbarn.size();j++){
                int bucket = secondbarn.get(j);
                ArrayList<Integer> firstbarn2 = (ArrayList<Integer>) firstbarn.clone();
                ArrayList<Integer> secondbarn2 = (ArrayList<Integer>) secondbarn.clone();
                secondbarn2.remove(j);
                firstbarn2.add(bucket);
                recursion(firstbarn2,secondbarn2,answers,level+1,value+bucket);
            }
        }
    }
}
