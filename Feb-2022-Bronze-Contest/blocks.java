import java.util.*;
public class blocks{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int words = Integer.parseInt(s.nextLine());

        String[] block1 = s.nextLine().split("");
        String[] block2 = s.nextLine().split("");
        String[] block3 = s.nextLine().split("");
        String[] block4 = s.nextLine().split("");
        String[] words2 = new String[words];
        String[][] input = new String[4][words];
        for(int z = 0;z<4;z++){
            for(int y = 0;y<6;y++){
                if(z == 0 ){
                    input[0][y] = block1[y];

                }
                if(z == 1){
                    input[1][y] = block2[y];

                }
                if(z == 2){
                    input[2][y] = block3[y];
                }
                if(z == 3){
                    input[3][y] = block4[y];
                }
            }
        }
        for(int go = 0;go<words;go++){
            words2[go] = s.nextLine();
        }
        for(int i = 0;i<words;i++) {
            String[] word = words2[i].split("");
            if (word.length == 4) {
                boolean one2 = true;
                boolean two2 = true;
                boolean three2 = true;
                boolean four2 = true;
                boolean done = false;
                for(int one = 0; one < 6; one++) {
                    for(int two = 0; two <6; two++) {
                        for(int three = 0; three < 6; three++) {
                            for(int four = 0; four < 6; four++) {
                                for (int check = 0; check < 4; check++) {
                                    if(check == 0) {
                                        if (block1[one].equals(word[check])) {

                                            one2 = false;
                                        }
                                    }
                                    if(check < 2) {
                                        if (block2[two].equals(word[check])) {

                                            two2 = false;
                                        }
                                    }
                                    if(check < 3) {
                                        if (block3[three].equals(word[check])) {

                                            three2 = false;
                                        }
                                    }
                                    if (block4[four] .equals(word[check])) {

                                        four2 = false;
                                    }

                                }
                                if (!one2 && !two2 && !three2 && !four2) {

                                    System.out.println("YES");
                                    done = true;
                                    break;
                                }
                                one2 = true;
                                two2 = true;
                                three2 = true;
                                four2 = true;
                            }
                            if (done) {
                                break;
                            }
                        }
                        if (done) {
                            break;
                        }
                    }
                    if (done) {
                        break;
                    }
                }
                if(!done){
                    System.out.println("NO");
                }
            }if(word.length == 3){
                boolean onel = false;
                boolean twol = false;
                boolean threel = false;
                boolean done2 = false;
                for(int a = 0;a<4;a++){
                    for(int b = a+1;b<4;b++){
                        for(int c = b+1;c<4;c++){
                            for(int d = 0;d<6;d++){
                                for(int e = 0;e<6;e++){
                                    for(int f = 0;f<6;f++){
                                        for(int h = 0;h<3;h++){
                                            if(h == 0) {
                                                if (input[a][d].equals(word[h])) {
                                                    onel = true;
                                                }
                                            }
                                            if(h < 2) {
                                                if (input[b][e].equals(word[h])) {
                                                    twol = true;
                                                }
                                            }
                                             if(input[c][f].equals(word[h])){
                                                threel = true;
                                            }
                                        }
                                        if(onel && twol && threel){
                                            System.out.println("YES");
                                            done2 = true;
                                            break;
                                        }
                                        onel = false;
                                        twol = false;
                                        threel = false;
                                    }
                                    if(done2){
                                        break;
                                    }
                                }
                                if(done2){
                                    break;
                                }
                            }
                            if(done2){
                                break;
                            }
                        }
                        if(done2){
                            break;
                        }
                    }
                    if(done2){
                        break;
                    }
                }
                if(!done2){
                    System.out.println("NO");
                }

            }
            if(word.length == 2){
                boolean first = false;
                boolean second = false;
                boolean done3 = false;
                for(int al2 = 0;al2<4;al2++){
                    for(int bl2 = al2+1;bl2<4;bl2++){
                        for(int cl2 = 0;cl2<6;cl2++){
                            for(int dl2 = 0;dl2<6;dl2++){
                                for(int el2 = 0;el2<2;el2++){
                                    if(input[al2][cl2] .equals( word[el2])){
                                        first = true;
                                    }
                                    else if(input[bl2][dl2] .equals( word[el2])){
                                        second = true;
                                    }
                                }
                                if(first && second){
                                    System.out.println("YES");
                                    done3 = true;
                                    break;
                                }else{
                                    first = false;
                                    second = false;
                                }
                            }
                            if(done3){
                                break;
                            }
                        }
                        if(done3){
                            break;
                        }
                    }
                    if(done3){
                        break;
                    }
                }
                if(!done3){
                    System.out.println("NO");
                }
            }if(word.length == 1){
                boolean yes = false;
                for(int al1 = 0;al1<4;al1++){
                    for(int bl1 = 0;bl1<6;bl1++){
                        if(input[al1][bl1].equals(word[0])){
                            yes = true;
                            break;
                        }
                    }
                }
                if(yes){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }

    }
}