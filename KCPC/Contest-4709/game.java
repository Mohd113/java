import java.io.*;
import java.util.*;

class game { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("game.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int num = sc.nextInt();
                List<Integer> pos = new ArrayList<Integer>();
                while (num-- > 0)
                    pos.add(sc.nextInt());
                Collections.sort(pos);
                int result = 0;
                for (int i = 0; i < pos.size()-1; i++) {
                    if (pos.get(i) != pos.get(i+1))
                        result += Math.pow(pos.get(i) + pos.get(i+1), 2);
                }
                if (pos.size() > 2) 
                    result += Math.pow(pos.get(0) + pos.get(pos.size()-1), 2);
                System.out.println(result);
            }
        }
    }
}

