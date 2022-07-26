package problems.problems10to19;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import util.Utils;
import util.graph.TheGraph;

public class Problem18 {

	/**
	 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
	 * the maximum total from top to bottom is 23.
	 * 
	 *    3
	 *   7 4
	 *  2 4 6
	 * 8 5 9 3
	 * 
	 * That is, 3 + 7 + 4 + 9 = 23.
	 * 
	 * Find the maximum total from top to bottom of the triangle below:
	 * 
	 *                75
	 *               95 64
	 *              17 47 82
	 *             18 35 87 10
	 *            20 04 82 47 65
	 *           19 01 23 75 03 34
	 *          88 02 77 73 07 63 67
	 *         99 65 04 28 06 16 70 92
	 *        41 41 26 56 83 40 80 70 33
	 *       41 48 72 33 47 32 37 16 94 29
	 *      53 71 44 65 25 43 91 52 97 51 14
	 *     70 11 33 28 77 73 17 78 39 68 17 57
	 *    91 71 52 38 17 14 91 43 58 50 27 29 48
	 *   63 66 04 68 89 53 67 30 73 16 69 87 40 31
	 *  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
	 * 
	 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
	 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot 
	 * be solved by brute force, and requires a clever method! ;o)
	 */
	public static void main(String[] args) {
		TheGraph graph = createGraph();
		
		Utils.show(graph.rows());

		long t0 = System.nanoTime();
		int bF = bruteForce(graph);
		long tf = System.nanoTime();
		System.out.println("\nBrute force: " + bF);
		System.out.println("Time to run: " + (tf - t0));

		t0 = System.nanoTime();
		int dP = dynamicProgramming(graph);
		tf = System.nanoTime();
		System.out.println("\nDynamic programming: " + dP);
		System.out.println("Time to run: " + (tf - t0));
	}

	public static int bruteForce(TheGraph graph) {
		Integer[][] pyramid = graph.rows();

		return maximumSum(0, 0, pyramid);
	}

	public static int maximumSum(int i, int j, Integer[][] pyramid) {
		if (i == pyramid.length - 1) {
			return pyramid[i][j];
		}

		Integer currentElement = pyramid[i][j];
		int leftSum = maximumSum(i + 1, j, pyramid);
		int rightSum = maximumSum(i + 1, j + 1, pyramid);
		return currentElement + Math.max(leftSum, rightSum);
	}

	public static int dynamicProgramming(TheGraph graph) {
		Integer[][] pyramid = graph.rows();

		Integer[][] supportMatrix = new Integer[pyramid.length][pyramid[pyramid.length - 1].length];
		for (Integer[] matrix : supportMatrix) {
			Arrays.fill(matrix, -1);
		}
		return maximumSumWithSupport(0, 0, pyramid, supportMatrix);
	}

	public static int maximumSumWithSupport(int i, int j, Integer[][] pyramid, Integer[][] supportMatrix) {
		if (i == pyramid.length - 1) {
			return pyramid[i][j];
		}

		if (supportMatrix[i][j] > -1) {
			return supportMatrix[i][j];
		}

		Integer currentElement = pyramid[i][j];
		int leftSum = maximumSum(i + 1, j, pyramid);
		int rightSum = maximumSum(i + 1, j + 1, pyramid);

		int maxSum = currentElement + Math.max(leftSum, rightSum);
		supportMatrix[i][j] = maxSum;
		return maxSum;
	}

	public static TheGraph createGraph() {
		File data = new File(new File(".").getAbsolutePath() + "/src/main/resources/problem18.data");

		Supplier<Stream<Object>> sup = () -> {
			try {
				return Stream.of(Files.lines(data.toPath()).toArray());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		};
		
		TheGraph graph = new TheGraph((int) sup.get().count());
		
		sup.get().forEach(
			(item) ->
				graph.insertRow(
					Arrays.stream(item.toString().split(" ")).map(Integer::parseInt).collect(Collectors.toList())
				)
			);
		
		return graph;
	}
	
}
