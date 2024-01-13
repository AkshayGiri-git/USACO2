import java.util.*;
import java.io.*;
class teamtictactoe{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner( new File("tttt.in"));
            pw = new PrintWriter( new FileWriter("tttt.out"));
        }catch(Exception e){

        }
        char[][] input = new char[3][3];
        for(int i = 0;i<3;i++){

            String[] line = s.nextLine().split("");
            for(int j = 0;j<3;j++){
                 input[i][j] = line[j].charAt(0);
            }
        }
        char check1 = ' ';
        char check2 = ' ';
        boolean team = false;
        boolean duplicatetrue1 = false;
        boolean duplicatetrue2 = false;
        ArrayList<Character> duplicate1 = new ArrayList<Character>();
        ArrayList<String> duplicate2 = new ArrayList<String>();
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        int o = 0;
        for( k = 0;k<3;k++){
            for( l = 0;l<3;l++){
                if(l == 0){
                    check1 = input[k][l];
                }else if(l == 1){
                    if(input[k][l] == check1) {
                        team = true;
                        check2 = input[k][l];
                    }
                }else{
                    if(team == true){
                        if(check2 == input[k][l]){
                            for( m = 0;m<duplicate1.size();m++) {
                                if(duplicate1.get(m) == check2){
                                    duplicatetrue1 = true;
                                }
                            }
                            if(duplicatetrue1 == false){
                                duplicate1.add(check2);

                            }
                            duplicatetrue1 = false;
                        }else{
                            for(n = 0;n<duplicate2.size();n++){
                                if(duplicate2.get(n).equals( check2+" "+input[k][l]) || duplicate2.get(n).equals( input[l][k]+" "+check2)){
                                    duplicatetrue2 = true;
                                }
                            }
                            if(duplicatetrue2 == false){
                                duplicate2.add(String.valueOf(check2)+" "+String.valueOf(input[k][l]));


                            }
                            duplicatetrue2 = false;
                        }
                    }else{
                        if(input[k][l] == check1 || input[k][l] == check2){
                            for( o = 0;o<duplicate2.size();o++){
                                if(duplicate2.get(o).equals( check1+" "+check2)|| duplicate2.get(o).equals( check2+" "+check1)){
                                    duplicatetrue2 = true;
                                }
                            }
                            if(duplicatetrue2 == false){
                                duplicate2.add(String.valueOf(check1)+" "+String.valueOf(check2));

                            }
                            duplicatetrue2 = false;
                        }
                    }
                }
            }
            team = false;
        }
        k = 0;
        l = 0;
        m = 0;
        n = 0;
        o = 0;
        for( k = 0;k<3;k++){
            for( l = 0;l<3;l++){
                if(l == 0){
                    check1 = input[l][k];
                }else if(l == 1){
                    if(input[l][k] == check1) {
                        team = true;
                        check2 = input[l][k];
                    }
                }else{
                    if(team == true){
                        if(check2 == input[l][k]){
                            for(m = 0;m<duplicate1.size();m++) {
                                if(duplicate1.get(m) == check2){
                                    duplicatetrue1 = true;
                                }
                            }
                            if(duplicatetrue1 == false){
                                duplicate1.add(check2);

                            }
                            duplicatetrue1 = false;
                        }else{
                            for( n = 0;n<duplicate2.size();n++){
                                if(duplicate2.get(n).equals( check2+" "+input[l][k])|| duplicate2.get(n).equals( input[l][k]+" "+check2)){
                                    duplicatetrue2 = true;
                                }
                            }
                            if(duplicatetrue2 == false){
                                duplicate2.add(String.valueOf(check2)+" "+String.valueOf(input[l][k]));

                                System.out.println(k);
                            }
                            duplicatetrue2 = false;
                        }
                    }else{
                        if(input[l][k] == check1 || input[l][k] == check2){
                            for( o = 0;o<duplicate2.size();o++){
                                if(duplicate2.get(o).equals( check1+" "+check2)|| duplicate2.get(o).equals( check2+" "+check1)){
                                    duplicatetrue2 = true;
                                }
                            }
                            if(duplicatetrue2 == false){
                                duplicate2.add(String.valueOf(check1)+" "+String.valueOf(check2));

                            }
                            duplicatetrue2 = false;
                        }
                    }
                }
            }
            team = false;
        }
        if(input[0][2] == input[1][1] && input[2][0] == input[2][2]){
            for(m = 0;m<duplicate1.size();m++) {
                if(duplicate1.get(m) == check2){
                    duplicatetrue1 = true;
                }
            }
            if(duplicatetrue1 == false){
                duplicate1.add(check2);

            }
            duplicatetrue1 = false;
        }else if(input[0][2] == input[1][1]){
            for( n = 0;n<duplicate2.size();n++){
                if(duplicate2.get(n).equals( check2+" "+input[l][k])|| duplicate2.get(n).equals( input[l][k]+" "+check2)){
                    duplicatetrue2 = true;
                }
            }
            if(duplicatetrue2 == false){
                duplicate2.add(String.valueOf(check2)+" "+String.valueOf(input[l][k]));

                System.out.println(k);
            }
            duplicatetrue2 = false;

        }else if(input[2][0] == input[1][1] || input[0][2] == input[0][0]) {
            for (o = 0; o < duplicate2.size(); o++) {
                if (duplicate2.get(o).equals(check1 + " " + check2) || duplicate2.get(o).equals(check2 + " " + check1)) {
                    duplicatetrue2 = true;
                }
            }
            if (duplicatetrue2 == false) {
                duplicate2.add(String.valueOf(check1) + " " + String.valueOf(check2));

            }
            duplicatetrue2 = false;
        }
        if(input[0][0] == input[1][1] && input[1][1] == input[2][2]){
            for(m = 0;m<duplicate1.size();m++) {
                if(duplicate1.get(m) == check2){
                    duplicatetrue1 = true;
                }
            }
            if(duplicatetrue1 == false){
                duplicate1.add(check2);

            }
            duplicatetrue1 = false;
        }else if(input[0][0] == input[1][1]){
        for( n = 0;n<duplicate2.size();n++){
            if(duplicate2.get(n).equals( check2+" "+input[l][k])|| duplicate2.get(n).equals( input[l][k]+" "+check2)){
                duplicatetrue2 = true;
            }
        }
        if(duplicatetrue2 == false){
            duplicate2.add(String.valueOf(check2)+" "+String.valueOf(input[l][k]));

            System.out.println(k);
        }
        duplicatetrue2 = false;
        }else if(input[2][2] == input[1][1] || input[2][2] == input[0][0]){
        for( o = 0;o<duplicate2.size();o++){
            if(duplicate2.get(o).equals( check1+" "+check2)|| duplicate2.get(o).equals( check2+" "+check1)){
                duplicatetrue2 = true;
            }
        }
        if(duplicatetrue2 == false){
            duplicate2.add(String.valueOf(check1)+" "+String.valueOf(check2));

        }
        duplicatetrue2 = false;
        }
        pw.println(duplicate1.size());
        pw.println(duplicate2.size());
        pw.close();
    }
}