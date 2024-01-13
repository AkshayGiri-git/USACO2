import java.util.*;
class comfortablecows{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        HashMap<String,Integer> count = new HashMap<>();
        String[] input = new String[num];
        for(int z = 0;z<num;z++){
            input[z] = s.nextLine();
        }
        int num2 = 0;
        int num3 = 0;
        for(int i = 0;i<num;i++){

            String[] line2 = input[i].split(" ");
            for(int j = 0;j<i;j++){
                String[] line = input[j].split(" ");
                if(Integer.parseInt(line[0]) == Integer.parseInt(line2[0])){
                    if(Integer.parseInt(line[1]) == Integer.parseInt(line2[1])-1){
                        num3++;
                        count.replace(input[j],count.get(input[j])+1);
                        if(count.get(input[j]) == 3){
                           // System.out.println(input[j] +"ii");
                            num2++;
                        }
                        if(count.get(input[j]) == 4){
                            num2--;
                        }
                    }else if(Integer.parseInt(line[1]) == Integer.parseInt(line2[1])+1){
                        num3++;
                        count.replace(input[j],count.get(input[j])+1);
                        if(count.get(input[j]) == 3){
                            num2++;
                            //System.out.println(input[j] +"j");
                        }
                        if(count.get(input[j]) == 4){
                            num2--;
                        }
                    }
                }else if(Integer.parseInt(line[1]) == Integer.parseInt(line2[1])){
                    if(Integer.parseInt(line[0]) == Integer.parseInt(line2[0])-1){
                        num3++;
                        count.replace(input[j],count.get(input[j])+1);
                        if(count.get(input[j]) == 3){
                            num2++;
                            //System.out.println(input[j]+"jj");
                        }
                        if(count.get(input[j]) == 4){
                            num2--;
                        }
                    }else if(Integer.parseInt(line[0]) == Integer.parseInt(line2[0])+1){
                        count.replace(input[j],count.get(input[j])+1);
                        num3++;
                        if(count.get(input[j]) == 3){
                            num2++;
                            //System.out.println(input[j]+"i");
                        }
                        if(count.get(input[j]) == 4){
                            num2--;
                        }
                    }
                }
            }
            if(num3 == 3){
                num2++;
            }
            count.put(input[i],num3);
            num3 = 0;
            System.out.println(num2);
        }
    }
}