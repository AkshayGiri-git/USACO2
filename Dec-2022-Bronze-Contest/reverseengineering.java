import java.util.*;
public class reverseengineering{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int testcases = Integer.parseInt(s.nextLine());
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 0;i< testcases;i++){
            s.nextLine();
            String[] fline = s.nextLine().split(" ");
            int[][] input = new int[Integer.parseInt(fline[1])][Integer.parseInt(fline[0])];
            int[] answers = new int[Integer.parseInt(fline[1])];
            for(int j = 0;j<Integer.parseInt(fline[1]);j++){
                String[] line = s.nextLine().split(" ");
                answers[j] = Integer.parseInt(line[1]);
                String[] line2 = line[0].split("");
                for(int k = 0;k<line2.length;k++){
                    input[j][k] = Integer.parseInt(line2[k]);
                }
            }

            boolean exit = false;

            boolean pass3 = true;
            int remove = 0;
            while(true){

                for(int m = 0;m<Integer.parseInt(fline[0]);m++){
                    int pass = 2;
                    int pass2 = 2;
                     exit = false;


                    int map1 = -1;
                    int map0 = -1;
                    for(int n = remove;n<Integer.parseInt(fline[1]);n++){
                        if(input[n][m] == 0){
                            if(map0 == -1){
                                map0 = answers[n];
                                if(pass!=0){
                                    pass = 1;
                                }
                            }else{
                                if(answers[n] != map0){
                                    pass = 0;
                                }
                            }
                        }else{
                            if(map1 == -1){
                                map1 = answers[n];
                                if(pass!= 0){
                                    pass = 1;
                                }
                            }else{
                                if(answers[n] != map1){
                                    pass2 = 0;
                                }
                            }
                        }
                    }
                    if(pass == 2){
                        pass = 0;
                    }
                    if(pass2 == 2){
                        pass2 = 0;
                    }
                    if(pass == 0 && pass2 == 0){
                        pass3 = false;
                    }
                    if(!pass3 && m == Integer.parseInt(fline[0])-1){
                        exit = true;
                        ans.add("LIE");
                        break;

                    }
                    if(pass == 1 || pass2 == 1){
                        remove++;
                        pass3 = true;
                        break;
                    }
                }
                if(exit){
                    break;
                }
                if(remove >= Integer.parseInt(fline[1])) {
                    ans.add("OK");
                    break;
                }
            }
        }
        for(int z = 0;z<ans.size();z++){
            System.out.println(ans.get(z));
        }
    }
}