import java.util.*;
public class connecting2barns {
    static HashSet<Integer> ninInterval = new HashSet<Integer>();
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int t = Integer.parseInt(s.nextLine());
        long[] anses = new long[t];
        for(int i = 0;i<t;i++){
            String[] line = s.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[][] intervals = new int[m][2];

            for(int j = 0;j<m;j++) {
                String[] line2 = s.nextLine().split(" ");
                int start = Integer.parseInt(line2[0]);
                int end = Integer.parseInt(line2[1]);
                if(i == 11){
                    System.out.println(start+ " "+end+ " booby");
                }
                intervals[j][0] = Math.min(start,end);
                intervals[j][1] = Math.max(start,end);
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    Integer num1 = o1[0];
                    Integer num2 = o2[0];
                    return num1.compareTo(num2);
                }
            });
            inInterval2(intervals,n);
            int startstreak = 0;
            int endstreak = 0;
            boolean start = true;

            for(int z = 1; z< n;z++){
                if(!ninInterval.contains(z)){
                    if(start){
                        startstreak++;
                    }
                    endstreak++;
                }else{
                    start = false;
                    endstreak = 0;
                }
            }
            if(endstreak == n-1){
                endstreak = 0;
            }
            int start2 = startstreak;
            int end2 = n-endstreak-1;
            System.out.println(start2+ " "+end2);
            if(m == 0){
                start2 = 0;
                end2 = n-1;
            }
            int start3 = -1;
            int end3 = -1;
            long ans = (long) ((end2-start2)/2)*((end2-start2)/2)+ (long) ((end2 - start2) - ((end2 - start2) / 2)) *((end2-start2)-((end2-start2)/2));
            for(int y = start2+1;y<=end2;y++){
                if(!ninInterval.contains(y)){
                    if(start3 == -1){
                        start3 = y;
                        end3 = y;
                    }else{
                        end3 = y;
                    }
                }else if(start3 != -1){
                    long ans2 = (long) (start3-start2)*(start3-start2)+ (long) (end2-(end3+1))*(end2-(end3+1));
                    ans = Math.min(ans,ans2);
                    start3 = -1;
                    end3 = -1;
                }

            }
            anses[i] = ans;
            ninInterval.clear();
        }
        for(int g = 0;g<t;g++){
            System.out.println(anses[g]);
        }
    }

    public static void inInterval2(int[][] intervals , int n) {
        int start = 1;
        int max = 1;
        for(int i = 0;i<intervals.length;i++){
            if(intervals[i][0]>max){
                for(int j = max;j<intervals[i][0];j++){
                    ninInterval.add(j);
                }
            }
            max = Math.max(max,intervals[i][1]);


        }
        for(int j = max;j<n;j++){
            System.out.println("hello");
            ninInterval.add(j);
        }
    }


}
