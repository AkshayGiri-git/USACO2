import java.util.*;
public class findandreplace{
    static int[][] graph;
    static String[] ans;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int testcases = Integer.parseInt(s.nextLine());
        int[] answers = new int[testcases];
        for(int i = 0;i<testcases;i++){
            graph = new int[52][52];
            String s1 = s.nextLine();
            String s2 = s.nextLine();
            int num1 = 0;
            int num2 = 0;
            for(int j = 0;j<s1.length();j++){

                if((int) s1.charAt(j) >=97){
                    num1 = (int) s1.charAt(j) - 97;
                }else{
                    num1 = (int) s1.charAt(j) - 39;
                }
                if((int) s2.charAt(j) >=97){
                    num2 = (int) s2.charAt(j) - 97;
                }else{
                    num2 = (int) s2.charAt(j) - 39;
                }
                graph[num1][num2] = 1;
            }
            for(int x = 0;x<graph.length;x++){
                for(int y = 0;y<graph.length;y++){
                    char c1 = ' ';
                    char c2 = ' ';
                    if(graph[x][y] == 1){
                        if(x <= 25){
                           c1 = (char) (x+97);
                        }else{
                            c1 = (char)  (x+39);
                        }
                        if(y <= 25){
                            c2 = (char) (y+97);
                        }else{
                            c2 = (char)(y+39);
                        }
                        System.out.println(c1+"->"+c2);
                    }
                }
            }
            int chars = 0;
            for(int k = 0;k<graph.length;k++){
                int rowcount = 0;
                for(int l = 0;l<graph.length;l++){
                    if(graph[k][l] == 1){
                        rowcount++;
                        chars++;
                    }
                }
                if(rowcount>1){
                    answers[i] = -1;
                }
            }
            if(answers[i] != -1) {
                int num = 0;
                boolean exit = false;
                for (int n = 0; n < graph.length; n++) {
                    for (int m = 0; m < graph.length; m++) {
                        if(n!=m) {
                            if (graph[n][m] == 1) {
                                HashSet<Integer> visited = new HashSet<Integer>();
                                recursion(visited, 0, n, m, n);
                                if (chars == 52 && ans[1].equals("cyc")) {
                                    answers[i] = -1;
                                    exit = true;
                                    break;
                                } else {
                                    if (ans[1].equals("cyc")) {
                                        num += Integer.parseInt(ans[0]) + 1;
                                    } else {
                                        num += Integer.parseInt(ans[0]);
                                    }
                                }
                            }
                        }
                    }
                    if(exit){
                        break;
                    }
                }
                if(answers[i]!= -1){
                    answers[i] = num;
                }
            }
        }
        for(int z = 0;z<answers.length;z++){
            System.out.println(answers[z]);
        }
    }
    public static void recursion(HashSet<Integer> visited, int time, int x , int y,int firstchar){
        ans = new String[2];
        boolean quit = true;
        if(visited.contains(x)){
            if(x == firstchar){
                ans[0] = Integer.toString(time);
                ans[1] = "cyc";
                return;
            }else{
                ans[0] = Integer.toString(time);
                ans[1] = "pcyc";
                return;
            }
        }
        visited.add(x);
        int y2 = 0;
        if(time == 0){
            y2 = y;
            quit = false;
        }else {
            for (int i = 0; i < graph.length; i++) {
                if(x!=i) {
                    if (graph[x][i] == 1) {
                        quit = false;
                        y2 = i;
                        break;
                    }
                }
            }
        }
        if(quit){
            ans[0] = Integer.toString(time);
            ans[1] = "nocyc";
            return;
        }
        graph[x][y2] = 0;
        recursion(visited,time+1,y2,y,firstchar);
        return;
    }
}