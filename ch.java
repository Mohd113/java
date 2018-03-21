import java.io.*;
import java.util.*;

class pair implements Comparable<pair> {
	int to, dis;
	public pair(int to, int dis) {
		this.to = to;
		this.dis = dis;
	}
	@Override
	public int compareTo(pair p) {
		return this.dis-p.dis;
	}
}
public class Graph {
	private LinkedList<Integer> adj [];
	private LinkedList<pair> adjP [];
	private int n, e;
	private boolean[] vis;
	private int[] vis2;
	private int[] color;
	private int[] dis;
	
	public Graph(int n, int e) {
		this.n = n;
		this.e = e;
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
		adjP = new LinkedList[n];
		for (int i = 0; i < n; i++)
			adjP[i] = new LinkedList<>();
		vis = new boolean[n];
		dis = new int[n];
		color = new int[n];
		vis2 = new int[n];
	}
	
	
	public boolean isCyclicDirected(int p) {
		vis2[p] = 2;
		for (Integer ch : adj[p]) {
			if (vis2[ch] == 2)
				return true;
			else if (vis2[ch] == 1)
				continue;
			else 
				if (isCyclicDirected(ch))
					return true;
		
		vis2[p] = 1;
		}
		return false;
	}
	
	public boolean isCyclicUndirected(int i, int p) {
		if ()
	}
	
	
	public boolean isBiPartite(int src) {
		Arrays.fill(color, -1);
		Queue<Integer> q = new LinkedList<>();
		color[src] = 0;
		q.add(src);
		while (!q.isEmpty()) {
			int p = q.poll();
			Iterator<Integer> it = adj[p].iterator();
			while (it.hasNext()){
				int ch = it.next();
				if (color[ch] == color[p])
					return false;
				else if (color[ch] != -1)
					continue;
				else
					color[ch] = color[p]^1;
				q.add(ch);	
			}
		}
		return true;
	}
	static int count = 0;
	public int countDepth(int src, int last) {
		if (adj[src].isEmpty()) 
			count = last; 
		else { 
			for (Integer d : adj[src]) { 
				countDepth(d, last+1); 
			} 
		}
	}		
	public void DFS(int i) {
		if (!vis[i]) {
			vis[i] = true;
			for (Integer ch : adj[i])
				DFS(ch);
		}
	}
	
	public int countConnected(int p) {
		Arrays.fill(vis,  false);
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				DFS(i);
				count++;
			}
		}
		return count;
			
	}
	
	public void dfs2(int i, int j) { 
		if (!vis[i][j]) { 
			vis[i][j] = true; 
			for (int k = 0; k < 8; k++) { 
				int i2 = i+dx[k]; 
				int j2 = j+dy[k]; 
				if (isValid(i2, j2) && grid[i2][j2] == '1') 
					dfs(i2, j2); 
				} 
			} 
		}
	
	
	public void Topological(int i) {
		vis[i] = true;
		for (Integer ch : adj[i])
			if (!vis[ch])
				Topological(ch);
		System.out.printf("%d ", i);
	}
	
	public void BFS(int src) {
		Arrays.fill(dis,  -1);
		Queue<Integer> q = new LinkedList<>();
		dis[src] = 0;
		q.add(src);
		while (!q.isEmpty()) {
			int p = q.poll();
			Iterator<Integer> it = adj[p].listIterator();
			while(it.hasNext()) {
				int ch = it.next();
				if (dis[ch] == -1) {
					dis[ch] = dis[p]+1;
					q.add(ch);
				}
			}
		}
	}
	public int TreeDiameter() {
		BFS(0);
		int max = 0, idx=0;
		for (int i = 0; i < n; i++) {
			if (dis[i] > max) {
				max = dis[i];
				idx =i;
			}
		}
		BFS(idx);
		Arrays.sort(dis);
		return dis[dis.length-1];
	}
	
	public boolean allVisited() {
		for (int i = 0; i < n; i++)
			if (!vis[i])
				return false;
		return true;
	}
	
	public void Dijkstra(int src) {
		Set<pair> q = new TreeSet<pair>();
		q.add(new pair(src, 0));
		dis[src] = 0;
		while (!q.isEmpty()) {
			Iterator<pair> it = q.iterator();
			pair p = it.next();
			q.remove(p);
			if (p.dis > dis[p.to])
				continue;
			for (pair ch : adjP[p.to]) {
				if (dis[ch.to] > p.dis + ch.dis) {
					dis[ch.to] = p.dis+ ch.dis;
					q.add(new pair(ch.to, dis[ch.to]));
				}
			}
		}
	}
	
	
	public static int fastPower(int b, int p) { 
		if (p == 0) return 1;
		int ret = fastPower(b, p/2);
		return ((p&1) == 1 ? ret*ret*b : ret*ret);
	}
	
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}
	
	public static int lcm(int a, int b) {
		return (a*b) / gcd(a, b);
	}
	
	static List<pair> factors = new ArrayList<>();
	public static void factorize(long n){
		for(long i = 2 ; i*i <= n ; ++i){
			int power = 0;
			while(n%i==0) {
				n/=i;
		        ++power;
			}
			if(power > 0) 
				factors.add(new pair(i, power));
		}
		if(n > 1) 
			factors.add(new pair(n, 1));
	}
	
	static int[] isComposite = new int[n];
	public static void sieve(int n) {
		isComposite[0] = isComposite[1] = 1;
		for (int i = 2 ; i*i <= n ; ++i) {     
			if (isComposite[i] == 0) {
				for (int j = i*i ; j <= n ; j+=i)
					isComposite[j] = 1;  
		    }
		}
	}
	
	static int[] numberOfDivisors = new int[n];
	public static void countDivisors(int n) {
		numberOfDivisors[0] = numberOfDivisors[1] = 1;
		for(int i = 2 ; i*i <= n ; ++i){
			if(numberOfDivisors[i] == 0) {
				for(int j = i ; j < n ; j+=i) {
					int e = 0;
					int q = j;
					while(q%i==0){
						++e;
						q/=i;
					}
					if (numberOfDivisors[j] != 0)
						numberOfDivisors[j]*=(e+1);
					else  
						numberOfDivisors[j] = e+1;
				}
			}
		}
	}
	
	static int[] greatestPF = new int[n];
	public static void greatestPrimeFators(int n) {
		greatestPF[0] = greatestPF[1] = 1;
		for (int i = 2 ; i*i <= n ; ++i)
			if (greatestPF[i] == 0) 
				for (int j = i ; j < n ; j+=i)
					greatestPF[j] = i;  
	}
	// print greatestPF[x] then x /= greatestOF[x]; till x is 1
	
	msk |= (1<<k); // change bit at k to 1
	msk |= ((1<<n)-1); // change first n bits to 1 
	msk ^= (1<<k); // toggle state of bit k
	msk &= ~(1<<k); // change bit at k to 0
	rightONE = (msk&(-msk)); // most right one bit
	
	
	List<Map.Entry<Character, Integer>> li = new LinkedList<>(map.entrySet());
	Collections.sort(li, (o1, o2) -> { 
		if (o1.getValue() == o2.getValue()) 
			return o1.getKey().compareTo(o2.getKey()); 
		return o2.getValue().compareTo(o1.getValue()); 
		}); 
	Map<Character, Integer> m2 = new LinkedHashMap<>(); 
	for (Map.Entry<Character, Integer> en : li) 
		m2.put(en.getKey(), en.getValue());
	
	
	static void get(int i, int rem) { 
		if (i == n || rem <= 0) 
			return; 
		if (dp[i][rem] == dp[i+1][rem]) 
			get(i+1, rem); 
		else if (dp[i][rem] == dp[i+1][rem-w[i]] + v[i]){ 
			vs.add(v[i]); 
			ws.add(w2[i]); 
			get(i+1, rem-w[i]); 
			} 
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
class Reader { 
	final private int BUFFER_SIZE = 1 << 16; 
	private DataInputStream din; 
	private byte[] buffer; 
	private int bufferPointer, bytesRead; 
	public Reader(){ 
		din=new DataInputStream(System.in); 
		buffer=new byte[BUFFER_SIZE]; bufferPointer=bytesRead=0; 
	} 
	public Reader(String file_name) throws IOException{ 
		din=new DataInputStream(new FileInputStream(file_name)); 
		buffer=new byte[BUFFER_SIZE]; 
		bufferPointer=bytesRead=0; 
		} 
	public String readLine() throws IOException{ 
		byte[] buf=new byte[64]; // line length 
		int cnt=0,c; 
		while((c=read())!=-1){ 
			if(c=='\n')
				break; 
			buf[cnt++]=(byte)c; 
		} 
		return new String(buf,0,cnt); 
	} 
	public int nextInt() throws IOException{ 
		int ret=0;
		byte c=read(); 
		while(c<=' ')
			c=read(); 
		boolean neg=(c=='-'); 
		if(neg)
			c=read(); 
		do{
			ret=ret*10+c-'0';
		}
		while((c=read())>='0'&&c<='9'); 
		if(neg)
			return -ret; 
		return ret; 
	} 
	public long nextLong() throws IOException { 
		long ret=0;
		byte c=read(); 
		while(c<=' ')
			c=read(); 
		boolean neg=(c=='-'); 
		if(neg)
			c=read(); 
		do{
			ret=ret*10+c-'0';
		}
		while((c=read())>='0'&&c<='9'); 
		if(neg)
			return -ret; 
		return ret;
	} 
	public double nextDouble() throws IOException{ 
		double ret=0,div=1;
		byte c=read(); 
		while(c<=' ')
			c=read(); 
		boolean neg=(c=='-'); 
		if(neg)c = read(); 
		do {
			ret=ret*10+c-'0';
			}
		while((c=read())>='0'&&c<='9'); 
		if(c=='.')
			while((c=read())>='0'&&c<='9') 
				ret+=(c-'0')/(div*=10); 
		if(neg)
			return -ret; 
		return ret; 
		} 
	private void fillBuffer() throws IOException{ 
		bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE); 
		if(bytesRead==-1)
			buffer[0]=-1; 
		} 
	private byte read() throws IOException{ 
		if(bufferPointer==bytesRead)
			fillBuffer(); 
		return buffer[bufferPointer++]; 
		} 
	public void close() throws IOException{ 
		if(din==null) 
			return; 
		din.close(); 
	} 
}
}
class myScanner { 
	BufferedReader br;
	StringTokenizer st;
	public myScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public String nextLine() throws IOException { 
		return br.readLine();
	}
	public String next() throws IOException { 
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	public int nextInt() throws IOException { 
		return Integer.parseInt(next());
	}
	public long nextLong() throws IOException { 
		return Long.parseLong(next());
	}
	public double nextDouble() throws IOException { 
		return Double.parseDouble(next());
	}
	public boolean ready() throws IOException { 
		return br.ready();
	}
	public void close() throws IOException { 
		br.close();
	}
}
	
