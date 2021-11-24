package cookp;

import java.util.Scanner;

public class CookSearch {
	//private boolean swo = true;
	Scanner sc = new Scanner(System.in);

	String ModeSe1() {
		System.out.println("[1]ジャンル検索です。");
		System.out.println();
		System.out.println("[1] 和食　[2] 洋食　[3] 中華　[4] 一品料理");
		System.out.println("----[番号] [漢字] [ひらがなの]いずれか1つを入力してください。----");

		String s = sc.next();

		if (s.equals("和食") || s.equals("わしょく") || s.equals("1")) { //ジャンル検索
			System.out.println("和食で検索します。");
			System.out.println();
			return "和食";

		} else if (s.equals("洋食") || s.equals("ようしょく") || s.equals("2")) {
			System.out.println("洋食で検索します。");
			System.out.println();
			return "洋食";

		} else if (s.equals("中華") || s.equals("ちゅうか") || s.equals("3")) {
			System.out.println("中華で検索します。");
			System.out.println();
			return "中華";

		} else if (s.equals("一品料理") || s.equals("いっぴん") || s.equals("いっぴんりょうり") || s.equals("4")) {
			System.out.println("一品料理で検索します。");
			System.out.println();
			return "一品料理";
		} else {
			System.out.println("[番号] [漢字] [ひらがな]のいずれかを1つ入力してください。");
			System.out.println();
			return ModeSe1();
		}
	}

	String ModeSe2() {
		System.out.println("[2]メイン食材検索です。");
		System.out.println();
		System.out.println("[1] 肉　[2] 魚　[3] 野菜　[4] その他");
		System.out.println("----[番号] [漢字] [ひらがなの]いずれか1つを入力してください。----");

		String s2 = sc.next();

		if (s2.equals("肉") || s2.equals("にく") || s2.equals("1")) { //メイン食材検索
			System.out.println("お肉のおススメ料理です。");
			System.out.println();
			return "肉";

		} else if (s2.equals("魚") || s2.equals("さかな") || s2.equals("2")) {
			System.out.println("お魚のおススメ料理です。");
			System.out.println();
			return "魚";

		} else if (s2.equals("野菜") || s2.equals("やさい") || s2.equals("3")) {
			System.out.println("お野菜のおススメ料理です。");
			System.out.println();
			return "野菜";

		} else if (s2.equals("その他") || s2.equals("そのた") || s2.equals("4")) {
			System.out.println("その他のおススメ料理です。");
			System.out.println();
			return "その他";

		} else {
			System.out.println("[番号] [漢字] [ひらがな]のいずれかを1つ入力してください。");
			System.out.println();
			return ModeSe2();
		}
	}

	String[] ModeSe3() {
		System.out.println("[3]キーワード検索です。"); //キーワード検索
		System.out.println("スペースを開けてキーワードを入力してください。");
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
		return st;
	}
}
