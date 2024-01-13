import java.util.*;
class yearofthecow{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        HashMap<String,Integer> cowtoyear = new HashMap<>();
        cowtoyear.put("Ox",0);
        cowtoyear.put("Tiger",1);
        cowtoyear.put("Rabbit",2);
        cowtoyear.put("Dragon",3);
        cowtoyear.put("Snake",4);
        cowtoyear.put("Horse",5);
        cowtoyear.put("Goat",6);
        cowtoyear.put("Monkey",7);
        cowtoyear.put("Rooster",8);
        cowtoyear.put("Dog",9);
        cowtoyear.put("Pig",10);
        cowtoyear.put("Rat",11);
        HashMap<String,Integer> nametoint = new HashMap<>();
        String[][] input = new String[num][4];
        for(int i = 0;i<num;i++){
            String[] line = s.nextLine().split(" ");
            nametoint.put(line[7],i);
            for(int j = 0;j<4;j++){
                input[i][0] = line[0];
                input[i][1] = line[3];
                input[i][2] = line[4];
                input[i][3] = line[7];
            }
        }
        int num2 = nametoint.get("Bessie");
        int ans = 0;
        String year = "Ox";
        while(true){
            if(input[num2][1].equals("previous")){
                if(cowtoyear.get(input[num2][2]) > cowtoyear.get(year)){
                    ans += (12-cowtoyear.get(input[num2][2])+ cowtoyear.get(year))*-1;
                }else{
                    ans += cowtoyear.get(input[num2][2])-cowtoyear.get(year);
                }
            }else{
                if(cowtoyear.get(input[num2][2]) < cowtoyear.get(year)){
                    ans += (12-cowtoyear.get(input[num2][2])+ cowtoyear.get(year))*-1;
                }else{
                    ans += cowtoyear.get(input[num2][2])-cowtoyear.get(year);
                }
            }
            year = input[num2][2];
            System.out.println(input[num2][0]);
            num2 = nametoint.get(input[num2][0]);
            if(input[num2][0].equals("Elsie")){
                break;
            }
        }
        System.out.println(ans);
    }
}