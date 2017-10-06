import java.io.*;
import java.util.*;

class jewelry { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("jewelry.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int pieces = sc.nextInt(), days = sc.nextInt();
                List<Integer> p = new ArrayList<Integer>(), d = new ArrayList<Integer>();
                while (pieces-- > 0)
                    p.add(sc.nextInt());
                while (days-- > 0)
                    d.add(sc.nextInt());
                Collections.sort(p, Collections.reverseOrder());
                Collections.sort(d, Collections.reverseOrder());
                int result = 0;
                try { 
                    for (int i = 0; i < d.size(); i++)
                        result += d.get(i) * p.get(i);
                }
                catch (Exception e) {
                    continue;
                }
                System.out.println(result);
            }
        }
    }
}

