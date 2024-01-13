import java.util.*;
class alchemy{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int desmetal = Integer.parseInt(s.nextLine());
        int[] nummetal = new int[desmetal];
        String[] nummetal2 = s.nextLine().split(" ");
        int[][] recipes = new int[desmetal][];
        for(int i = 0;i<desmetal;i++){
            nummetal[i] = Integer.parseInt(nummetal2[i]);
        }
        int numrecipes = Integer.parseInt(s.nextLine());
        for(int j = 0;j<numrecipes;j++){
            String[] line = s.nextLine().split(" ");
            recipes[Integer.parseInt(line[0])-1] = new int[Integer.parseInt(line[1])];
            for(int k = 0;k<Integer.parseInt(line[1]);k++){
                recipes[Integer.parseInt(line[0])-1][k]= Integer.parseInt(line[k+2])-1;
            }
        }
        int ans = 0;
        while(metal(recipes,nummetal,desmetal-1)) {
            ans++;

        }
        System.out.println(ans);
    }
    public static boolean metal (int[][] recipes,int[] nummetal,int desmetal){
        if(nummetal[desmetal]>0){
            nummetal[desmetal]--;
            return true;
        }
        if(recipes[desmetal] == null){
            return false;
        }
        for(int i = 0;i<recipes[desmetal].length;i++){
            if(!metal(recipes,nummetal,recipes[desmetal][i])){
                return false;
            }
        }
        return true;
    }
}