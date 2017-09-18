import java.io.*;
import java.util.*;

public class delivery {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(new File("delivery.txt"))) {
            int cases = sc.nextInt(), count = 1;
            while (cases-- > 0) {
                int num = sc.nextInt(), result = 0;
                while (num-- > 0)
                    result += sc.nextInt() * 2;
                System.out.printf("%d. %d%n", count++, result);
            }
        }
    }
}
