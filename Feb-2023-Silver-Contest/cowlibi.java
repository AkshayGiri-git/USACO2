import java.util.*;
public class cowlibi{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] firstline = s.nextLine().split(" ");
        int grazings = Integer.parseInt(firstline[0]);
        int alibis = Integer.parseInt(firstline[1]);
        int[][] grazings2 = new int[grazings][3];
        int[][] alibis2 = new int[alibis][3];
        for(int i = 0;i<grazings;i++){
            String[] line = s.nextLine().split(" ");
            grazings2[i][0] = Integer.parseInt(line[0]);
            grazings2[i][1] = Integer.parseInt(line[1]);
            grazings2[i][2] = Integer.parseInt(line[2]);

        }
        for(int j = 0;j<alibis;j++){
            String[] line2 = s.nextLine().split(" ");
            alibis2[j][0] = Integer.parseInt(line2[0]);
            alibis2[j][1] = Integer.parseInt(line2[1]);
            alibis2[j][2] = Integer.parseInt(line2[2]);
        }
        Arrays.sort(grazings2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        Arrays.sort(alibis2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int pointer = 0;
        int count = 0;
        for(int k = 0;k<alibis;k++){
            while(alibis2[k][2]>grazings2[pointer][2]){
                pointer++;
            }
            if(pointer>grazings2.length){
                count++;
            }else {
                boolean clause = false;
                boolean clause2 = false;
                if (pointer != 0) {
                    if (Math.abs(grazings2[pointer - 1][0] - alibis2[k][0]) + Math.abs(grazings2[pointer - 1][1] - alibis2[k][1]) <= Math.abs(grazings2[pointer - 1][2] - alibis2[k][2])) {
                        clause = true;
                    }
                } else {
                    clause = true;
                }
                if (Math.abs(grazings2[pointer][0] - alibis2[k][0]) + Math.abs(grazings2[pointer][1] - alibis2[k][1]) <= Math.abs(grazings2[pointer][2] - alibis2[k][2])) {
                    clause2 = true;
                }
                if (!clause || !clause2) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}