import java.util.*;
public class comparingshirts {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            String shirt1 = line[0];
            int shirt1num = 0;
            String shirt2 = line[1];
            int shirt2num = 0;
            if(shirt1.charAt(shirt1.length()-1) == 'S'){
                shirt1num = -1;
                shirt1num-=shirt1.length()-1;
            }
            if(shirt1.charAt(shirt1.length()-1) == 'L'){
                shirt1num = 1;
                shirt1num+=shirt1.length()-1;
            }
            if(shirt2.charAt(shirt2.length()-1) == 'S'){
                shirt2num = -1;
                shirt2num-=shirt2.length()-1;
            }
            if(shirt2.charAt(shirt2.length()-1) == 'L'){
                shirt2num = 1;
                shirt2num+=shirt2.length()-1;
            }
            if(shirt1num>shirt2num){
                System.out.println(">");
            }else if(shirt1num == shirt2num){
                System.out.println("=");
            }else{
                System.out.println("<");
            }
        }
    }
}
