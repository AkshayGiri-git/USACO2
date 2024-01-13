import java.util.*;
import java.io.*;
public class searchingforsoulmates{
    public static void main(String[] args){
       Scanner s = new Scanner(System.in);
       int size = Integer.parseInt(s.nextLine());
       long[][] input = new long[size][2];
       for(int i = 0;i<size;i++){
           String[] line = s.nextLine().split(" ");
           input[i][0] = Long.parseLong(line[0]);
           input[i][1] = Long.parseLong(line[1]);
       }
       for(int j = 0;j<size;j++) {
           long firstpart = 0;
           while (true) {
                if(input[j][0]<=input[j][1]){
                    break;
                }
                if(input[j][0] % 2 == 0){
                    firstpart++;
                    input[j][0] = input[j][0]/2;
                }else{
                    firstpart = firstpart+2;
                    input[j][0] = (input[j][0]+1)/2;
                }
           }
           if(input[j][0] == input[j][1]){
               System.out.println(firstpart);
               continue;
           }
           long curr = input[j][1];
           boolean lessthanhalf = false;
           if(input[j][1] % 2 == 0){
               if(input[j][1]/2 >= input[j][0]) {
                   lessthanhalf = true;
               }
           }else{
               if((input[j][1]-1)/2 >= input[j][0]){
                   lessthanhalf = true;
               }
           }
           ArrayList<Long> factors = new ArrayList<Long>();
           while(true){
               factors.add(curr);
               if(curr == 1){
                   break;
               }
                if(curr %2 == 0){
                    curr = curr/2;
                }else{
                    curr = (curr-1)/2;
                }

           }
           long temp = input[j][0];
           long temp2 = 0;
           long factor = 0;
           long prevbest = input[j][1] - input[j][0];
           while(true){
               if(!lessthanhalf) {
                   if (temp % 2 == 0) {
                       temp = temp / 2;
                       temp2 = temp2 + 1;
                   } else {
                       temp = (temp + 1) / 2;
                       temp2 = temp2 + 2;
                   }
               }
                int erase = 0;
               for(int k = 0;k<factors.size();k++){
                    if(factors.get(k)<temp) {

                        factor = factors.get(k - 1);
                        temp2 += (k - 1);
                        erase += k-1;
                        break;
                    }
                   if (k != 0) {
                       if (factors.get(k - 1) % 2 == 1) {
                           temp2++;
                           erase++;
                       }
                   }
                    if(k == factors.size()-1){
                        factor = factors.get(factors.size()-1);
                    }
               }
               if((factor-temp)+temp2<prevbest){
                    prevbest = (factor-temp)+temp2;
                    temp2 = temp2-erase;
                    lessthanhalf = false;
               }else{

                   System.out.println(firstpart+prevbest);
                   break;
               }
           }
       }
    }
}