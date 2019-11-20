public class Recursion08 {
	public static void main(String[] args) {
        int result = gcd(10, 4);
        System.out.println(result);
	}
    
	public static int gcd(int p, int q) {
		if (q==0)
			return p;
		else
			return gcd(q, p%q);
	}
}