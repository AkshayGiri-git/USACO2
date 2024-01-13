import java.util.*;
class acowademia1{
    public void read(){
        Scanner input = new Scanner(System.in);
        String[] a = input.nextLine().split(" ");

        int L = Integer.parseInt(a[1]);
        String[] b = input.nextLine().split(" ");
        this.solve(L,b);
    }
    public void solve(int L,String[] b){
        int count =0;
        int i = 1;
        int a = 0;
        int count2 = 0;
        while(true){
            for(int j =0;j<b.length;j++){
                if(Integer.parseInt(b[j]) >= i){
                    count++;
                }
            }
            if(count >= i){
                i++;
                count = 0;
            }else{
                i = i-1;
                break;
            }
        }

        if(L == 0){
            System.out.println(i);
            return;
        }
        while(a<b.length){
            if(Integer.parseInt(b[a]) == i){

                if(count+1 >= i+1){
                    i++;
                    break;
                }else{
                    count2++;
                    count++;
                    if(count2 == L){
                        break;
                    }
                }

            }
            a++;
        }
        System.out.println(i);
        return;
    }
    public static void main(String[] args){
        acowademia1 acowademia1 = new acowademia1();
        acowademia1.read();
    }
}