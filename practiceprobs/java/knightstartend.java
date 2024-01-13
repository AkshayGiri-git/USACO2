class knightstartend{
    int best = Integer.MAX_VALUE;
    public static void main(String[] args){
        knightstartend k = new knightstartend();
        System.out.println(k.solution(0,63));
    }
    public int solution(int src, int dest) {
        boolean[] visited = new boolean[64];
        int i1 = src/8;
        int i2 = src%8;
        int j1 = dest/8;
        int j2 = dest%8;
        recursion(i1,i2,j1,j2,visited,0);
        return best;
    }
    public void recursion(int i1,int i2,int j1, int j2,boolean[] visited,int moves){
        if(i1 == j1 && i2 == j2){
            if(moves<best){
                best = moves;
            }
        }
        if(moves == 6){
            return;
        }
        visited[i1 * 8 + i2] = true;
        boolean[] visited2 = (boolean[]) visited.clone();
        if(i1+2<8 && i2+1<8){
            recursion(i1+2,i2+1,j1,j2,visited2,moves+1);
        }
        if(i1+2<8 && i2-1>-1){
            recursion(i1+2,i2-1,j1,j2,visited2,moves+1);
        }
        if(i1+1<8 && i2+2<8){
            recursion(i1+1,i2+2,j1,j2,visited2,moves+1);
        }
        if(i1+1<8 && i2-2>-1){
            recursion(i1+1,i2-2,j1,j2,visited2,moves+1);
        }if(i1-1>-1 && i2+2<8){
            recursion(i1-1,i2+2,j1,j2,visited2,moves+1);
        }if(i1-1>-1 && i2-2>-1){
            recursion(i1-1,i2-2,j1,j2,visited2,moves+1);
        }if(i1-2>-1 && i2+1<8){
            recursion(i1-2,i2+1,j1,j2,visited2,moves+1);
        }if(i1-2>-1 && i2-1>-1){
            recursion(i1-2,i2-1,j1,j2,visited2,moves+1);
        }
        return;
    }
}