import java.util.*;
import java.io.*;
class milkmeasurment{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner( new File ("measurement.in"));
            pw = new PrintWriter( new FileWriter("measurement.out"));

        }catch(Exception e){

        }
        int Bessiemilk = 7;
        boolean[] maxholders = new boolean[3];
        maxholders[0] = true;
        maxholders[1] = true;
        maxholders[2] = true;
        int Elsiemilk = 7;
        int Mildredmilk = 7;
        int change = 0;
        int max = 7;
        int logs = Integer.parseInt(s.nextLine());
        HashMap<Integer,String> milk = new HashMap<Integer,String>();
        int[] days = new int[logs];
        for(int i = 0;i<logs;i++){
            String line = s.nextLine();
            String [] parts = line.split(" ");
            days[i] = Integer.parseInt(parts[0]);
            milk.put(days[i],line);

        }
        Arrays.sort(days);
        String[] milkchange = new String[2];
        for(int j = 0;j<logs;j++){
            String[] parts2 = milk.get(days[j]).split(" ");

            if(parts2[1].equals( "Bessie")){
                milkchange = parts2[2].split("");

                if(milkchange[0] == "-"){
                    Bessiemilk = Bessiemilk - Integer.parseInt(milkchange[1]);
                }else{
                    Bessiemilk = Bessiemilk + Integer.parseInt(milkchange[1]);


                }
                if(Bessiemilk>max){
                    maxholders[1] = false;
                    maxholders[2] = false;
                    maxholders[0] = true;
                    max = Bessiemilk;
                    change++;
                }else if(Bessiemilk == max){
                    maxholders[0] = true;
                    change++;
                }else{
                    if(maxholders[0] == true){
                        if(Bessiemilk<max){
                            maxholders[0] = false;
                            change++;
                        }else{
                            change++;
                        }
                    }
                }
            }
            if(parts2[1].equals( "Mildred")){
                milkchange = parts2[2].split("");
                if(milkchange[0] == "-"){
                    Mildredmilk = Mildredmilk - Integer.parseInt(milkchange[1]);
                }else{
                    Mildredmilk = Mildredmilk + Integer.parseInt(milkchange[1]);

                }
                if(Mildredmilk>max){
                    maxholders[0] = false;
                    maxholders[2] = false;
                    maxholders[1] = true;
                    max = Mildredmilk;
                    change++;
                }else if(Mildredmilk == max){
                    maxholders[1] = true;
                    change++;
                }else{
                    if(maxholders[1] == true){
                        if(Mildredmilk<max){
                            maxholders[1] = false;
                            change++;
                        }else{
                            change++;
                        }
                    }
                }
            }
            if(parts2[1].equals( "Elsie")){
                milkchange = parts2[2].split("");
                if(milkchange[0] == "-"){
                    Elsiemilk = Elsiemilk - Integer.parseInt(milkchange[1]);
                }else{
                    Elsiemilk = Elsiemilk + Integer.parseInt(milkchange[1]);

                }
                if(Elsiemilk>max){
                    maxholders[1] = false;
                    maxholders[0] = false;
                    maxholders[2] = true;
                    max = Elsiemilk;
                    change++;
                }else if(Elsiemilk == max){
                    maxholders[2] = true;
                    change++;
                }else{
                    if(maxholders[2] == true){
                        if(Elsiemilk<max){
                            maxholders[2] = false;
                            change++;
                        }else{
                            change++;
                        }
                    }
                }
            }
        }
        pw.println(change);
        pw.close();
    }
}