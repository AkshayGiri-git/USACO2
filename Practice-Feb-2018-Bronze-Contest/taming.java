import java.util.*;
import java.io.*;
class taming{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("taming.in"));
            pw = new PrintWriter(new FileWriter("taming.out"));
        }catch(Exception e){
            System.out.println("hello");
        }
        int num = Integer.parseInt(s.nextLine());
        String[] log = s.nextLine().split(" ");
        int min = 1;
        int lastbreak = 0;

        ArrayList<Integer> minplace = new ArrayList<>();
        minplace.add(0);
        boolean exit = false;
        for(int i = 1;i<num;i++){
            if(!log[i].equals("-1")){

                if(i-Integer.parseInt(log[i])>lastbreak){
                    lastbreak = i-Integer.parseInt(log[i]);
                    min++;
                    minplace.add(lastbreak);
                }
                if(i-Integer.parseInt(log[i])<lastbreak){
                    exit = true;
                    break;
                }
            }
        }
        int counter = 0;
        int arrcount = 0;
        if(!exit){
            for(int k = 0;k<num;k++){
                System.out.println(minplace.get(k));
                if(k == minplace.get(arrcount)){
                    counter = 0;
                    arrcount++;
                }else{
                    if(Integer.parseInt(log[k])<=counter){
                        exit = true;
                        break;
                    }else{
                        counter = Integer.parseInt(log[k]);
                    }
                }
            }
        }
        int max = 1;
        lastbreak = 0;
        if(!exit){
            for(int j = 1;j<num;j++){
                if(log[j].equals("-1")){
                    max++;
                }else{
                    if(max == 0){
                        max++;
                    }
                }
            }
        }
        if(exit){
            pw.println("-1");
        }else{
            pw.println(min +" "+max);
        }
        pw.close();
    }
}