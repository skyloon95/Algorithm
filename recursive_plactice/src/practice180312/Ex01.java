package practice180312;

public class Ex01 {
	public static void main(String[] args) {
		int count = 0;
		int n = 100;
		for(int j = 0 ; j<n ; ++j) {
			for(int h = j ; h<n ; ++h) {
				++count;
			}
		}
		
		System.out.println(count);
	}
}
