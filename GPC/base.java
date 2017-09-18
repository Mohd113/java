import java.io.*;
import java.util.*;

class baseP {
    double x, y;

    public baseP(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class base { 
    
    public static void main(String[] args) throws Exception { 
        try (Scanner sc = new Scanner(new File("base.txt"))) {
            int cases = sc.nextInt(), count = 1;
            while (cases-- > 0) {
                int points = sc.nextInt();
                List<baseP> all = new ArrayList<baseP>();
                while (points-- > 0) 
                    all.add(new baseP(sc.nextDouble(), sc.nextDouble()));
                List<Double> dist = new ArrayList<Double>();
                for (baseP b : all) {
                    double d = 0;
                    for (baseP b1 : all) 
                        d += Math.sqrt(Math.pow(b.x - b1.x, 2) + Math.pow(b.y - b1.y, 2));
                    dist.add(d);
                }
                Collections.sort(dist);
                System.out.printf("%d. %.2f%n", count++, dist.get(0));
            }
        }
    }
}
