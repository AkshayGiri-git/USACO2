import java.util.*;
import java.io.*;
public class lifeguardssilver{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("lifeguards.in"));
            pw = new PrintWriter(new FileWriter("lifeguards.out"));
        }catch(Exception e){

        }
        int n = Integer.parseInt(s.nextLine());
        int[][] struct = new int[n*2][3];
        for(int i = 0;i<n;i++){
            String[] line = s.nextLine().split(" ");
            struct[2*i][0] = Integer.parseInt(line[0]);
            struct[2*i+1][0] = Integer.parseInt(line[1]);
            struct[2*i][1] = 0;
            struct[2*i+1][1] = 1;
            struct[2*i][2] = i;
            struct[2*i+1][2] = i;
        }
        Arrays.sort(struct, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] alone = new  int[n];
        int prex = 0;
        int total = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int j = 0;j<struct.length;j++){
            if(set.size()>0){

                total+= struct[j][0]-prex;
            }
            if(set.size() == 1){
                Object[] vals =set.toArray();
                alone[(int) vals[0]] = struct[j][0]-prex;
            }
            if(struct[j][1] == 0){
                set.add(struct[j][2]);
            }else{
                set.remove(struct[j][2]);
            }
            prex = struct[j][0];
        }
        int min = Integer.MAX_VALUE;
        for(int z = 0;z<alone.length;z++){
            if(alone[z]<min){
                min = alone[z];
            }
        }
        pw.println(total-min);
        pw.close();
    }
}