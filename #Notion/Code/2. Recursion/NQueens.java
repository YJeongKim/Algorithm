public class NQueens {
	private static int N=8;
	private static int [] cols = new int [N+1];

	public static boolean queens(int level) {
		if (!promising(level))
			return false;
		else if (level==N) {
			for(int i=1; i<=N; i++)
				System.out.println("(" + i + ", " + cols[i] + ")");
			return true;
		}
		for (int i=1; i<=N; i++) {
			cols[level+1] = i;
			if (queens(level+1))
				return true;
		}
		return false;
	}

	public static boolean promising(int level) {
		for (int i=1; i<level; i++) {
			if (cols[i]==cols[level])
				return false;
			else if ((level-i)==Math.abs(cols[level]-cols[i]))
				return false;
		}
		return true;
	}

	public static void main(String [] args) {
		queens(0);
	}
}