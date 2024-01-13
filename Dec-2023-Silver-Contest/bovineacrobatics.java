import java.util.*;
public class bovineacrobatics{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] fline = s.nextLine().split(" ");
        int n = Integer.parseInt(fline[0]);
        int m = Integer.parseInt(fline[1]);
        int k = Integer.parseInt(fline[2]);
        int[][] input = new int[n][2];
        for(int i = 0;i<n;i++){
            String[] line = s.nextLine().split(" ");
            input[i][0] = Integer.parseInt(line[0]);
            input[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer num1 = o1[0];
                Integer num2 = o2[0];
                return num1.compareTo(num2);
            }
        });
        PriorityQueue<ArrayList<int[]>> groups = new PriorityQueue<ArrayList<int[]>>(new Comparator<ArrayList<int[]>>() {
            @Override
            public int compare(ArrayList<int[]> o1, ArrayList<int[]> o2) {
                Integer num1 = o1.get(o1.size()-1)[0];
                Integer num2 = o2.get(o2.size()-1)[0];
                return num1.compareTo(num2);
            }
        });
        PriorityQueue<Integer> ends = new PriorityQueue<Integer>();
        for(int j = 0;j<input.length;j++){
            ArrayList<int[]> curr = groups.peek();
            if(curr == null|| curr.get(curr.size()-1)[0] + k > input[j][0]) {
                ArrayList<int[]> temp = new ArrayList<int[]>();
                int[] temp2 = new int[2];
                temp2[0] = input[j][0];
                temp2[1] = input[j][1];
                temp.add(temp2);
                groups.add(temp);
                ends.add(input[j][0]);
            }else{
                int[] temp2 = new int[2];
                temp2[0] = input[j][0];
                temp2[1] = input[j][1];
                groups.peek().add(temp2);
            }
        }
        ArrayList<ArrayList<Integer>> groups2 = new ArrayList<ArrayList<Integer>>();
        int z = 0;
        PriorityQueue<int[]> lengths = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer num1 = o1[0];
                Integer num2 = o2[0];
                return num2.compareTo(num1);
            }
        });
        while(true){
            ArrayList<int[]> group = groups.poll();
            if(group == null){
                break;
            }
            ArrayList<Integer> group3 = new ArrayList<Integer>();
            for(int h = 0;h<group.size();h++){
                group3.add(group.get(h)[1]);
                System.out.print(group.get(h)[0]+ " ");
            }
            System.out.println();
            Collections.sort(group3);
            groups2.add(group3);
            int[] temp = new int[2];
            temp[0] = group.size();
            temp[1] = z;
            lengths.add(temp);
            z++;
        }
        int[] subtract = new int[groups2.size()];
        int[] offset = new int[groups2.size()];
        long ans = 0;
        int numtowers = 0;
        while(true){
            if(numtowers == m || lengths.peek()[0] == 0){
                break;
            }
            int pos = lengths.peek()[1];
            int amount = lengths.peek()[0];
            ArrayList<Integer> curr = groups2.get(pos);
            int num = Math.min(m-numtowers,(curr.get(offset[pos]) - subtract[pos]));
            ans+= (long) num *amount;
            numtowers+=num;
            subtract[pos] += num;
            offset[pos]++;
            int[] temp5 = new int[2];
            temp5[0] = amount-1;
            temp5[1] = pos;
            lengths.poll();
            lengths.add(temp5);
        }
        System.out.println(ans);
    }
}