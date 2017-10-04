import java.io.*;
import java.util.*;

class kepler { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("kepler.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) { 
                String word1 = sc.next(), word2 = sc.next();
                int shortest = Math.min(word1.length(), word2.length());
                System.out.println(sub(word1, word2) == shortest ? "YES" : "NO");
            }
        }
    }
    public static int sub(String w1, String w2) {
        int[][] d = new int[w1.length()+1][w2.length()+1];
        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();
        for (int i = 0; i <= w1.length(); i++) {
            for (int j = 0; j <= w2.length(); j++) {
                if (i == 0 || j == 0)
                    d[i][j] = 0;
                else { 
                    if (c1[i-1] == c2[j-1]) {
                        d[i][j] = d[i-1][j-1]+1;
                    }
                    else
                        d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }
        return d[w1.length()][w2.length()];
    }
}
