import java.util.*;
public class thermometer{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        for(int i = 0;i<num;i++){
            String[] fline = s.nextLine().split(" ");
            String[] sline = s.nextLine().split(" ");
            int range1 = Integer.parseInt(fline[0]);
            int range2 = Integer.parseInt(fline[1]);
            int minchange = Integer.parseInt(fline[2]);
            int start = Integer.parseInt(sline[0]);
            int end = Integer.parseInt(sline[1]);
            if(start == end){
                System.out.println(0);
            }
            else if(end-minchange <range1 && end+minchange>range2){
                System.out.println(-1);
            }
            else if(start-minchange <range1 && start+minchange>range2){
                System.out.println(-1);
            }
            else if(end<range1 || end>range2){
                System.out.println(-1);
            }else if(start-minchange >= end || start+minchange <= end){
                System.out.println(1);
            }else if(range2-start>=minchange && Math.abs(range2-end)>=minchange){
                System.out.println(2);
            }else if(start-range1>=minchange && Math.abs(end-range1)>=minchange){
                System.out.println(2);
            }else{
                System.out.println(3);
            }

        }
    }
}
