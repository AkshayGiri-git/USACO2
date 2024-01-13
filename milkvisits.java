import java.util.*;
import java.io.*;
public class milkvisits {
    static Scanner  s;
    static PrintWriter pw;
    static int[] parts;
    static String[] cowtype;
    static HashSet<Integer> visited;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("milkvisits.in"));
            pw = new PrintWriter(new FileWriter("milkvisits.out"));
        }catch(Exception e){

        }

        visited = new HashSet<Integer>();
        HashMap<Integer,ArrayList<Integer>> tree = new HashMap<Integer,ArrayList<Integer>>();
        String[] fline = s.nextLine().split(" ");
        int n = Integer.parseInt(fline[0]);
        parts = new int[n];
        int walks = Integer.parseInt(fline[1]);
        cowtype = s.nextLine().split("");
        for(int j = 0;j<n;j++){
            tree.put(j+1,new ArrayList<Integer>());
        }
        for(int i = 0;i<n-1;i++){
            String[] line = s.nextLine().split(" ");
            tree.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
            tree.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
        }
        int num = 1;
        for(int j = 1;j<=n;j++) {
            if(!visited.contains(j)){
                recursion(j,num,tree);
                num++;
            }
        }
        for(int k = 0;k<walks;k++){
            String[] line2 = s.nextLine().split(" ");
            if(parts[Integer.parseInt(line2[0])-1] != parts[Integer.parseInt(line2[1])-1]){
                pw.print("1");
            }else{
                if(cowtype[Integer.parseInt(line2[0])-1].equals(line2[2])){
                    pw.print("1");
                }else{
                    pw.print("0");
                }
            }
        }
        pw.close();
    }
    public static void recursion(int farm,int num,HashMap<Integer,ArrayList<Integer>> tree){
        parts[farm-1] = num;
        visited.add(farm);
        System.out.println(farm);
        for(int i = 0;i<tree.get(farm).size();i++){
            if(cowtype[tree.get(farm).get(i)-1].equals(cowtype[farm-1]) && !visited.contains(tree.get(farm).get(i))){
                recursion(tree.get(farm).get(i),num,tree);
            }
        }
    }
}
