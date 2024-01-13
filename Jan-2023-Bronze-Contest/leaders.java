import java.util.*;
public class leaders{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        String[] cows = s.nextLine().split("");
        String[] nums = s.nextLine().split(" ");
        int firstg = 0;
        int firsth = 0;
        int lastg = 0;
        int lasth = 0;
        boolean visitg = false;
        boolean visith = false;
        int ans = 0;
        ArrayList<Integer> leaders = new ArrayList<Integer>();
        for(int i = 0;i<a;i++){
            if(cows[i].equals("G") && !visitg){
                visitg = true;
                firstg = i;
            }
            if(cows[i].equals("H") && !visith){
                visith = true;
                firsth = i;
            }
            if(cows[i].equals("G")){
                lastg = i;
            }
            if(cows[i].equals("H")) {
                lasth = i;
            }
        }
        if(Integer.parseInt(nums[firsth])>=lasth){
            leaders.add(firsth+1);
        }
        if(Integer.parseInt(nums[firstg])>=lastg){
            leaders.add(firstg+1);
        }
        for(int j = 0;j<leaders.size();j++){
            for(int k = 0;k<a;k++){
                if(leaders.get(j)>k+1 && leaders.get(j)<=Integer.parseInt(nums[k])){
                    ans++;
                }
            }
        }
        if(leaders.size() == 2){
            ans++;
        }
        System.out.println(ans);
    }
}