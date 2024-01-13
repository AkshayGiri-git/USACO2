import java.util.*;
public class acowdamia2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        int lines = Integer.parseInt(line[0]);
        int numnames = Integer.parseInt(line[1]);
        HashMap<String,Integer> order = new HashMap<String,Integer>();
        String[] order2 = s.nextLine().split(" ");
        for(int z = 0;z<order2.length;z++){
            order.put(order2[z],z);
        }
        String[][] input = new String[lines][numnames];
        char[][] ans = new char[numnames][numnames];
        for(int i = 0;i<lines;i++){
            String[] line2 = s.nextLine().split(" ");
            for(int j = 0;j<numnames;j++){
                input[i][j] = line2[j];
            }
        }
        Arrays.sort(input, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                for(int i = 0;i<o1.length;i++){
                    if(o1[i].compareTo(o2[i])>0){
                        return -1;
                    }
                    if(o1[i].compareTo(o2[i])<0){
                        return 1;
                    }
                }
                return 0;
            }
        });
        for(int k = 0;k<ans.length;k++){
            for(int l = 0;l<ans.length;l++){
                if(k == l){
                    ans[l][k] = 'B';
                }else{
                    ans[l][k] = '?';
                }
            }
        }
        ArrayList<String> moresenior = new ArrayList<String>();
        for(int m = 0;m<input.length;m++){
            for(int n = 1;n<input[0].length;n++){

                for(int o = 0;o<moresenior.size();o++){
                    ans[order.get(input[m][n])][order.get(moresenior.get(o))] = '1';
                    ans[order.get(moresenior.get(o))][order.get(input[m][n])] = '0';
                }
                if(input[m][n-1].compareTo(input[m][n])>0 || ans[order.get(input[m][n-1])][order.get(input[m][n])] == '0'){
                    moresenior.clear();
                    for(int p = 0;p<n;p++){

                        moresenior.add(input[m][p]);
                        ans[order.get(input[m][n])][order.get(input[m][p])] = '1';
                        ans[order.get(input[m][p])][order.get(input[m][n])] = '0';
                    }
                }
            }
            moresenior.clear();
        }
        for(int x = 0;x<ans.length;x++){
            for(int y = 0;y<ans.length;y++){
                System.out.print(ans[x][y]);
            }
            System.out.println();
        }
    }
}