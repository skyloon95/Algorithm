package practice180424;

import java.util.Arrays;
import java.util.Random;

public class Selection {
	public static int partition(int a[], int start, int end) {
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

	public static int select(int[] a, int start, int end, int nth) {
		if(start >=end) return a[start];
		int mid = partition(a, start, end);
		int mid_nth = mid - start + 1;
		
		if(mid_nth == nth) return a[mid];
		if(mid_nth > nth)
			return select(a, start, mid-1, nth);
		else
			return select(a, mid+1, end, nth - mid_nth);
	}

	public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = random.nextInt(20);

        System.out.println(Arrays.toString(a));
        System.out.printf("2 번째 작은 값 = %d\n", select(a, 0, a.length-1, 2));
        System.out.println(Arrays.toString(a));

    }
}
