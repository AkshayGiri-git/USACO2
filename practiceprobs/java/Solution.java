import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    ArrayList<ArrayList<Integer>> repeating = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> terminating2 = new ArrayList<ArrayList<Integer>>();
    HashMap<Integer,Integer> terminating = new HashMap<Integer,Integer>();
    public static int[] solution(int[][] m) {
        Solution sol = new Solution();
        int[] sums = new int[m.length];
        int sum = 0;
        int count = 0;
        int count2 = 0;
        for(int i = 0;i<m.length;i++){
            for(int j = 0;j<m[0].length;j++) {
                sum+=m[i][j];
            }
            if(sum == 0){
                count++;
                sol.terminating.put(i,count2);
                count2++;
            }
            sums[i] = sum;
            sum = 0;
        }
        int[] ans = new int[count+1];
        int[] ans2 = new int[count*2];
        sol.search(m,new ArrayList<Integer>(),new boolean[m.length],0,new HashSet<String>(),0,false);
        /*for(int w = 0;w<sol.repeating.size();w++){
            for(int x = 0;x<sol.repeating.get(w).size();x++){
                System.out.print(sol.repeating.get(w).get(x)+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int y = 0;y<sol.terminating2.size();y++){
            for(int z = 0;z<sol.terminating2.get(y).size();z++){
                System.out.print(sol.terminating2.get(y).get(z)+ " ");
            }
            System.out.println();
        }*/


        boolean pass2 = false;
        System.out.println(sol.terminating2.size());
        HashSet<String> visited2 = new HashSet<String>();
        for(int x = 0;x<sol.terminating2.size();x++){
            int frac1 = 0;
            int frac2 = 1;
            HashSet<Integer> visited = new HashSet<Integer>();
            for(int y = 0;y<sol.terminating2.get(x).size()-1;y++){
                int currfrac1 = 0;
                int currfrac2 = 1;
                int currfrac3 = 0;
                int currfrac4 = 1;
                if(!visited.contains(sol.terminating2.get(x).get(y))) {

                    for (int z = 0; z < sol.repeating.size(); z++) {
                        if(visited2.contains(sol.terminating2.get(x).get(y)+ " "+z)){
                            continue;
                        }
                        int pos = -1;
                        for (int g = 0; g < sol.repeating.get(z).size(); g++) {
                            if (sol.repeating.get(z).get(g).equals(sol.terminating2.get(x).get(y))) {
                                pos = g;
                                break;
                            }
                        }
                        if (pos != -1) {
                            visited2.add(sol.terminating2.get(x).get(y)+ " "+z);
                            pass2 = true;
                            int a = pos;
                            while (true) {
                                visited.add(a);
                                if (currfrac1 == 0) {
                                    currfrac1 = m[sol.repeating.get(z).get(a % sol.repeating.get(z).size())][sol.repeating.get(z).get((a + 1) % sol.repeating.get(z).size())];
                                    currfrac2 = sums[sol.repeating.get(z).get(a % sol.repeating.get(z).size())];
                                } else {
                                    currfrac1 *= m[sol.repeating.get(z).get(a % sol.repeating.get(z).size())][sol.repeating.get(z).get((a + 1) % sol.repeating.get(z).size())];
                                    currfrac2 *= sums[sol.repeating.get(z).get(a % sol.repeating.get(z).size())];
                                }
                                if (sol.repeating.get(z).get((a + 1) % sol.repeating.get(z).size()).equals(sol.terminating2.get(x).get(y))) {
                                    break;
                                }

                                a++;
                            }

                        }
                        if(x == 0){
                            System.out.println(y);
                            System.out.println(z);
                            System.out.println(currfrac1);
                            System.out.println(currfrac2);
                            System.out.println();
                        }
                        int[] lcm2 = new int[2];

                        lcm2[0] = currfrac2;
                        lcm2[1] = currfrac4;
                        int temp1 = currfrac2;
                        int temp2 = currfrac4;
                        currfrac4 = sol.lcm(lcm2);
                        currfrac2 = currfrac4;
                        currfrac1 = currfrac1 * (currfrac2 / temp1);
                        currfrac3 = currfrac3 * (currfrac4 / temp2);
                        currfrac3 += currfrac1;

                    }
                }
                if(pass2) {
                    currfrac3 *= m[sol.terminating2.get(x).get(y)][sol.terminating2.get(x).get(y + 1)];
                    currfrac4 *= sums[sol.terminating2.get(x).get(y)];
                    int[] multfrac = sol.terms(m[sol.terminating2.get(x).get(y)][sol.terminating2.get(x).get(y+1)],
                            sums[sol.terminating2.get(x).get(y)],currfrac3,currfrac4);
                    currfrac3 = multfrac[0];
                    currfrac4 = multfrac[1];
                }else{
                    currfrac3 = m[sol.terminating2.get(x).get(y)][sol.terminating2.get(x).get(y+1)];
                    currfrac4 = sums[sol.terminating2.get(x).get(y)];
                }

                if(frac1 == 0){
                    frac1 = currfrac3;
                    frac2 = currfrac4;
                }else{
                    frac1 *= currfrac3;
                    frac2 *= currfrac4;
                }
                int gcd2 = sol.gcd(frac1,frac2);
                frac1/=gcd2;
                frac2/=gcd2;
                pass2 = false;

            }

            if(ans2[sol.terminating.get(sol.terminating2.get(x).get(sol.terminating2.get(x).size()-1))*2] == 0) {
                ans2[sol.terminating.get(sol.terminating2.get(x).get(sol.terminating2.get(x).size() - 1)) * 2] = frac1;
                ans2[sol.terminating.get(sol.terminating2.get(x).get(sol.terminating2.get(x).size() - 1)) * 2 + 1] = frac2;
            }else{
                int frac3 = ans2[sol.terminating.get(sol.terminating2.get(x).get(sol.terminating2.get(x).size() - 1)) * 2];
                int frac4 = ans2[sol.terminating.get(sol.terminating2.get(x).get(sol.terminating2.get(x).size() - 1)) * 2 + 1];
                int commond = sol.lcm(new int[]{frac2,frac4});
                ans2[sol.terminating.get(sol.terminating2.get(x).get(sol.terminating2.get(x).size() - 1)) * 2] = frac1*(commond/frac1)+frac3*(commond/frac3);
                ans2[sol.terminating.get(sol.terminating2.get(x).get(sol.terminating2.get(x).size() - 1)) * 2 + 1] = commond;
            }
        }
        int[] lcm3 = new int[ans2.length/2];
        int[] orig = new int[ans2.length/2];
        for(int h = 1;h<ans2.length;h+=2){
            if(ans2[h] == 0){
                lcm3[(h-1)/2] = 1;
                orig[(h-1)/2] = 1;
            }else{
                lcm3[(h-1)/2] = ans2[h];
                orig[(h-1)/2] = ans2[h];
            }
        }

        int num = sol.lcm(lcm3);
        ans[ans.length-1] = num;

        for(int z = 0;z<count;z++){

            ans[z] = ans2[z*2]*(num/orig[z]);
        }

        return ans;
    }
    public static void main(String[] args){

        int[][] input = {{1,1,1},{1,1,1},{0,0,0}};
        int[] ans = solution(input);
        for(int i = 0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }
    public int lcm(int[] nums){
        int div = 2;
        int ans = 1;
        while(true){
            boolean div2 = false;
            int count = 0;
            for(int i = 0;i<nums.length;i++){
                if(nums[i] == 1){
                    count++;
                }
                if(nums[i]%div == 0){
                    div2 = true;
                    nums[i] /= div;
                }
            }
            if(div2){
                ans *= div;
            }else{
                div++;
            }
            if(count == nums.length){
                return ans;
            }

        }
    }
    public int gcd( int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b,a%b);
        }

    }
    public int[] terms(int frac1,int frac2,int frac3,int frac4){
        int[] ans = new int[2];
        int rate1 = frac3*frac2;
        int rate2 = frac4*frac1;
        rate1 = rate2-rate1;
        ans[0] = frac1*rate2;
        ans[1] = frac2*rate1;
        return ans;
    }
    public void search (int[][] m,ArrayList<Integer> curr, boolean[] visited,int i,HashSet<String> duplicate,int previ,boolean loop){

        if(visited[i]){
            ArrayList<Integer> re = new ArrayList<Integer>();
            boolean inc = false;
            for(int k = 0;k<curr.size();k++){
                if(curr.get(k) == i){
                    inc = true;
                }
                if(inc){
                    re.add(curr.get(k));
                }
            }
            loop = true;
            repeating.add(re);
        }
        curr.add(i);
        duplicate.add(previ+ " " +i);
        visited[i] = true;

        boolean[] visited2 = visited.clone();

        if(terminating.containsKey(i) && !loop){
            terminating2.add(curr);
            return;
        }
        for(int j = 0;j<m[i].length;j++){
            ArrayList<Integer> curr2 = (ArrayList<Integer>) curr.clone();
            if(m[i][j]!=0 && !duplicate.contains(i+ " "+j)){
                HashSet<String> duplicate2 = (HashSet<String>) duplicate.clone();
                search(m,curr2,visited2,j,duplicate2,i,loop);
            }
        }
    }
}