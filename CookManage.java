package cookp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CookManage {
	private Cook[] cook;
	private ArrayList<String> lists = new ArrayList<>();

	void inputCsv() {
		BufferedReader reader = null;
		CookList list = new CookList();
		String line;

		try {
			//CSVファイルからデータの読み込み
			reader = new BufferedReader(new FileReader("src\\cookp\\cookDeta.csv"));

			while((line = reader.readLine()) != null) {
				list.createCook(line);
			}

			//ArrayListから配列にCookオブジェクトを代入
			cook = list.toArray(new Cook[list.size()]);

		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(reader != null) {
				try {
					reader.close();
				}catch(IOException ex) {}
			}
			System.out.println(" (料理レシピデータ：" + (list.size()-1) + "件)");
		}
	}

	ArrayList<String> searchGenre(String genre){
		//ジャンル検索
		boolean flag = true;
		for(int i = 1; i < cook.length; i++){
			if(cook[i].getGenre().equals(genre)){
				lists.add(cook[i].getName());
				flag = false;
			}
		}
		if(flag) System.out.println("該当のジャンルが見つかりません");
		return lists;
	}

	ArrayList<String> searchMainF(String mf){
		//メイン食材検索
		boolean flag = true;
		for(int i = 1; i < cook.length; i++){
			if(cook[i].getMainfood().equals(mf)){
				lists.add(cook[i].getName());
				flag = false;
			}
		}
		if(flag) System.out.println("該当の食材が見つかりません");
		return lists;
	}

	void veiwRecipe(String na1){
		//レシピの出力
		boolean flag = true;
		for( Cook ck : cook){
			if(ck.getName().equals(na1) || ck.getNameK().equals(na1)){
				System.out.println("〇本日のおすすめ料理");
				System.out.println("---" + ck.getName() + "---");
				for(String s: ck.getRecipe()){
					System.out.println(s);
				}
				flag = false;
				return;
			}
		}
		if(flag) System.out.println("該当の料理名が見つかりません");
	}

	int searchKeyword(String[] st){
		//キーワード検索
		int k = 0;
		int l = 2;
		int[] rec = {0, 0};
		Random random = new Random();

		for( int i = 1; i < cook.length; i++){
			for(int j = 0; j < st.length; j++){
				if(cook[i].getName().equals(st[j]) ||
						cook[i].getNameK().equals(st[j])){
					veiwRecipe(st[j]);
					return 1;
				}else if(cook[i].getFood1().equals(st[j]) ||
						cook[i].getFood1k().equals(st[j])){
					k += 10;
				}else if(cook[i].searchGemak(st[j]) ||
						cook[i].getGenre().equals(st[j])) {
					k += 5;
				}else if(cook[i].getMainfood().equals(st[j]) ||
						cook[i].searchFood(st[j]) ||
						cook[i].searchFoodK(st[j])) {
					k++;
				}
			}
			if(rec[1] < k) {//一致数が多いレシピを代入
				rec[0] = i;
				rec[1] = k;
			}else if(k > 0 && rec[1] == k){//一致数が同じ場合はランダムに代入
				if(random.nextInt(l) == 0) {
					rec[0] = i;
					rec[1] = k;
					l++;
				}
			}
			k = 0;
		}

		if(rec[1] == 0) {
			System.out.println("該当のキーワードが見つかりません");
			return rec[1];
		}else {
			//一番キーワードと当てはまった数が多いものをおススメとして表示
			veiwRecipe(cook[rec[0]].getName());
			return rec[1];
		}
	}

	ArrayList<String> searchAbout(String[] st){
		for( int i = 1; i < cook.length; i++){
			for(int j = 0; j < st.length; j++){
				if(cook[i].getName().matches(".*" + st[j] + ".*") ||
						cook[i].getNameK().matches(".*" + st[j] + ".*")){
					lists.add(cook[i].getName());
				}
			}
		}
		return lists;
	}

	void ClList() {
		lists.clear();
	}
}