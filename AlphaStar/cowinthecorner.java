import java.lang.Math;
import java.util.*;
class cowinthecorner{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String [] fline = s.nextLine().split(" ");
        int pieces = Integer.parseInt(fline[0]);
        int l = Integer.parseInt(fline[1]);
        String[] lengths1 = s.nextLine().split(" ");
        int[] lengths = new int[lengths1.length];
        for(int z = 0;z<lengths1.length;z++){
            lengths[z] = Integer.parseInt(lengths1[z]);
        }
        double best = 0;
        double curr = 0;
        double curr2 = 0;
        double sper = 0;
        double bests1 = 0;
        double bests2 = 0;
        double bests3 = 0;
        double s1 = 0;
        double s2 = 0;
        double s3 = 0;
        for(int i = 0;i<pieces;i++){
            for(int j = i+1;j<pieces;j++){


                for (double k = Double.valueOf(l); k > 0; k--) {

                    if(lengths[i]+lengths[j] <= k || lengths[i]+k <= lengths[j] || k+lengths[j] <= lengths[i]){

                    }else {
                        sper = (Double.valueOf(lengths[i]) + Double.valueOf(lengths[j]) + k) / 2;
                        curr = Math.sqrt(sper * (sper - Double.valueOf(lengths[i])) * (sper - Double.valueOf(lengths[j])) * (sper - k));
                        if (curr < curr2) {
                            if (k < Double.valueOf(lengths[i])) {
                                s1 = k+1;
                                s2 = Double.valueOf(lengths[i]);
                                s3 = Double.valueOf(lengths[j]);
                            } else if (k < Double.valueOf(lengths[j])) {
                                s1 = Double.valueOf(lengths[i]);
                                s2 = k+1;
                                s3 = Double.valueOf(lengths[j]);
                            } else {
                                s1 = Double.valueOf(lengths[i]);
                                s2 = Double.valueOf(lengths[j]);
                                s3 = k+1;
                            }
                            break;
                        } else {
                            curr2 = curr;
                        }
                    }
                }

                if(curr2>best){
                    best = curr2;
                    bests1 = s1;
                    bests2 = s2;
                    bests3 = s3;
                }
            }
        }
        for(int  a = 0;a<pieces;a++){
            for(int  b = a+1;b<pieces;b++){
                for(int c= b+1;c<pieces;c++) {
                    if (lengths[a] + lengths[b] <= lengths[c] || lengths[a] + lengths[c] <= lengths[b] || lengths[b] + lengths[c] <= lengths[a]) {

                    } else {
                        System.out.println("hello");
                        sper = (Double.valueOf(lengths[a]) + Double.valueOf(lengths[b]) + Double.valueOf(lengths[c])) / 2;
                        curr = Math.sqrt(sper * (sper - Double.valueOf(lengths[a])) * (sper - Double.valueOf(lengths[b])) * (sper - Double.valueOf(lengths[c])));
                        s1 = Double.valueOf(lengths[a]);
                        s2 = Double.valueOf(lengths[b]);
                        s3 = Double.valueOf(lengths[c]);
                        if (curr > best) {
                            best = curr;
                            bests1 = s1;
                            bests2 = s2;
                            bests3 = s3;
                        }
                    }



                }
            }
        }

        int side1 = (int) bests1;
        int side2 = (int) bests2;
        int side3 = (int) bests3;
        if(side1 == 0 && side2 == 0 && side3 == 0){
            System.out.println(-1 +" "+ -1 +" "+ -1 +" ");
        }
        System.out.println(side1+" "+side2+" "+side3);
    }
}