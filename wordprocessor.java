import java.util.*;
import java.io.*;
class wordprocessor{
    static Scanner s;
    static PrintWriter pw;
    public static void main(String args[]){
        try{
            s = new Scanner(new File("word.in"));
            pw = new PrintWriter(new FileWriter("word.out"));
        }catch(Exception e){

        }

        String[] firstin = s.nextLine().split(" ");
        int a = Integer.parseInt(firstin[0]);
        int wordlimit = Integer.parseInt(firstin[1]);
        String [] list = s.nextLine().split(" ");
        ArrayList<String> format = new ArrayList<String>();
        StringBuilder build = new StringBuilder();
        int lettercount = 0;
        for(int i = 0;i<list.length;i++){
            if(lettercount+list[i].length()<=wordlimit){
                if(lettercount == 0){
                    build.append(list[i]);
                }else{
                    build.append(" "+list[i]);
                }
                lettercount = lettercount + list[i].length();
            }else{
                format.add(build.toString());
                build.delete(0,build.length());
                build.append(list[i]);
                lettercount = list[i].length();
            }
            if(i+1 == list.length){
                format.add(build.toString());
            }
        }
        for(int j = 0;j<format.size();j++){
            pw.println(format.get(j));
        }
        pw.close();
    }
}