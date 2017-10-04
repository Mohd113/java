import java.io.*;
import java.util.*;

class space { 
    static List<List<String>> perms = new ArrayList<List<String>>();
    static List<String> pp = new ArrayList<String>();
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(new File("space.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) { 
                int nums = sc.nextInt();
                List<String> all = new ArrayList<String>();
                while (nums-- > 0) {
                    String w = sc.next();
                    all.add(w);
                    permute("", trim(w));
                    perms.add(new ArrayList<String>(pp));
                    pp.clear();
                }
                int pairs = 0;
                for (int i = 0; i < perms.size(); i++) {
                    for (int j = i+1; j < perms.size(); j++) { 
                        for (String s : perms.get(i)) {
                            if (perms.get(j).contains(s)) {
                                pairs++;
                                break;
                            }
                        }
                    }
                }
                System.out.println(pairs);
                perms.clear();
            }
        }
    }
    public static String trim(String s) {
        if (s.substring(s.length()-1).equals("0"))
            return trim(s.substring(0, s.length()-1));
        if (s.charAt(0) == '0')
            return trim(s.substring(1));
        return s;
    }
    public static void permute(String pre, String word) { 
        if (word.isEmpty())
            pp.add(pre + word);
        else { 
            for (int i = 0; i < word.length(); i++)
                permute(pre + word.charAt(i), word.substring(0, i) + word.substring(i+1, word.length()));
        }
    }

}

