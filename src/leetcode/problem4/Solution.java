package leetcode.problem4;


/**
 * <pre><h3>Median of Two Sorted Arrays </h3>
 * <p>There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).</p></pre>
 * @author racing
 * @since 2015-06-03
 *
 */
public class Solution {

	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m + n;
		if (total % 2 != 0)
			return (double) findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);// k传得是第k个，index实则k-1
		else {
			double x = findKth(A, 0, m - 1, B, 0, n - 1, total / 2);// k传得是第k个，index实则k-1
			double y = findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);// k传得是第k个，index实则k-1
			return (double) (x + y) / 2;
		}
	}

	public static int findKth(int[] A, int astart, int aend, int[] B,
			int bstart, int bend, int k) {
		int m = aend - astart + 1;
		int n = bend - bstart + 1;

		if (m > n) //一直假设m<n
			return findKth(B, bstart, bend, A, astart, aend, k);
		if (m == 0)
			return B[k - 1];
		if (k == 1)
			return Math.min(A[astart], B[bstart]);

		int partA = Math.min(k / 2, m);
		int partB = k - partA;
		if (A[astart + partA - 1] < B[bstart + partB - 1])
			return findKth(A, astart + partA, aend, B, bstart, bend, k - partA);
		else if (A[astart + partA - 1] > B[bstart + partB - 1])
			return findKth(A, astart, aend, B, bstart + partB, bend, k - partB);
		else
			return A[astart + partA - 1];
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {1, 2};
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}

}
