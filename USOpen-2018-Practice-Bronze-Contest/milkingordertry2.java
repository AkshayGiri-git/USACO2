import java.util.*;
import java.io.*;
class milkingordertry2 {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("milkorder.in"));
            pw = new PrintWriter(new FileWriter("milkorder.out"));
        }catch(Exception e){

        }
        String[] fline = s.nextLine().split(" ");
        int cows = Integer.parseInt(fline[0]);
        int requests = Integer.parseInt(fline[2]);
        String[] hierarchy = s.nextLine().split(" ");
        String[] positions = new String[cows];
        for(int i = 0;i<requests;i++){
            String[] line = s.nextLine().split(" ");
            if(line[0].equals("1")){
                pw.println(line[1]);
                pw.close();
                return;
            }
            positions[Integer.parseInt(line[1])-1] = line[0];
        }
        String[] positions2 = new String[positions.length];
        int counter = 0;
        boolean exit = false;
        for(int j = 0;j<positions.length;j++){
            if(positions[j] != null){
                continue;
            }
            for(int k = 0;k<positions.length;k++){
                positions2[k] = positions[k];
            }
            for(int l = 0;l<positions.length;l++){
                if(l == j){
                    positions2[l] = "1";
                }
                if(counter >= hierarchy.length){
                    pw.println(j);
                    pw.close();
                    return;
                }
                if(positions2[l] == null){
                    positions2[l] = hierarchy[counter];
                    counter++;
                    if(counter >= hierarchy.length){
                        pw.println(j+1);
                        pw.close();
                        return;
                    }
                }
                if(positions2[l].equals(hierarchy[counter])) {
                    counter++;
                    continue;
                }else{
                    for(int n = counter;n<hierarchy.length;n++){
                        if(positions2[l].equals(hierarchy[n])){
                            exit = true;
                            break;
                        }
                    }
                    if(exit){
                        break;
                    }
                }

            }
            exit = false;
            counter = 0;

        }
    }
}