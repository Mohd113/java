import java.io.*;
import java.util.*;

class issac { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("issac.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int n = sc.nextInt();
                System.out.println((n*(n-1)*(n-2))/6);
            }
        }
    }
}

