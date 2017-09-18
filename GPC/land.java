import java.io.*;
import java.util.*;

class land { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("land.txt"))) {
            int cases = sc.nextInt(), count = 1;
            while (cases-- > 0) {
                int num = sc.nextInt();
                long area = sc.nextLong(), price = sc.nextLong();
                long tot = price / area;
                while (num-- > 1) { 
                    long ta = sc.nextLong(), tp = sc.nextLong();
                    long ttot = tp / ta;
                    if (ttot < tot) {
                        area = ta;
                        price = tp;
                        tot = ttot;
                    }
                    else if (ttot == tot) {
                        if (tp < price) {
                            price = tp;
                            area = ta;
                        }
                    }
                }
                System.out.printf("%d. %d %d%n", count++, area, price);
            }
        }
    }
}
