public class Recursion07 {
	public static void main(String[] args) {
        int result = gcd(10, 4);
        System.out.println(result);
	}
    
	public static int gcd(int m, int n) {
		if(m<n) {
			int tmp = m; m=n; n=tmp; // swap m and n
		}
		if (m%n==0)
			return n;
		else
			return gcd(n, m%n);
	}
}