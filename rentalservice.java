import java.util.*;
import java.io.*;
public class rentalservice {
    static Scanner s;
    static PrintWriter pw;
    public static void main(String[] args){
        try{
            s = new Scanner(new File("rental.in"));
            pw = new PrintWriter(new FileWriter("rental.out"));
        }catch(Exception e){

        }
        String [] line = s.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int r = Integer.parseInt(line[2]);
        int[] cowmilk = new int[n];
        long[] cowmilk2 = new long[n];
        long[][] stores = new long[k][2];
        int[] rentals = new int[r];
        long[] rentals2 = new long[r];
        long[] stores2 = new long[k];
        long[] stores3 = new long[k];
        for(int i = 0;i<n;i++){
            cowmilk[i] = Integer.parseInt(s.nextLine());
        }
        for(int j = 0;j<k;j++){
            String[] line2 = s.nextLine().split(" ");
            stores[j][0] = Long.parseLong(line2[0]);
            stores[j][1] = Long.parseLong(line2[1]);
        }
        for(int l= 0;l<r;l++){
            rentals[l] = Integer.parseInt(s.nextLine());
        }
        Arrays.sort(rentals);
        Arrays.sort(cowmilk);
        Arrays.sort(stores,(a,b)-> (int) (a[1]-b[1]));
        long sum = 0;
        for(int x = r-1;x>=0;x--){
            sum+=rentals[x];
            rentals2[r-x-1] = sum;

        }
        sum = 0;
        for(int x = n-1;x>=0;x--){
            sum+=cowmilk[x];
            cowmilk2[n-x-1] = sum;

        }
        sum = 0;
        long sum2 = 0;
        for(int x = k-1;x>=0;x--){
            sum+=stores[x][0]*stores[x][1];
            sum2+= stores[x][0];
            stores2[k-x-1] = sum;
            stores3[k-x-1] = sum2;

        }
        long max = 0;
        for(int y = 0;y<=cowmilk2.length;y++){
            long milk = 0;
            long total = 0;
            if(y!=0) {
                 milk = cowmilk2[y-1];
                 total = binarysearch(milk, stores2, stores3, stores);
            }
            long rentmoney;
            if(n-y-1>= rentals2.length){
                rentmoney = rentals2[rentals.length-1];
            }else {
                if(n-y-1<0){
                    rentmoney = 0;
                }else {
                    rentmoney = rentals2[n - y - 1];
                }
            }
            System.out.println(total + " " +rentmoney +" " +y);
            System.out.println(total+ rentmoney + " hello");
            max = Long.max(max,total+rentmoney);
        }
        pw.println(max);
        pw.close();
    }
    public static long binarysearch(long milk, long[] stores2, long[] stores3,long[][] stores){
        int left = 0;
        int right = stores2.length-1;
        int pos = 0;
        while(true){
            int mid = (left+right)/2;
            if(left >= right) {
                pos = mid;
                break;
            }
            if(stores3[mid]>milk){
                right = mid;
            }else if(stores3[mid]<milk){
                left = mid+1;
            }else{
                return stores2[mid];
            }
        }
        if(pos == 0){
            return milk*stores[stores.length-1][1];
        }else{
            if(milk>stores3[stores3.length-1]){
                return stores2[stores2.length-1];
            }
            return stores2[pos-1]+((milk-stores3[pos-1])*stores[pos][1]);
        }
    }
}
