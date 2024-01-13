import java.util.*;
import java.io.*;
public class modernart {
    static Scanner s;
    static PrintWriter pw;

    public static void main(String[] args){
        try {
            s = new Scanner(new File("art.in"));
            pw = new PrintWriter(new FileWriter("art.out"));
        }catch(Exception e) {
        }
        int num = Integer.parseInt(s.nextLine());
        int[][] input = new int[num][num];

        for(int a = 0;a<input.length;a++){
            String[] line = s.nextLine().split("");
            for(int b = 0;b<line.length;b++){
                input[a][b] = Integer.parseInt(line[b]);
            }
        }
        int[] rectangles = new int[36];// rectangle of upper left corner and bottom right corner- 4 integers
        int maxhigh = -1;
        int minhigh = -1;
        int maxright = -1;
        int minright = -1;
        boolean firstnum = false;
        for(int i = 1;i<10;i++){
            for(int j = 0;j<input.length;j++){
                for(int k = 0;k<input.length;k++){
                    if(input[j][k] == i){
                        if(j<minhigh || minhigh == -1){
                            minhigh = j;
                        }
                        if(j>maxhigh){
                            maxhigh = j;
                        }
                        if(k < minright|| minright == -1){
                            minright = k;
                        }
                        if(k > maxright){
                           maxright = k;
                        }
                    }
                }
            }
            rectangles[((i-1)*4)] = minhigh;
            rectangles[((i-1)*4)+1] = minright;
            rectangles[((i-1)*4)+2] = maxhigh;
            rectangles[((i-1)*4)+3] = maxright;
            maxhigh = -1;
            minhigh = -1;
            maxright = -1;
            minright = -1;
        }
        boolean[] options = new boolean[9];// represents options for first paint
        // we can rule out options that are over another color.
        for(int z = 0;z<9;z++){
            options[z] = true;
        }
        for(int l = 0;l<36;l+=4){
            if(rectangles[l]!=-1){
                for(int m = rectangles[l];m<=rectangles[l+2];m++){
                    for(int n = rectangles[l+1];n<=rectangles[l+3];n++) {
                        if(input[m][n] != (l/4)+1){
                            options [input[m][n]-1] = false;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int o = 0;o<options.length;o++){
            if(options[o]){
                if(rectangles[o*4]!= -1) {
                    ans++;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
