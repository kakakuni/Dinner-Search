package cookp;

import java.util.ArrayList;
import java.util.Scanner;

public class CookMain {
	public static void main(String[] args) {

		CookManage cm = new CookManage();
		cm.inputCsv();
		ArrayList<String> names = new ArrayList<>();
		Dinner din = new Dinner(); //タイトルオブジェクト
		Scanner sc = new Scanner(System.in);

		/*try {
			TimeUnit.SECONDS.sleep(2);
			din.title();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		din.title();
		din.mainSe();

		String ts = sc.next();

		if (ts.equals("1") || ts.equals(1)) { //検索を条件分岐
			System.out.println("[" + ts + "]" + "ジャンル検索を入力しました。");
			System.out.println();
			System.out.println("[1] 和食　[2] 洋食　[3] 中華　[4] 一品料理");
			System.out.println("----[番号] [漢字] [ひらがなの]いずれか1つを入力してください。----");

			String s = sc.next();
			if (s.equals("和食") || s.equals("わしょく") || s.equals("1")) { //ジャンル検索
				System.out.println("和食で検索します。");
				System.out.println();

				names.addAll(cm.searchGenre("和食"));

				for (int i = 0; i < names.size(); i++) { //ArrayListからのジャンル検索と和食の料理名表示
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int w = sc.nextInt();
				cm.veiwRecipe(names.get(w - 1));

			} else if (s.equals("洋食") || s.equals("ようしょく") || s.equals("2")) {
				System.out.println("洋食で検索します。");
				System.out.println();
				names.addAll(cm.searchGenre("洋食"));
				for (int i = 0; i < names.size(); i++) { //ArrayListからのジャンル検索と和食の料理名表示
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int y = sc.nextInt();
				cm.veiwRecipe(names.get(y - 1));

			} else if (s.equals("中華") || s.equals("ちゅうか") || s.equals("3")) {
				System.out.println("中華で検索します。");
				System.out.println();
				names.addAll(cm.searchGenre("中華"));
				for (int i = 0; i < names.size(); i++) { //ArrayListからのジャンル検索と和食の料理名表示
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int c = sc.nextInt();
				cm.veiwRecipe(names.get(c - 1));

			} else if (s.equals("一品料理") || s.equals("いっぴん") || s.equals("いっぴんりょうり") || s.equals("4")) {
				System.out.println("一品料理で検索します。");
				System.out.println();
				names.addAll(cm.searchGenre("一品料理"));
				for (int i = 0; i < names.size(); i++) { //ArrayListからのジャンル検索と和食の料理名表示
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int o = sc.nextInt();
				cm.veiwRecipe(names.get(o - 1));
			} else {
				System.out.println("[番号] [漢字] [ひらがな]のいずれかを1つ入力してください。");
				return;
			}
		} else if (ts.equals("2") || ts.equals(2)) {
			System.out.println("[" + ts + "]" + "メイン食材検索を入力しました。");
			System.out.println();
			System.out.println("[1] 肉　[2] 魚　[3] 野菜　[4] その他");
			System.out.println("----[番号] [漢字] [ひらがなの]いずれか1つを入力してください。----");
			System.out.println();

			String s2 = sc.next();
			if (s2.equals("肉") || s2.equals("にく") || s2.equals("1")) { //メイン食材検索
				System.out.println("お肉のおススメ料理です。");
				System.out.println();
				names.addAll(cm.searchMainF("肉"));

				for (int i = 0; i < names.size(); i++) { //ArrayListからのメイン食材検索の料理名表示
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int m = sc.nextInt();
				cm.veiwRecipe(names.get(m - 1));

			} else if (s2.equals("魚") || s2.equals("さかな") || s2.equals("2")) {
				System.out.println("お魚のおススメ料理です。");
				System.out.println();
				names.addAll(cm.searchMainF("魚"));

				for (int i = 0; i < names.size(); i++) { //ArrayListからのメイン食材検索の料理名表示
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int m = sc.nextInt();
				cm.veiwRecipe(names.get(m - 1));

			} else if (s2.equals("野菜") || s2.equals("やさい") || s2.equals("3")) {
				System.out.println("お野菜のおススメ料理です。");
				System.out.println();
				names.addAll(cm.searchMainF("野菜"));

				for (int i = 0; i < names.size(); i++) {
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}
				int m = sc.nextInt();
				cm.veiwRecipe(names.get(m - 1));

			} else if (s2.equals("その他") || s2.equals("そのた") || s2.equals("4")) {
				System.out.println("その他のおススメ料理です。");
				System.out.println();
				names.addAll(cm.searchMainF("その他"));

				for (int i = 0; i < names.size(); i++) {
					System.out.println("[" + (i + 1) + "] " + names.get(i));
				}

				int m = sc.nextInt();
				cm.veiwRecipe(names.get(m - 1));

			} else {
				System.out.println("[番号] [漢字] [ひらがな]のいずれかを1つ入力してください。");
				return;
			}
		} else if (ts.equals("3") || ts.equals(3)) {
			System.out.println("[" + ts + "]" + "キーワード検索を入力しました。"); //キーワード検索
			String[] st;
			String s3 = sc.nextLine();

			while (s3.equals(" ") || s3.equals("　") || s3.isEmpty()) {
				System.out.println("キーワードを入力してください。");
				s3 = sc.nextLine();
			}

			st = s3.split("　");
			if (st.length == 1) {
				st = s3.split(" ");
			}

			System.out.println();
			//cm.searchKeyword(st);

			if(cm.searchKeyword(st) == 0) {
				names.addAll(cm.searchAbout(st));

				if(names.size() != 0) {
					System.out.println("以下にお探しの料理はありますか？");
					for(int i = 0; i < names.size(); i++) { //ArrayListからのメイン食材検索の料理名表示
						System.out.println("[" + (i+1) + "] " + names.get(i));
					}
					int m = sc.nextInt();
					cm.veiwRecipe(names.get(m-1));
				}
			}
			sc.close();


		} else {
			System.out.println("1～3" + "の数字を1つ入力してください。");
			return;
		}

	}

}

/*		System.out.println("キーワード入力してください。");

		String s3 = sc.nextLine();
		String[] st = s3.split(" ");

		if(st.length == 1) {
			st = s3.split("　");
		}

		System.out.println();
		System.out.println("キーワード検索のおススメ料理は");
		cm.searchKeyword(st);
		}else {
			System.out.println("1～3" + "の数字を1つ入力してください。");
			return;
		}*/
//cm.searchMainF();
/*
				for(String s : st) {
					System.out.println(s);
				}
Scanner sc4 = new Scanner(System.in);
System.out.println("キーワード入力してください。");

//String s3 = sc4.next();
ArrayList<String> list = new ArrayList<String>();
while(sc4.hasNext()) {
	list.add(sc4.next());
}
System.out.println(sc4);
String[] st = sc4.split(" ");
while(sc4.hasNext()) {
	String[] st;
	String s3 = sc4.next();
}
System.out.println("キーワードから検索したおススメ料理は");
//cm.searchKeyword();
System.out.println(list.get(0) + "です。");
*/
/*for(String name : names ) {
System.out.println(name);
}*/

/*for( String s2 : names) {
int i=0;
i++;
System.out.println("["+ names.get + "] " + s2);
}*/
