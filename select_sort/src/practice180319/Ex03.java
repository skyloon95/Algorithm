package practice180319;

public class Ex03 {
	// 배열 a의 start 위치부터 끝까지에서 가장 작은 값의 위치(index)를 리턴한다.
	static int findMin(int[] a, int start) {
		int index = start;
		for(int i = start + 1 ; i<a.length ; i++) {
			if(a[i]<a[index]) index = i;
		}
		
		return index;
	}

	public static void main(String[] args) {
		int[] a = { 14, 11, 13, 15 };

		for (int i = 0; i < a.length; ++i) {
			int minIndex = findMin(a, i);
			System.out.println(a[minIndex]);
		}

	}
}

