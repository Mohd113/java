import java.io.*;
import java.util.*;

class sailor { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("sailor.txt"))) {
            int cases = sc.nextInt(), count = 1;
            while (cases-- > 0) {
                int len = sc.nextInt(), pos = sc.nextInt(), steps = sc.nextInt(), failcheck = 0;
                while (steps-- > 0) {
                    int s = sc.nextInt();
                    String dir = sc.next();
                    if (dir.equals("R")) { 
                        pos += s;
                        if (pos > len)  
                            failcheck = 1;
                    }
                    else if (dir.equals("L")) {
                        pos -= s;
                        if (pos < 0)
                            failcheck = 1;
                    }
                }
                System.out.printf("%d. %s%n", count++, (failcheck == 0 ? Integer.toString(pos) : "Sailor Fails!"));
            }
        }
    }
}
