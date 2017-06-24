package problems.problems10to19;

import java.math.BigInteger;

public class Problem15 {

	public static void main(String[] args) {
		int max = 20;
		Matrix paths = new Matrix(max + 1);
		BigInteger qtt = path(paths, max, 0, 0);
		
		System.out.println(qtt);
	}

	private static BigInteger path(Matrix mat, int max, int i, int j) {
		if (i == max && j == max) {
			if (mat.paths[i][j] == null) mat.paths[i][j] = BigInteger.ONE;
		} else if (i < max && j == max) {
			if (mat.paths[i][j] == null) mat.paths[i][j] = path(mat, max, i + 1, j);
		} else if (i == max && j < max) {
			if (mat.paths[i][j] == null) mat.paths[i][j] = path(mat, max, i, j + 1);
		} else {
			if (mat.paths[i][j] == null) mat.paths[i][j] = path(mat, max, i + 1, j).add(path(mat, max, i, j + 1));
		}
		
		return mat.paths[i][j];
	}
	
	static class Matrix {
		public BigInteger[][] paths;
		
		public Matrix(int n) {
			this.paths = new BigInteger[n][n];
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (BigInteger[] v : this.paths) {
				for (BigInteger e : v) {
					sb.append(e);
					sb.append(" ");
				}
				sb.append("\n");
			}
			
			return sb.toString();
		}
	}
	
}
