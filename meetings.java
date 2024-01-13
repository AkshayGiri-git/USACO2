import java.util.*;
import java.io.*;
class meetings{
    static PrintWriter pw;
    static Scanner s;
    public static void main (String[] args){
        try{
            s = new Scanner(new File("meetings.in"));
            pw = new PrintWriter(new FileWriter("meetings.out"));
        }catch(Exception e){

        }
        String[] fline = s.nextLine().split(" ");
        int n = Integer.parseInt(fline[0]);
        int l = Integer.parseInt(fline[1]);
        int[][] input = new int[n][3];
        int totalweight = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            String[] line = s.nextLine().split(" ");
            input[i][0] = Integer.parseInt(line[0]);
            input[i][1] = Integer.parseInt(line[1]);
            input[i][2] = Integer.parseInt(line[2]);
            totalweight+=input[i][0];
            if(input[i][2] == -1){
                count++;
            }
        }
        Arrays.sort(input,(a,b)-> Integer.compare(a[1],b[1]));
        int[] finishset1 = new int[count];
        int x = 0;
        int[] finishset2 = new int[n-count];
        int y = 0;
        int[][] finishset = new int[n][2];
        for(int j = 0;j<n;j++){
            if(input[j][2] == -1){
                finishset1[x] = input[j][1];

                x++;
            }
        }
        for(int k = 0;k<finishset.length;k++){
            if(input[k][2] == 1){
                finishset2[y] = l-input[k][1];
                y++;
            }
        }
        for(int w = 0;w<finishset.length;w++){

            if(w<count){
                finishset[w][0] = finishset1[w];

            }else{
                finishset[w][0] = finishset2[w-count];
                y++;
            }

            finishset[w][1] = input[w][0];
        }
        Arrays.sort(finishset,(a,b) -> Integer.compare(a[0],b[0]));
        int t = 0;
        for(int h = 0;h<n;h++){

            totalweight -= 2*finishset[h][1];

            if(totalweight<=0){
                t = finishset[h][0];
                break;
            }
        }


        Queue<Integer> ans = new LinkedList<Integer>();
        int ans2 = 0;
        for(int z = 0;z<n;z++){
            if(input[z][2] == -1){
                while(!ans.isEmpty() && ans.peek()+t*2 < input[z][1]){
                    ans.poll();
                }
                ans2+= ans.size();
            }else{
                ans.add(input[z][1]);
            }
        }
        pw.println(ans2);
        pw.close();
    }
}