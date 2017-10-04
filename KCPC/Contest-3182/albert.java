import java.io.*;
import java.util.*;

class albert { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("albert.txt"))) { 
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int length = sc.nextInt(), check = 0, result = 0;
                List<Integer> nums = new ArrayList<Integer>();
                while (length-- > 0)
                    nums.add(sc.nextInt());
                for (int i = 0; i < nums.size(); i++) {
                    int chk = 0;
                    int res = 0;
                    for (int j = i; j < nums.size(); j++) { 
                        int num = nums.get(j);
                        if (num >= chk && !isPrime(num)) {
                            chk = num;
                            res++;
                        }
                    }
                    if (res > result)
                        result = res;
                }

                System.out.println(result);
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n % 2 == 0)
            return n == 2;
        for (int i = 3; i*i <= n; i+=2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
