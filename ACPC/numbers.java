import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class numbers {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("numbers.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			int count = 1;
			while (fline-- > 0) {
				System.out.println("Case " + count++ + ": " + check(sc.nextLine()));
			}
		}
		
	}
	public static String check(String data) {
		try (Scanner sc1 = new Scanner(data)) {
			BigInteger x = sc1.nextBigInteger();
			BigInteger y = BigInteger.ZERO;
			BigInteger n = sc1.nextBigInteger();
			BigInteger b = sc1.nextBigInteger();
			BigInteger m = sc1.nextBigInteger();
			BigInteger d = BigInteger.ZERO;
			if (m.equals(BigInteger.ZERO) && n.equals(BigInteger.ZERO)) {
				x = x.add(b);
			}
			
			for (BigInteger i = BigInteger.ZERO; i.compareTo(m) == -1; i = i.add(BigInteger.ONE)) {
				if (i.equals(n)) {
					if (x.compareTo(y) == 1) {
						x = x.add(b);
					}
					else { 
						y = y.add(b);
					}
				}
				else { 
					if (x.compareTo(y) == 1) {
						y = y.add(x);
					}
					else { 
						x = x.add(y);
					}
				}
			}
			if (!y.equals(BigInteger.ZERO) && !x.equals(BigInteger.ZERO)) {
				d = x.gcd(y);
			}
			else if (y.equals(BigInteger.ZERO)) {
				
				d = x;
			}
			else if (x.equals(BigInteger.ZERO)) {
				d = y;
			}
			return d.toString();
		}
	}

}
