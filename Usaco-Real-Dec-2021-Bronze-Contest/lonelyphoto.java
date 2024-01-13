import java.util.*;
class lonelyphoto{
    static Scanner s;
    public static void main(String[] args){
        s = new Scanner(System.in);
        int cows = Integer.parseInt(s.nextLine());
        char[] breeds = s.nextLine().toCharArray();
        int gCounter = 0;
        int hCounter = 0;
        int firstgCounter = 0;
        int firsthCounter = 0;
        long lonCount = 0;
        StringBuilder a = new StringBuilder();
        a.append(breeds[0]);
        if(breeds[0] == 'G'){
            firstgCounter++;
        }else{
            firsthCounter++;
        }
        a.append(breeds[1]);
        if(breeds[1] == 'G'){
            firstgCounter++;
        }else{
            firsthCounter++;
        }
        a.append(breeds[2]);
        if(breeds[2] == 'G'){
            firstgCounter++;
        }else{
            firsthCounter++;
        }
        if(firstgCounter == 1 || firsthCounter == 1){
            lonCount++;
        }
        StringBuilder b = new StringBuilder(a.toString());
        gCounter = firstgCounter;
        hCounter = firsthCounter;
        for(int i = 3;i<=cows;i++){
            for(int j = 1;j<=cows-i;j++){
                if(a.charAt(0) == 'G'){
                    gCounter--;
                }else{
                    hCounter--;
                }
                a.deleteCharAt(0);
                a.append(breeds[j+i-1]);
                if(breeds[j+i-1] == 'G'){
                    gCounter++;
                }else{
                    hCounter++;
                }
                if(gCounter == 1 || hCounter == 1){
                    lonCount++;
                }
            }

            if(a.length() != cows) {
                b.append(breeds[a.length()]);
                if(breeds[a.length()] == 'G'){
                    firstgCounter++;
                }else{
                    firsthCounter++;
                }
                a = new StringBuilder(b.toString());
                if(firstgCounter == 1 || firsthCounter == 1){
                    lonCount++;
                }
                gCounter = firstgCounter;
                hCounter = firsthCounter;
            }


        }
        System.out.println(lonCount);
    }
}