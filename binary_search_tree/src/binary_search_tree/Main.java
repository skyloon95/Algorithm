package binary_search_tree;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("이진탐색트리 유틸\n");

		TreeUtil tree = new TreeUtil();
		Scanner scan = new Scanner(System.in);
		int select = 0;
		boolean check = false;

		while(select!=5) {
			System.out.println("====1) 추가 / 2) 삭제 / 3) 전위순회 출력 / 4)탐색 / 5) 종료====");
			
			select = scan.nextInt();
			
			switch(select) {
			case 1 :
				System.out.println("추가할 정수를 입력해주세요");
				check = tree.add(scan.nextInt());
				if(check)
					System.out.println("추가 성공");
				else
					System.out.println("추가 실패");
				break;
				
			case 2:
				System.out.println("삭제할 정수를 입력해주세요");
				break;
				
			case 3:
				tree.printFF(tree.root);
				break;
				
			case 4:
				System.out.println("찾고자 하는 데이터를 입력하세요");
				check = tree.contains(tree.root, scan.nextInt());
				if(check)
					System.out.println("해당 데이터가 존재합니다.");
				else
					System.out.println("해당 데이터는 존재하지 않습니다.");
				break;
				
			case 5:
				break;
				
			default:
				System.out.println("존재하지 않는 메뉴번호입니다.");
				break;
				
			}
		}
	}
}
