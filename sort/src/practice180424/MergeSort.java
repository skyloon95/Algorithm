package practice180424;

import java.util.Arrays;

public class MergeSort {
	public static int count = 0;
	public static void mergeSort(int[] a, int start, int end) {
		int current = count++;
		if(start == end) {
			return;
		}
		int mid = (start+end)/2;
		mergeSort(a, start, mid);
		mergeSort(a, mid+1, end);
		merge(a, start, mid, end);
		System.out.println(Arrays.toString(a));
	}

	public static void merge(int[] a, int start, int mid, int end) {
		int index1 = start;
		int index2 = mid+1;
		int length = end - start + 1;
		int[] tmp = new int[length];

		for(int i = 0 ; i<length ; i++) {
			if(index1<=mid&&index2<=end)
				tmp[i] = ((a[index1]<a[index2])?a[index1++]:a[index2++]);
			else if(index1<=mid)
				tmp[i] = a[index1++];
			else if(index2<=end)
				tmp[i] = a[index2++];
		}

		for(int i = start, j = 0 ; i<=end ; i++, j ++) {
			a[i] = tmp[j];
		}
	}

	public static void main(String[] args) {
		int[] a = {4, 13, 5, 8, 1};

		mergeSort(a, 0, a.length-1);
	}
}
