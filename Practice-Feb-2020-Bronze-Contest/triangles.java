import java.util.*;
import java.io.*;
class triangles{
   static Scanner s;
   static PrintWriter pw;

   public static void main(String args[]){
       try{
           s = new Scanner(new File("triangles.in"));
           pw = new PrintWriter(new FileWriter("triangles.out"));
       }catch(Exception e){

       }

       int size = Integer.parseInt(s.nextLine());
       int[] x = new int[size];
       int[] y = new int[size];
       int[] xmatch = new int[size];
       int[] ymatch = new int[size];
       boolean[] matchx = new boolean[size];
       boolean[] matchy = new boolean[size];
       ArrayList<Integer> validx = new ArrayList<Integer>();
       ArrayList<Integer> validy = new ArrayList<Integer>();
       for(int i = 0;i<size;i++){
           String input = s.nextLine();
           String[] splits = input.split(" ");
           x[i] = Integer.parseInt(splits[0]);
           y[i] = Integer.parseInt(splits[1]);
       }
       int k = 0;
       int best2 = 0;

       for(int j = 0;j<size;j++){

           while(k<size){

               if(j == 1){

               }
               if(k == j){
                   if(k == size-1){


                       break;
                   }
                   k++;
               }

               if(x[j] == x[k]){
                   if(matchx[j] == true){
                       if(Math.abs(y[j]-y[k])>xmatch[j]){
                           xmatch[j] = Math.abs(y[j]-y[k]);
                       }
                   }else {
                       if(j == 2){

                       }
                       xmatch[j] = Math.abs(y[j] - y[k]);

                       matchx[j] = true;
                   }
               }
               if(y[j] == y[k]){


                   if(matchy[j] == true){
                       if(Math.abs(x[j]-x[k])>ymatch[j]){
                           ymatch[j] = Math.abs(x[j]-x[k]);
                       }
                   }else {

                       if(j == 2){

                       }

                       ymatch[j] = Math.abs(x[j] - x[k]);

                       matchy[j] = true;
                   }
               }
               k++;
           }
           if(matchx[j] == true && matchy[j] == true) {
               if(xmatch[j]*ymatch[j]>best2){
                   best2 = xmatch[j]*ymatch[j];
               }
           }
           k = 0;

       }

       pw.println(best2);
       pw.close();


   }
}