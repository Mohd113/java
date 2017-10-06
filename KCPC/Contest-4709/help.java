import java.io.*;
import java.util.*;

class help { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("help.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int counter = 0, turn = 1, flag = 0;
                int num = sc.nextInt();
                while (num-- > 0) {
                    counter += sc.nextInt();
                    if (counter % 3 == 0) {
                        flag = 1;
                        break;
                    }
                    turn++;
                }
                
                System.out.println(flag == 0 ? "Draw" : turn % 2 == 0 ? "First" : "Second");
           }
        }
    }
}


