import java.util.Arrays;
class Solution2 {
    public static String solution(int[] xs) {
        Solution2 sol = new Solution2();
        String ans = "0";
        String ans2 = "1";
        int negative = 0;
        Arrays.sort(xs);
        for(int i = 0;i<xs.length;i++){
            if(xs[i]<0){
                if(negative<0){
                    ans2 = sol.multiply(ans2,String.valueOf(negative*-1));
                    ans2 = sol.multiply(ans2,String.valueOf(xs[i]*-1));
                    ans = ans2;
                    negative = 0;
                }else{
                    negative = xs[i];
                }
            }
            if(xs[i]>0){
                ans2 = sol.multiply(ans2,String.valueOf(xs[i]));
                ans = ans2;
            }
        }
        return ans;
    }
    public String multiply (String x, String y){

        int carryover = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= x.length() + y.length()-2 || carryover != 0; i++) {
            for (int j = Math.max(0, i - (y.length()-1));j <= Math.min(i, x.length()-1); j++) {
                carryover += Character.getNumericValue(x.charAt((x.length()-1) - j))* Character.getNumericValue(y.charAt((y.length()-1) - i + j));
            }
            ans.insert(0,(char)(carryover % 10 + '0'));
            carryover /= 10;
        }
        return ans.toString();
    }
    public static void main(String[] args){
        int[] input = {0,1};
        Solution2 main = new Solution2();
        System.out.println(main.solution(input));
    }
}