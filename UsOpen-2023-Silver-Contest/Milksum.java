import java.util.*;

public class Milksum{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long num = Integer.parseInt(s.nextLine());
        String[] milk2 = s.nextLine().split(" ");
        long[][] milk = new long[milk2.length][2];
        for(int i = 0;i<milk.length;i++){
            milk[i][0] = Integer.parseInt(milk2[i]);
            milk[i][1] = i;
        }
        Arrays.sort(milk, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0],o2[0]);
            }
        });
        long[] search = new long[milk.length+2];
        long[] sums = new long[milk.length];
        HashMap<Long,Integer> firstoccurance = new HashMap<Long,Integer>();
        HashMap<Long,Integer> posinoldtonew = new HashMap<Long,Integer>();
        long sum = 0;
        long firstarrayans = 0;
        for(int j = 0;j<milk.length;j++){
            posinoldtonew.put(milk[j][1],j);
            search[j+1] = milk[j][0];
            sums[j] = sum+milk[j][0];
            sum+= milk[j][0];
            if(!firstoccurance.containsKey(milk[j][0])){
                firstoccurance.put(milk[j][0],j);
            }
            firstarrayans += (j+1)*milk[j][0];
        }
        search[0] = Integer.MIN_VALUE;
        search[search.length-1] = Integer.MAX_VALUE;
        int num2 = Integer.parseInt(s.nextLine());
        long[] anses = new long[num2];
        for(int k = 0;k<num2;k++){

            String[] line = s.nextLine().split(" ");
            long numreplacing = Long.parseLong(line[0])-1;
            long numreplacingw = Long.parseLong(line[1]);
            int pos = binarysearchin(-1,search.length,search,numreplacingw,firstoccurance);
            int pos2 = posinoldtonew.get(numreplacing);
            long sum2= 0;
            if(milk[pos2][0] == numreplacingw){
                anses[k] = firstarrayans;
            }else if(milk[pos2][0]>numreplacingw){
                if(pos-1 == -1){
                    sum2 = sums[pos2-1];
                }else{
                    sum2 = sums[pos2-1]-sums[pos-1];


                }
                anses[k] = firstarrayans-(milk[pos2][0]*(pos2+1))+(numreplacingw*(pos+1))+sum2;
            }else{
                sum2 = sums[pos-1]-sums[pos2];

                anses[k] = firstarrayans-(milk[pos2][0]*(pos2+1))+(numreplacingw*pos)-sum2;
            }
        }


        for(int z = 0;z<anses.length;z++){
            System.out.println(anses[z]);
        }
    }

    private static int binarysearchin(int low, int high, long[] search, long search2, HashMap<Long, Integer> firstoccurance) {
        int mid = (low+high)/2;
        int num = 0;
        if(search[mid]>search2){
            if(search[mid-1]<search2){
                return  mid-1;
            }else{
                num = binarysearchin(low,mid-1,search,search2,firstoccurance);
            }
        }
        if(search[mid]<search2){
            if(search[mid+1]>search2){
                return  mid;
            }else{
                num = binarysearchin(mid+1,high,search,search2,firstoccurance);
            }
        }
        if(search[mid] == search2){
            return firstoccurance.get(search2);
        }
        return num;
    }

}