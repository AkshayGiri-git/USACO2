import java.util.*;
class countingliars{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int numval = Integer.parseInt(s.nextLine());
        boolean[] fbessie = new boolean[1000000000];
        String[] values = new String[1000];
        int best2 = 0;
        for(int i = 0;i<numval;i++){
            String[] line = s.nextLine().split(" ");
            values[i] = line[0]+" "+line[1];
            if(line[0].equals("G")) {
                //fbessie[Integer.parseInt(line[1])] = 1;
            }else{
                //fbessie[Integer.parseInt(line[1])] = 2;
            }
            if(Integer.parseInt(line[1])>best2){
                best2 = Integer.parseInt(line[1]);
            }
        }
        int best = Integer.MAX_VALUE;
        int curr = 0;

        for(int j = 0;j<fbessie.length;j++) {
            if (j == best2) {
                break;
            }

            //if (fbessie[j] != 0) {

                for (int k = 0; k < numval; k++) {


                    String[] input = values[k].split(" ");
                    //if(fbessie[j] == 1){
                        if(input[0].equals("G") || Integer.parseInt(input[1])>=j){

                        }else{
                            curr++;
                        }
                    //}else{
                        if(input[0].equals("L") || Integer.parseInt(input[1])<=j){

                        }else{
                            curr++;
                        }
                    //}
                }
                if(curr<best){
                    best = curr;

                }
                curr = 0;
           // }
        }
        System.out.println(best);
    }
}