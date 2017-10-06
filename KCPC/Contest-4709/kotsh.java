import java.io.*;
import java.util.*;

class kotsh { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("kotsh.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int n = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt();
                int[][] grid = new int[n][n];
                while (r-- > 0) {
                    int tmp = sc.nextInt()-1;
                    for (int i = 0; i < n; i++)
                        grid[tmp][i] = 1;
                }
                while (c-- > 0) {
                    int tmp = sc.nextInt()-1;
                    for (int i = 0; i < n; i++)
                        grid[i][tmp] = 1;
                }
                int result = 0;
                for (int[] k : grid) {
                    for (int d : k) {
                        if (d != 1)
                            result++;
                    }
                }
                System.out.println(result);
            }
        }
    }
}
