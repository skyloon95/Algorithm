package practice180424;

public class LinearSelection {
	public static int partition(int a[], int start, int end, int pivotIdx) {
		swap(a, end, pivotIdx);
		int value = a[end];
		int i = start - 1;

		for(int j = start ; j<end ; j++) {
			if (a[j] < value) {
				++i;
				if (i != j) swap(a, i, j); // 불필요한 swap 하지 않기
			}

		}
		swap(a, i+1, end);

		return i + 1;
	}

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void quickSort(int[] a, int start, int end) {
		if(start>=end)return;
		int mid = partition(a, start, end, end);
		if(mid==end) return;
		quickSort(a, start, mid-1);
		quickSort(a, mid+1, end);
	}

	public static int linearSort(int[] a, int start, int end, int nth) {
		if(start - end <= 5) {
			quickSort(a, start, end);
			return a[nth];
		}
		int num = (end - start + 1) % 5 == 0 ? (end - start + 1) / 5 : (end - start + 1) / 5  + 1;
		int[] midArr = new int[num];
		for(int i = 0 ; i<num ; i++) {
			int[] tmp = new int[5];
			for(int j = 0 ; j<5 ; j++)
				tmp[j] = a[start+i+j];
			midArr[i] = linearSort(tmp, 0, tmp.length-1, 3);
		}
		
		return 0;
	}
}
