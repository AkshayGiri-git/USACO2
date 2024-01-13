import java.util.*;
import java.io.*;
public class livestocklineup {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("lineup.in"));
            pw = new PrintWriter(new FileWriter("lineup.out"));
        }catch(Exception e){

        }
        int size = Integer.parseInt(s.nextLine());
        String[] input = new String[size];
        for(int i = 0;i<size;i++){
            input[i] = s.nextLine();
        }
        int[] combinations2 = {1,2,3,4,5,6,7,8};
        ArrayList<String> arr1 = new ArrayList<String>();
        arr1.add("12");
        arr1.add("21");
        ArrayList<String> arr2 = new ArrayList<String>();
        String[] pos = {"123","213","312"};
        combs(3,arr1,arr2,pos);
        pos = new String[] {"1234", "2134", "3124", "4123"};
        arr1.clear();
        combs(4,arr2,arr1,pos);
        pos = new String[] {"12345", "21345", "31245", "41235","51234"};
        arr2.clear();
        combs(5,arr1,arr2,pos);
        pos = new String[] {"123456", "213456", "312456", "412356","512346","612345"};
        arr1.clear();
        combs(6,arr2,arr1,pos);
        pos = new String[] {"1234567", "2134567", "3124567", "4123567","5123467","6123457","7123456"};
        arr2.clear();
        combs(7,arr1,arr2,pos);
        pos = new String[] {"12345678", "21345678", "31245678", "41235678","51234678","61234578","71234568","81234567"};
        arr1.clear();
        combs(8,arr2,arr1,pos);
        HashMap<String,Integer> nametonum = new HashMap<String,Integer>();
        nametonum.put("Beatrice",1);
        nametonum.put("Belinda",2);
        nametonum.put("Bella",3);
        nametonum.put("Bessie",4);
        nametonum.put("Betsy",5);
        nametonum.put("Blue",6);
        nametonum.put("Buttercup",7);
        nametonum.put("Sue",8);
        HashMap<Integer,String> numtoname = new HashMap<Integer,String>();
        numtoname.put(1,"Beatrice");
        numtoname.put(2,"Belinda");
        numtoname.put(3,"Bella");
        numtoname.put(4,"Bessie");
        numtoname.put(5,"Betsy");
        numtoname.put(6,"Blue");
        numtoname.put(7,"Buttercup");
        numtoname.put(8,"Sue");
        HashMap<Integer,Integer> pos2 = new HashMap<Integer,Integer>();
        boolean pass = true;
        for(int j = 0;j<arr1.size();j++){
            for(int z = 0;z<8;z++){
                pos2.put(Integer.parseInt(String.valueOf(arr1.get(j).charAt(z))),z);
            }
            for(int k = 0;k<size;k++){
                String[] line = input[k].split(" ");
                if(Math.abs(pos2.get(nametonum.get(line[0])) - pos2.get(nametonum.get(line[5]))) != 1){
                    pass = false;
                }
            }

            if(pass){
                for(int y = 0;y<8;y++){
                    pw.println(numtoname.get(Integer.parseInt(String.valueOf(arr1.get(j).charAt(y)))));

                }
                pw.close();
                break;
            }
            pass = true;
        }
    }
    public static void combs (int num,ArrayList<String> arr1,ArrayList<String> arr2,String[] pos){
       for(int i = 0;i<num;i++){
           HashMap<Integer,Integer> maps = new HashMap<Integer,Integer>();

               for (int j = 1; j < num; j++) {
                   maps.put(Integer.parseInt(String.valueOf(arr1.get(0).charAt(j - 1))), Integer.parseInt(String.valueOf(pos[i].charAt(j))));
               }

           for(int z = 0;z<arr1.size();z++) {
                    String comb = String.valueOf(i+1);
                   for(int l = 0;l<num-1;l++){
                       comb+= maps.get(Integer.parseInt(String.valueOf(arr1.get(z).charAt(l))));
                   }
                   arr2.add(comb);


           }
            maps.clear();
       }
    }
}