package practice180424;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
	public static void quickSort(int[] a, int start, int end) {
		int size = end - start + 1;
		switch(size) {
		case 0:
		case 1: return;
		case 2:
			sort2(a, start);
			return;
		case 3:
			sort3(a, start);
			return;
		case 4:
			sort4(a, start);
			return;
		case 5:
			sort5(a, start);
			return;
		case 6:
			sort6(a, start);
			return;
		}
		
		int mid = partition(a, start, end);
		int middle = partition(a, start, end);
        quickSort(a, start, middle-1);
        quickSort(a, middle+1, end);
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
	
	static void checkSorted(int[] a) {
        for (int i = 0; i < a.length - 1; ++i)
            if (a[i] > a[i + 1]) {
                System.out.println("error");
                System.exit(0);
            }
    }
	
	static void sort2(int[] a, int start) {
        if (a[start] > a[start + 1]) swap(a, start, start + 1);
    }

    static void sort3(int[] a, int start) {
        if (a[start] > a[start+1]) swap(a, start, start+1);
        if (a[start] > a[start+2]) swap(a, start, start+2);
        if (a[start+1] > a[start+2]) swap(a, start+1, start+2);
    }

    static void sort4(int[] a, int start) {
        if (a[start] > a[start + 1]) swap(a, start, start + 1);
        if (a[start + 2] > a[start + 3]) swap(a, start + 2, start + 3);
        if (a[start] > a[start + 2]) swap(a, start, start + 2);
        if (a[start + 1] > a[start + 3]) swap(a, start + 1, start + 3);
        if (a[start + 1] > a[start + 2]) swap(a, start + 1, start + 2);
    }

    static void sort5(int[] a, int start) {
        if (a[start] > a[start + 1]) swap(a, start, start + 1);
        if (a[start + 2] > a[start + 3]) swap(a, start + 2, start + 3);
        if (a[start + 1] > a[start + 3]) swap(a, start + 1, start + 3);
        if (a[start + 3] > a[start + 4]) swap(a, start + 3, start + 4);
        sort4(a, start);
    }

    static void sort6(int[] a, int start) {
        if (a[start] > a[start + 1]) swap(a, start, start + 1);
        if (a[start + 2] > a[start + 3]) swap(a, start + 2, start + 3);
        if (a[start + 4] > a[start + 5]) swap(a, start + 4, start + 5);
        if (a[start] > a[start + 2]) swap(a, start, start + 2);
        if (a[start] > a[start + 4]) swap(a, start, start + 4);
        if (a[start + 3] > a[start + 5]) swap(a, start + 3, start + 5);
        if (a[start + 1] > a[start + 5]) swap(a, start + 1, start + 5);
        sort4(a, start + 1);
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[20];
        for (int i = 0; i < a.length; ++i)
            a[i] = random.nextInt(20);

        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));

        checkSorted(a);
    }

}
