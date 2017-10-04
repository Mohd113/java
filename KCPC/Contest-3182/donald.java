import java.io.*;
import java.util.*;

class donald { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("donald.txt"))) { 
            int cases = sc.nextInt();
            List<Integer> odds = new ArrayList<Integer>();
            List<Integer> evens = new ArrayList<Integer>();
            while (cases-- > 0) { 
                int nums = sc.nextInt();
                while (nums-- > 0) { 
                    int tmp = sc.nextInt();
                    if (tmp % 2 == 0)
                        evens.add(tmp);
                    else
                        odds.add(tmp);
                }
                Collections.sort(odds);
                Collections.sort(evens);
                for (Integer n : odds)
                    System.out.printf("%d ", n);
                for (Integer c : evens)
                    System.out.printf("%d ", c);
                System.out.println();
            }
        }
    }
}

