public class Recursion13 {
	public static void main(String[] args) {
        int[] data = { 2, 4, 6 };
		System.out.println(sum(3, data));
	}

	public static int sum(int n, int[] data) {
		if(n<=0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
}