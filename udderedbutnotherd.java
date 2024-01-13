import java.util.Scanner;
class udderedbutnotherd{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        char[] alphabet = scan.next().toCharArray();
        char[] heard = scan.next().toCharArray();
        int i = 0;
        int j = 0;
        int counter = 1;
        while(true){
            if(alphabet[i] == heard[j]) {
                j++;

            }
            i++;
            if(i == alphabet.length){
                i = 0;
                counter++;
            }
            if(j == heard.length){
                break;
            }


        }
        System.out.println(counter);
    }
}