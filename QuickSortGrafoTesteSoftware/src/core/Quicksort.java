package core;

public class Quicksort {

	public static void quicksort(int a[], int lo0, int hi0) {
		int lo = lo0;
		int hi = hi0;
		int mid;
		// pause for redraw
		if (hi0 > lo0) {// 1
			mid = a[(lo0 + hi0) / 2];

			while (lo <= hi) {// 2
				while ((lo < hi0) && (a[lo] < mid))
					// 3
					++lo;
				while ((hi > lo0) && (a[hi] > mid))
					// 4
					--hi;
				if (lo <= hi) {// 5
					swap(a, lo, hi);
					++lo;
					--hi;
				}
			}
			if (lo0 < hi)// 6
				quicksort(a, lo0, hi);
			if (lo < hi0)// 7
				quicksort(a, lo, hi0);
		}
	}

	private static void swap(int[] a, int lo, int hi) {
		int temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
}
