import java.util.*;
import java.io.*;
class cowevolution{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("evolution.in"));
            pw = new PrintWriter(new FileWriter("evolution.out"));
        }catch(Exception e){

        }
        int num = Integer.parseInt(s.nextLine());
        String[][] input = new String[num][];
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            input[i] = new String[Integer.parseInt(line[0])];
            for(int j = 0;j<Integer.parseInt(line[0]);j++){
                input[i][j] = line[j+1];
            }
        }
        for(int i = 0;i<num;i++){
            int counter = 0;
            for(int j = 0;j<num;j++){

                if(i != j || input[j].length < input[i].length) {



                    boolean pass = true;
                    boolean pass2 = false;
                    for (int k = 0; k < input[j].length; k++) {

                        for (int l = 0; l < input[i].length; l++) {
                            if (input[j][k].equals(input[i][l])) {
                                pass2 = true;
                            }
                        }
                        if(!pass2){
                            pass = false;
                            break;
                        }else{
                            pass2 = false;
                        }
                    }
                    if(input[j].length == 0){
                        pass = false;
                    }

                    if (pass) {
                        counter++;
                    }
                }
            }
           if(counter>=2){
               pw.println("no");
               pw.close();
               break;
           }
        }
        pw.println("yes");
        pw.close();
    }
}