import java.util.*;
class clockwisefence{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        int degrees = 0;
        String[] input = new String[num];
        for(int j = 0;j<num;j++){
            input[j] = s.nextLine();
        }
        String nextnum;
        for(int i = 0;i<num;i++){
            String[] line = input[i].split("");
            for(int j = 0;j<line.length;j++){
                if(j!= line.length-1){
                    nextnum = line[j+1];
                }else{
                    nextnum = line[0];
                }

                if(line[j].equals("N") && nextnum.equals("E")){
                    degrees += 90;
                }
                if(line[j].equals("E") && nextnum.equals("S")){
                    degrees += 90;
                }
                if(line[j].equals("S") && nextnum.equals("W")){
                    degrees += 90;
                }
                if(line[j].equals("W") && nextnum.equals("N")){
                    degrees += 90;
                }
                if(line[j].equals("E") && nextnum.equals("N")){
                    degrees -= 90;
                }
                if(line[j].equals("N") && nextnum.equals("W")){
                    degrees -= 90;
                }
                if(line[j].equals("W") && nextnum.equals("S")){
                    degrees -= 90;
                }
                if(line[j].equals("S") && nextnum.equals("E")){
                    degrees -= 90;
                }

            }
            if(degrees == 360){
                System.out.println("CW");
            }else{
                System.out.println("CCW");
            }
            degrees = 0;
        }

    }
}