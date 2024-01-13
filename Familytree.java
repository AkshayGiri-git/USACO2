import java.util.*;
import java.io.*;
public class Familytree {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("family.in"));
            pw = new PrintWriter(new FileWriter("family.out"));
        }catch(Exception e){

        }
        String[] fline = s.nextLine().split(" ");
        int num = Integer.parseInt(fline[0]);
        String start = fline[1];
        String end = fline[2];
        HashMap<String,Node> map = new HashMap<String,Node>();
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            if(map.containsKey(line[0])){
                if(map.containsKey(line[1])){
                    map.get(line[0]).children.add(new Node());
                }
            }
        }
    }
}
class Node{
        String val;
        ArrayList<Node> children;
        Node parent;
}