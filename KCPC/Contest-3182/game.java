import java.io.*;
import java.util.*;

class game { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("game.txt"))) { 
            int cases = sc.nextInt();
            while (cases-- > 0) { 
                int x = sc.nextInt(), k = sc.nextInt();
                int num = 0;
                while (k > 0) {
                    x++;
                    char[] tmp = Integer.toString(x).toCharArray();
                    int sum = 0;
                    for (char c : tmp)
                        sum += Integer.parseInt(String.valueOf(c));
                    if (sum == 9) {
                        num = x;
                        k--;
                    }
                }
                System.out.println(num);
            }
        }
    }}

