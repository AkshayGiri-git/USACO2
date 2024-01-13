import java.util.*;
public class cowardlyrooks {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            if(Integer.parseInt(line[0]) == Integer.parseInt(line[1])){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
            for(int j = 0;j<Integer.parseInt(line[1]);j++){
                s.nextLine();
            }
        }
    }
}
