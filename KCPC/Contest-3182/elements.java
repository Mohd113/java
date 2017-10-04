import java.io.*;
import java.util.*;

class elements { 
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(new File("elements.txt"))) { 
            int cases = sc.nextInt();
            while (cases-- > 0) {
                char[] str = sc.next().toCharArray();
                int queries = sc.nextInt();
                while (queries-- > 0) { 
                    int op = sc.nextInt();
                    if (op == 0) { 
                        int pos = sc.nextInt();
                        str[pos-1] = sc.next().charAt(0);
                    }
                    else if (op == 1) { 
                        int pos1 = sc.nextInt();
                        int pos2 = sc.nextInt();
                        int result = 1;
                        for (int i = pos1-1; i<pos2;i++) { 
                            int tm = 1;
                            for (int j = i+1; j < pos2; j++) {
                                if (str[i] == str[j])
                                    tm++;
                                else
                                    break;
                            }
                            if (tm > result)
                                result = tm;
                        }
                        System.out.println(result);
                    }
                }
            }
        }
    }
}





