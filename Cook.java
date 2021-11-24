package cookp;

import java.util.ArrayList;
import java.util.Set;

public class Cook {
	private String id;
	private String name;
	private String genre;
	private String mainfood;
	private String food1;
	private Set<String> subfood;
	private ArrayList<String> recipe;
	private String nameK;
	private Set<String> gemakana;
	private String food1k;
	private Set<String> foodkana;

	Cook(String i, String n, String g, String mf, String f1, Set<String> sf,
			ArrayList<String> r, String nk, Set<String> gmk, String f1k, Set<String> fk){
	  id = i;
	  name = n;
	  genre = g;
	  mainfood = mf;
	  food1 = f1;
	  subfood = sf;
	  recipe = r;
	  nameK = nk;
	  gemakana = gmk;
	  food1k = f1k;
	  foodkana = fk;
	}
	Cook(){
	}

	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getGenre(){
		return genre;
	}
	public String getMainfood(){
		return mainfood;
	}
	public Set<String> getSubfood(){
		return subfood;
	}
	public ArrayList<String> getRecipe(){
		return recipe;
	}
	public String getNameK(){
		return nameK;
	}
	public Set<String> getFoodkana() {
		return foodkana;
	}
	public String getFood1() {
		return food1;
	}
	public Set<String> getGemakana() {
		return gemakana;
	}
	public String getFood1k() {
		return food1k;
	}

	boolean searchFood(String st){
		return subfood.contains(st);
	}
	boolean searchFoodK(String st){
		return foodkana.contains(st);
	}
	boolean searchGemak(String st){
		return gemakana.contains(st);
	}
}