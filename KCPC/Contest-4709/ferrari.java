import java.io.*;
import java.util.*;

class ferrari {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(new File("ferrari.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0)
                System.out.println(sc.nextLong() * 746);
        }
    }}

