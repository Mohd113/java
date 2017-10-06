import java.io.*;
import java.util.*;

class aperfect { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("aperfect.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) {
                int days = sc.nextInt();
                int start = sc.nextInt()-1;
                int fday = 1;
                String[][] m = new String[7][7];
                String[] d = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
                m[0] = d; 
                for (int i = 1; i<7; i++) { 
                    for (int j = 0; j<7; j++) { 
                        if (i == 1 && j < start)
                            m[i][j] = "*";
                        else if (fday <= days)
                            m[i][j] = Integer.toString(fday++);
                        else
                            m[i][j] = "*";
                    }
                }
                for (int i = 0; i<7; i++) {
                    if (i > 1 && m[i][0].equals("*"))
                        break;
                    for (String s : m[i]) { 
                        if (s.length() == 3)
                            System.out.print(s + " ");
                        else if (s.length() == 2)
                            System.out.print(s + "  ");
                        else
                            System.out.print(s + "   ");
                    }
                    System.out.println();
                }
            }
        }
    }
}

