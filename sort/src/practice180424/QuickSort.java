package practice180424;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] a, int start, int end) {
		if(start>=end)return;
		int mid = partition(a, start, end);
		quickSort(a, start, mid-1);
		quickSort(a, mid+1, end);
		System.out.println(Arrays.toString(a));
	}
	
	public static int partition(int[] a, int start, int end) {
		int value = a[end];
		int i = start - 1;
		
		for(int j = start ; j<end ; j++) {
			if(a[j] < value)
				swap(a, ++i, j);
		}
		swap(a, i+1, end);
		
		return i + 1;
	}
	
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] a = {4, 13, 5, 8, 1, 6};

		quickSort(a, 0, a.length-1);
	}
}
