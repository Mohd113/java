import java.io.*;
import java.util.*;

class cute { 
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(new File("cute.txt"))) {
            int cases = sc.nextInt();
            List<String> vowels = Arrays.asList("a", "o", "i", "e", "u");
            while (cases-- > 0) 
                System.out.println(vowels.contains(sc.next().toLowerCase()) ? "Vowel" : "Consonant");
        }
    }
}

