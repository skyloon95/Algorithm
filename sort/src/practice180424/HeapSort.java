package practice180424;

import java.util.Arrays;

public class HeapSort {
	public static void heapify(int[] a, int index, int end) {
		int leftChildIndex = index*2 + 1;
		int rightChildIndex = index*2 + 2;
		int smallIndex;
		
		if(leftChildIndex>end) return;
		if(rightChildIndex<=end) {
			smallIndex = a[leftChildIndex]<a[rightChildIndex] ? leftChildIndex : rightChildIndex;
		}
		else if(leftChildIndex <= end) {
			smallIndex = leftChildIndex;
		}
		else return;
		
		if(a[index] > a[smallIndex]) {
			swap(a, index, smallIndex);
			heapify(a, smallIndex, end);
		}
	}
	
	public static void buildHeap(int[] a) {
		int end = a.length-1;
		int lastParent = (end - 1) / 2;
		
		for(int i = lastParent ; i>=0 ; i--) {
			heapify(a, i, end);
		}
	}
	
	public static void heapSort(int[] a) {
		buildHeap(a);
		for(int end = a.length-1 ; end>=1 ; end--){
			swap(a, 0, end);
			heapify(a, 0, end - 1);
			System.out.println(Arrays.toString(a));
		}
	}
	

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
        int[] a = {4, 13, 5, 8, 1, 6};
        heapSort(a);
    }

}
