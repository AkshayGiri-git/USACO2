import java.util.*;
import java.io.*;
class notlast{
static Scanner s;
static PrintWriter pw;
    public static void main(String [] args){
        try{
            s = new Scanner(new File ("notlast.in"));
            pw = new PrintWriter(new FileWriter("notlast.out"));
        }catch(Exception e ){

        }

        int entries = Integer.parseInt(s.nextLine());
        int a = 0;
        int b = 0;
        int d = 0;
        int e = 0;
        int g = 0;
        int h = 0;
        int m = 0;
        int last = 1000000000;
        String cowlast = "";
        boolean tielast = false;
        int last2 = 1000000000;
        String cowlast2 = "";
        boolean tielast2 = false;

        for(int j = 0;j<entries;j++){
            String[] line = s.nextLine().split(" ");
            if( line[0] .equals("Annabelle")){
                a+= Integer.parseInt(line[1]);
            }
            if( line[0] .equals("Bessie")){
                b+= Integer.parseInt(line[1]);
            }
            if( line[0] .equals( "Daisy")){
                d+= Integer.parseInt(line[1]);
            }
            if( line[0] .equals("Elsie")){
                e+= Integer.parseInt(line[1]);
            }if( line[0] .equals( "Gertie")){
                g+= Integer.parseInt(line[1]);
            }
            if( line[0] .equals("Henrietta")){
                h+= Integer.parseInt(line[1]);
            }
            if( line[0] .equals( "Maggie")){
                m+= Integer.parseInt(line[1]);
            }






        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println(e);
        System.out.println(g);
        System.out.println(h);
        System.out.println(m);
        for(int i = 0;i<7;i++){

            if(i == 0){

                if(a<last){
                    last2 = last;
                    last = a;
                    cowlast2 = cowlast;
                    cowlast = "Annabelle";
                    tielast = false;
                }else if(a == last){
                    tielast = true;
                }else if(a<last2){
                    last2 = a;
                    cowlast2 = "Annabelle";
                    tielast2 = false;
                }else if(a==last2){
                    tielast2 = true;
                }

            }
            if(i == 1){

                if(b<last){
                    last2 = last;
                    last = b;
                    cowlast2 = cowlast;
                    cowlast = "Bessie";
                    tielast = false;
                }else if(b == last){
                    tielast = true;
                }else if(b<last2){
                    last2 = b;
                    cowlast2 = "Bessie";
                    tielast2 = false;
                }else if(b==last2){
                    tielast2 = true;
                }

            }
            if(i == 2){

                if(d<last){
                    last2 = last;
                    last = d;
                    cowlast2 = cowlast;
                    cowlast = "Daisy";
                    tielast = false;
                }else if(d == last){
                    tielast = true;
                }else if(d<last2){
                    last2 = d;
                    cowlast2 = "Daisy";
                    tielast2 = false;
                }else if(d==last2){
                    tielast2 = true;
                }

            }
            if(i == 3){

                if(e<last){
                    last2 = last;
                    last = e;
                    cowlast2 = cowlast;
                    cowlast = "Elsie";
                    tielast = false;
                }else if(e == last){
                    tielast = true;
                }else if(e<last2){
                    last2 = e;
                    cowlast2 = "Elsie";
                    tielast2 = false;
                }else if(e==last2){
                    tielast2 = true;
                }

            }
            if(i == 4){

                if(g<last){
                    last2 = last;
                    last = g;
                    cowlast2 = cowlast;
                    cowlast = "Gertie";
                    tielast = false;
                }else if(g == last){
                    tielast = true;
                }else if(g<last2){
                    last2 = g;
                    cowlast2 = "Gertie";
                    tielast2 = false;
                }else if(g==last2){
                    tielast2 = true;
                }

            }
            if(i == 5){

                if(h<last){
                    last2 = last;
                    last = h;
                    cowlast2 = cowlast;
                    cowlast = "Henrietta";
                    tielast = false;
                }else if(h == last){
                    tielast = true;
                }else if(h<last2){
                    last2 = h;
                    cowlast2 = "Henrietta";
                    tielast2 = false;
                }else if(h==last2){
                    tielast2 = true;
                }

            }
            if(i == 6){
                if(m<last){
                    last2 = last;
                    last = m;
                    cowlast2 = cowlast;
                    cowlast = "Maggie";
                    tielast = false;
                }else if(m == last){
                    tielast = true;
                }else if(m<last2){
                    last2 = m;
                    cowlast = "Maggie";
                    tielast2 = false;
                }else if(m==last2){
                    tielast2 = true;
                }

            }
        }
        if(tielast2 == true || cowlast2 == ""){
            pw.println("Tie");


        }else{
            pw.println(cowlast2);
        }
        pw.close();

    }
}