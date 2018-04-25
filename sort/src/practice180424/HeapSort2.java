package practice180424;

import java.util.Arrays;

public class HeapSort2 {
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
        int[] a = { 3, 8, 2, 10, 4, 6, 7, 1, 9, 5 };
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
	
	public static void heapify(int[] a, int index, int end) {
		int bigIndex;
		int leftChildIdx = index*2+1;
		int rightChildIdx = index*2+2;
		
		if(leftChildIdx>end) return;
		
		if(rightChildIdx<=end) {
			bigIndex = a[leftChildIdx]>a[rightChildIdx] ? leftChildIdx : rightChildIdx;
		}
		else if(leftChildIdx<=end) {
			bigIndex = leftChildIdx;
		}
		else return;
		
		if(a[index]<a[bigIndex]) {
			swap(a, index, bigIndex);
			heapify(a, bigIndex, end);
		}
	}
	
	public static void buildHeap(int[] a) {
		int end = a.length-1;
		int lastParent = (end - 1) /2;
		
		for(int i = lastParent ; i>=0 ; i--) {
			heapify(a, i, end);
		}
	}
	
	public static void heapSort(int[] a) {
		buildHeap(a);
		
		for(int end = a.length-1 ; end>=0 ; end--) {
			swap(a, 0, end);
			heapify(a, 0, end-1);
		}
	}
}
