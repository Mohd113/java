import java.io.*;
import java.util.*;
import java.util.stream.*;

class largest {
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("largest.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int nums = sc.nextInt();
                List<String> all = new ArrayList<String>();
                while (nums-- > 0)
                    all.add(sc.next());
                all.sort((x1, x2) -> (int) (Long.parseLong(x2+x1) - Long.parseLong(x1+x2)));
                System.out.println(all.stream().collect(Collectors.joining()));
            }
        }
    }
}
