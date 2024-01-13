import java.util.*;
class cowfield {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        int length = Integer.parseInt(line[0]);
        int numl = Integer.parseInt(line[1]);
        HashSet<Integer> nodups = new HashSet<Integer>();
        HashSet<String> nodups2 = new HashSet<String>();
        int[] nums = new int[numl];
        for(int i = 0;i<numl;i++){
            String line2 = s.nextLine();
            if(!nodups2.contains(line2)) {
                String bits = "";
                for (int z = 0; z < length; z++) {
                    if (line2.charAt(z) == 'G') {
                        bits += "1";
                    } else {
                        bits += "0";
                    }

                }
                int num2 = Integer.parseInt(bits, 2);
                nums[i] = num2;
                nodups.add(num2);
                nodups2.add(line2);
            }

        }
        HashMap<Integer,Integer> anses = new HashMap<Integer,Integer>();
        int best = 0;

        for(Integer j : nodups){
            for(Integer k : nodups){
                if(!j.equals(k)){



                    int num = Integer.bitCount(j^k);
                    if(num>best){
                        best = num;
                    }
                }


            }
            anses.put(j,best);
            best = 0;
        }
        for(int z = 0;z<numl;z++){
            System.out.println(anses.get(nums[z]));
        }
    }
}