import java.io.*;
import java.util.*;

class houston { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("houston.txt"))) { 
            int cases = sc.nextInt();
            while (cases-- > 0) { 
                int holes = sc.nextInt();
                double x = 0, y = 0, z = 0, n = holes;
                while (holes-- > 0) { 
                    x += sc.nextDouble();
                    y += sc.nextDouble();
                    z += sc.nextDouble();
                }
                System.out.printf("%.4f%n%.4f%n%.4f%n", x/n, y/n, z/n);
            }
        }
    }
}
