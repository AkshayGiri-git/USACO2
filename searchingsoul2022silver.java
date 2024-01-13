import java.util.*;
public class searchingsoul2022silver {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int testnum = Integer.parseInt(s.nextLine());
        int j = 0;
        String[] input = new String[testnum];
        for(int z = 0;z<testnum;z++){
            input[z] = s.nextLine();
        }
        for(int i = 0;i<testnum;i++){
            String[] line = input[i].split(" ");
            int personality = Integer.parseInt(line[0]);

            while(true) {
                if (personality>Integer.parseInt(line[1])){
                    if(personality % 2 == 1){
                        personality++;
                        j++;
                    }
                        personality = personality/2;
                        j++;
                }else if(personality == Integer.parseInt(line[1])){
                    break;
                }else{
                    int personality2 = personality;
                    int k = 0;
                    while(true){
                        if((personality+k)*2>Integer.parseInt(line[1])){
                            break;
                        }else{
                            personality2 = (personality+k)*2;
                        }
                        k++;
                    }
                    personality = personality2;
                    j += k;
                    j += Integer.parseInt(line[1])-personality;
                    break;
                }
            }
            System.out.println(j);
            j = 0;
        }

    }
}
