import java.util.*;
import java.io.*;
public class cardselection{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        String[] fline = s.nextLine().split(" ");
        int nofcards = Integer.parseInt(fline[0]);
        int T = Integer.parseInt(fline[1]);
        int[] cards = new int[nofcards];
        for(int i = 0;i<nofcards;i++){
            cards[i] = Integer.parseInt(s.nextLine());
        }
        for(int j = 0;j<T;j++){
            int best = 0;
            int bestpos = 0;
            for(int k = 0;k<cards.length;k++){
                if(cards[k] > best){
                    best = cards[k];
                    bestpos = k;
                }
            }
            System.out.println(bestpos+1);
            cards[bestpos] = 0;
            int add = best/(nofcards-1);
            int remainder = best % (nofcards-1);
            for(int l = 0;l<cards.length;l++){
                if(l == bestpos){
                    continue;
                }
                if(remainder > 0){
                    cards[l] += add+1;
                }else{
                    cards[l] += add;
                }
            }

        }
    }
}