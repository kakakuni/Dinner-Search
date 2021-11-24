package cookp;

import java.util.ArrayList;
import java.util.Scanner;

public class CookMain2 {
	public static void main(String[] args) {

		boolean roop = false;
		CookManage cm = new CookManage();
		cm.inputCsv();
		ArrayList<String> names = new ArrayList<>();
		Dinner din = new Dinner();
		Scanner sc = new Scanner(System.in);
		din.title();

		do {
			din.mainSe();

			CookSearch cs = new CookSearch();

			String ts = sc.next();
			if (ts.equals("1") || ts.equals("１")) {
				names.addAll(cm.searchGenre(cs.ModeSe1()));
			} else if (ts.equals("2") || ts.equals("２")) {
				names.addAll(cm.searchMainF(cs.ModeSe2()));
			} else if (ts.equals("3") || ts.equals("３")) {
				String[] st = cs.ModeSe3();
				int sea = cm.searchKeyword(st);
				if (sea == 0) {
					names.addAll(cm.searchAbout(st));

					if (names.size() != 0) {
						System.out.println("以下にお探しの料理はありますか？");
					}
				}
			} else {
				System.out.println("1～3" + "の数字を1つ入力してください。");
			}

			if (names.size() != 0) {
				for (int i = 0; i < names.size(); i++) { //ArrayListからのジャンル検索と和食の料理名表示
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int w = sc.nextInt();
				cm.veiwRecipe(names.get(w - 1));
			}

			System.out.println();
			System.out.println("検索トップに戻りますか？");
			System.out.println("戻る：[1], 終わる：[2]");
			System.out.println();

			ts = sc.next();
			if (ts.equals("1") || ts.equals("１")) {
				roop = true;
				names.clear();
				cm.ClList();
			}else {
				roop = false;
				System.out.println("またのお越しを～！");
			}
		} while (roop);
		sc.close();
	}
}