import java.io.*;
import java.util.*;

class best { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("best.txt"))) { 
            int cases = sc.nextInt();
            while (cases-- > 0) { 
                long l = sc.nextLong();
                long r = sc.nextLong();
                int sum = 0;
                for (long i = l; i <= r; i++) {
                    for (long j = l; j<=i/2; j++) 
                        sum += isPower(j, i);
                }
                System.out.println(sum);
            }
        }
    }
    public static int isPower(long x, long y) { 
        long pow = 1;
        int res = 0;
        while (pow < y) { 
            pow *= x;
            res++;
        }
        if (pow == y)
            return res;
        return 0;
    }
}
