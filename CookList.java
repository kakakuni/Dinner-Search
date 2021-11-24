package cookp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CookList extends ArrayList<Cook>{

	void createCook(String line) {
		String id;
		String name;
		String genre;
		String mainFood;
		String food1;
		Set<String> food = new HashSet<>();
		ArrayList<String> recipe = new ArrayList<>();
		String nameK;
		Set<String> gemakana = new HashSet<>();
		String food1k;
		Set<String> foodkana = new HashSet<>();

		String[] st = line.split(",");//","を区切りとして配列を作る
		id = st[0];
		name = st[1];
		genre = st[2];
		mainFood = st[3];
		food1 = st[4];

		for(int i=5; i<10; i++ ) {//Setに代入
			food.add(st[i]);
		}
		for(int i=10; i<15; i++ ) {//Listに代入
			recipe.add(st[i]);
		}
		nameK = st[15];
		for(int i=16; i<18; i++ ) {//Setに代入
			gemakana.add(st[i]);
		}
		food1k = st[18];
		for(int i=19; i<st.length; i++ ) {//Setに代入
			foodkana.add(st[i]);
		}
		add(new Cook(id, name, genre, mainFood, food1, food, recipe, nameK, gemakana, food1k, foodkana));//ArrayListのメソッド使用
	}
}
