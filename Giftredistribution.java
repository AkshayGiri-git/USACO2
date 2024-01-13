import java.util.*;
public class Giftredistribution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        ArrayList<HashMap<Integer,Integer>> listmap = new ArrayList<HashMap<Integer,Integer>>();;
        for(int i = 0;i<n;i++){
            String[] line = s.nextLine().split(" ");
            listmap.add(new HashMap<Integer,Integer>());
            for(int j = 0;j<n;j++){
                listmap.get(i).put(Integer.parseInt(line[j]),j);
            }
        }
        for(int k = 0;k<n;k++){
            int best = listmap.get(k).get(k+1);
            int bestnum = k+1;
            for(int l = 0;l<n;l++){
                if(k == l){
                    continue;
                }
                if(listmap.get(k).get(l+1)<best && listmap.get(l).get(k+1)<listmap.get(l).get(l+1)){
                    best = listmap.get(k).get(l+1);
                    bestnum = l+1;
                }
            }
            System.out.println(bestnum);
        }
    }
}
