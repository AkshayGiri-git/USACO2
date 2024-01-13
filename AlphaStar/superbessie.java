import java.util.*;
public class superbessie {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] map = s.nextLine().split("");
        ArrayList<Integer> a = new ArrayList<>();
        int count = 0;
        boolean b = false;
        boolean back = false;
        boolean f = false;
        boolean start = false;
        for(String i : map){

            if(i.equals("F")){

                if(!b){
                    back = true;
                    f = true;
                    start = true;
                }else{

                    a.add(count);


                    break;
                }
            }
            else if(i.equals("B")){

                if(!f){
                    b = true;

                    start = true;
                }else{
                    a.add(count);
                    break;
                }
            }
            else if(start) {
                if (i.equals(".")) {
                    count++;
                }else{
                    a.add(count);
                    count = 0;
                }
            }
        }


            int ans = 0;

        if(!back){

            for(int j  = 0;j<a.size();j++){
                int jumpdist = a.get(j)+1;
                if(j == 0 ){
                    jumpdist++;
                }
                if(j == a.size()-1){
                    jumpdist--;
                }
                if(jumpdist % 2 == 0){
                    ans += jumpdist/2;
                }else{
                    ans += (jumpdist+1)/2;
                }
            }
        }else{

            for(int k = a.size() -1;k>=0;k--){
                int jumpdist = a.get(k)+1;
                if(k == 0 ){
                    jumpdist--;
                }
                if(k == a.size()-1){
                    jumpdist++;
                }
                if(jumpdist % 2 == 0){
                    ans += jumpdist/2;
                }else{
                    ans += (jumpdist+1)/2;
                }
            }
        }
        System.out.println(ans);
    }
}
