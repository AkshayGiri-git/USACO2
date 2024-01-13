import java.util.*;
class cowsandbulls{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cattle = Integer.parseInt(s.nextLine());
        String[] cowspred = s.nextLine().split(" ");
        String[] bullpred = s.nextLine().split(" ");
        int bulls = 0;
        int cows = 0;
        StringBuilder a = new StringBuilder();
        for(int i = 0;i<cattle;i++){
            if(Integer.parseInt(cowspred[i]) == cows && Integer.parseInt(bullpred[i]) == bulls){
                cows++;
                a.append("C");
                if(i != cattle-1){
                    a.append(" ");
                }
            }else{
                bulls++;
                a.append("B");
                if(i != cattle-1){
                    a.append(" ");
                }
            }
        }
        System.out.println(a);
    }
}