import java.util.*;
import java.io.*;
class Milkfactory{
    static Scanner s;
    static PrintWriter pw;
    static boolean[] visited;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("factory.in"));
            pw = new PrintWriter(new FileWriter("factory.out"));
        }catch(Exception e){

        }

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int num = Integer.parseInt(s.nextLine());
        for(int i = 0;i<num;i++){
            map.put(i+1,new ArrayList<Integer>());
        }
        for(int j = 0;j<num-1;j++){
            String[] line = s.nextLine().split(" ");
            map.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
        }

        for(int i = 0;i<num;i++){
            boolean pass = true;
            visited = new boolean[num];
            recursion(map,i+1);
            for(int j = 0;j< num; j++){
                if(!visited[j]){
                    pass = false;
                    break;
                }
            }
            if(pass){
                pw.println(i+1);
                pw.close();
                break;
            }
        }
        pw.println(-1);
        pw.close();
    }
    public static void recursion(HashMap<Integer, ArrayList<Integer>> map,int startvalue){
        visited[startvalue-1] = true;
        if(map.get(startvalue).size() == 0){
            return;
        }
        for(int i = 0;i<map.get(startvalue).size();i++){
            recursion(map,map.get(startvalue).get(i));
        }
    }
}