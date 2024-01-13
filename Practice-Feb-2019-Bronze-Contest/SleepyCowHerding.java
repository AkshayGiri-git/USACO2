import java.util.*;
import java.io.*;
class SleepyCowHerding{
    static Scanner scan;
    static PrintWriter pw;
    public static void main(String[] args){
        try {
             scan = new Scanner(new File("herding.in"));
             pw = new PrintWriter(new FileWriter("herding.out"));
        }catch(Exception e){
            System.out.println("hello");
        }


        int[] locations = new int[3];
        for(int i = 0;i<3;i++){
            locations[i] = scan.nextInt();
        }

        Arrays.sort(locations);

        if(locations[1]-locations[0] == 1 && locations[2]-locations[1] == 1){
            pw.println(0);
            pw.println(0);
            pw.close();
        }else if(locations[1] - locations[0] == 2 || locations[2]-locations[1] == 2){
           pw.println(1);
            if(locations[2]-locations[1]> locations[1]-locations[0]){
                pw.println(locations[2]-locations[1]-1);
                pw.close();
            }else{
               pw.println(locations[1]-locations[0]-1);
                pw.close();
            }
        }else{
            pw.println(2);
            if(locations[2]-locations[1]> locations[1]-locations[0]){
                pw.println(locations[2]-locations[1]-1);
                pw.close();
            }else{
                pw.println(locations[1]-locations[0]-1);
                pw.close();
            }
        }



    }
}