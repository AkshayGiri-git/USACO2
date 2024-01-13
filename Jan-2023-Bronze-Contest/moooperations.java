import java.util.*;
public class moooperations{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        int[] anses = new int[a];
        int best = 3;
        int curr = 0;
        HashMap<String,Integer> maps = new HashMap<String,Integer>();
        maps.put("MMM",3);
        maps.put("MMO",3);
        maps.put("MOM",1);
        maps.put("MOO",0);
        maps.put("OMM",3);
        maps.put("OMO",3);
        maps.put("OOM",2);
        maps.put("OOO",1);
        for(int i = 0;i<a;i++){
            String trans = s.nextLine();
            for(int j = 0;j<trans.length()-2;j++){
                String letters = trans.charAt(j)+""+trans.charAt(j+1)+""+trans.charAt(j+2);
                int num = maps.get(letters);
                if(num<best){
                    best = num;
                }
            }
            if(best == 3){
                anses[i] = -1;
            }else{
                anses[i] = best+(trans.length()-3);
            }
            best = 3;
        }
        for(int k = 0;k<anses.length;k++){
            System.out.println(anses[k]);
        }
    }
}