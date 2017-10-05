import java.io.*;
import java.util.*;

class die { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("die.txt"))) { 
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int pos = sc.nextInt()-1;
                int[][] road = new int[10][4];
                int chk = 1;
                for (int i = 0; i < 10; i++) {
                    char[] tmp = sc.next().toCharArray();
                    for (int j = 0; j < 4; j++) 
                        road[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
                }
                int pos2 = 0;
                int secs = 1;
                while (pos2 < 3) {
                    if (road[pos-1][pos2+1] == 1 && road[pos-1][pos2] == 1)
                        break;
                    else if (road[pos-1][pos2+1] == 0) {
                        pos2++;
                        
                    }
                    secs++;

                }
                System.out.println(pos2 == 3 ? secs : "-1");
            }
        }
    }
}
                        

                        
                    
