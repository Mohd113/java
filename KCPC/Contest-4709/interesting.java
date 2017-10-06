import java.io.*;
import java.util.*;

class interesting { 
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("interesting.txt"))) {
            int cases = sc.nextInt();
            while (cases-- > 0) { 
                int n = sc.nextInt(), m = sc.nextInt();
                String[][] tmp = new String[n][m];
                List<String> all = new ArrayList<String>();
                for (int i = 0; i < n; i++) {
                    char[] t = sc.next().toCharArray();
                    for (int j = 0; j < m; j++)
                        tmp[i][j] = String.valueOf(t[j]);
                }
                String horz = "", vert = "";
                for (int i = 0; i < n; i++) {
                    horz = "";
                    for (int j = 0; j < m; j++) {
                        if (!tmp[i][j].equals("*")) 
                            horz += tmp[i][j];
                        else {
                            if (horz.length() >= 2)
                                all.add(horz);
                            horz = "";

                        }
                    }
                    if (!all.contains(horz) && horz.length() >= 2)
                        all.add(horz);
                    
                }
                for (int i = 0; i < m; i++) {
                    vert = "";
                    for (int j = 0; j < n; j++) {
                        if (!tmp[j][i].equals("*"))
                            vert += tmp[j][i];
                        else {
                            if (vert.length() >= 2)
                                all.add(vert);
                            vert = "";
                        }
                    }
                    if (!all.contains(vert) && vert.length() >= 2)
                        all.add(vert);
                }
                Collections.sort(all);
                System.out.println(all.get(0));
            }
        }
    }
}
                 



    

