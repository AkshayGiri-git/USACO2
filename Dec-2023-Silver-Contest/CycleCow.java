import java.util.HashMap;
import java.util.Scanner;

public class CycleCow {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] bessieConnections = new int[k];
        int[] forward = new int[n+1];
        int[] backward = new int[n+1];
        HashMap<Integer, Integer> cowStatus = new HashMap<>();
        for(int i = 1; i < n+1; i++) {
            cowStatus.put(i,0);
        }
        for(int i = 0; i < k; i++) {
            bessieConnections[i] = scanner.nextInt();
        }
        for(int i = 0; i < k-1; i++) {
            forward[bessieConnections[i]] = bessieConnections[i+1];
        }
        forward[bessieConnections[k-1]] = bessieConnections[0];
        for(int i = 1; i < k; i++) {
            backward[bessieConnections[i]] = bessieConnections[i-1];
        }
        backward[bessieConnections[0]] = bessieConnections[k-1];
        int[] otherConnections = new int[k];
        for(int i = 0; i < k; i++) {
            otherConnections[i] = scanner.nextInt();
        }

        for(int i = 0; i < k-1; i++) {
            doConnection(otherConnections[i], otherConnections[i+1], forward, backward, cowStatus);
        }

        doConnection(otherConnections[k-1], otherConnections[0], forward, backward, cowStatus);
        int ans = n;
        for(int i = 1 ; i < n+1; i++) {
            if(cowStatus.get(i) == -1) {
                ans-=2;
            }
        }
        System.out.println(ans);
    }
    public void doConnection(int a, int b, int[] forward, int[] backward, HashMap<Integer, Integer> cowStatus) {
        if(forward[a] == b || backward[a] == b) {
            cowStatus.put(a, 1);
            cowStatus.put(b, 1);
        } else {
            if(cowStatus.get(a) != 1) {
                cowStatus.put(a, -1);
            }
            if(cowStatus.get(b) != 1) {
                cowStatus.put(b, -1);
            }
        }
    }
    public static void main(String[] args) {
        CycleCow cycleCow =  new CycleCow();
        cycleCow.read();
    }
}