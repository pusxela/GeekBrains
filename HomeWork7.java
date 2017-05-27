/**
 * Java. Level 1. Lesson 7. Homework.
 *
 * @author Alexey Krylov
 * @version dated May 27, 2017
 */
 
 
// Урок 7. Практика ООП и работа со строками
/*
* 1. Расширить задачу про котов и тарелки с едой
* 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
* (например, в миске 10 еды, а кот пытается покушать 15-20)
* 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
* удалось покушать (хватило еды), сытость = true
* 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть
* наполовину сыт (это сделано для упрощения логики программы)
* 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
* потом вывести информацию о сытости котов в консоль
* 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
*/ 

public class HomeWork7 {
	public static void main(String[] args) {
		Cat[] cat = new Cat[5];
		Plate plate = new Plate(5);
		
		cat[0] = new Cat("Barsik", 25);
		cat[1] = new Cat("Belka", 30);
		cat[2] = new Cat("Garik", 5);
		cat[3] = new Cat("Robik", 10);
		cat[4] = new Cat("Pushik", 30);
		
		for (int i = 0; i < cat.length; i++) {
			plate.info();
			cat[i].eat(plate, cat[i]);
		}
		
		for (Cat ct: cat) {
			ct.fed_up_info(ct);
		}
		
		plate.addFood(50);	// добавляем еду
		
		for (int i = 0; i < cat.length; i++) {
			plate.info();
			cat[i].eat(plate, cat[i]);
		}
		
		for (Cat ct: cat) {
			ct.fed_up_info(ct);
		}
		
		
	}
}

class Plate {
	private int food;
		
	public Plate(int food) {
		this.food = food;
	}
	
	public int getFoodInfo() {
		return food;
	}
		
	public void decreaseFood(int n) {
		if ( food>= n) food -= n; 
	}
	
	public void addFood(int n) {
		food += n; 
	}
	
	public void info() {
		System.out.println("plate: " + food);
	}
}	
	
class Cat {
	private String name;
	private int appetite;
	private boolean fed_up; // поле сытости
	
	public Cat(String name, int appetite) {
		this.name = name;
		this.appetite = appetite;
		this.fed_up = false;
	}
	
	public void eat(Plate p, Cat ct) {
		if (p.getFoodInfo() >= ct.appetite) { 
			p.decreaseFood(appetite); 
			ct.fed_up = true;
		} 
			
	}
	
	public void fed_up_info(Cat ct) {
		System.out.println("Cat " + this.name + " fed up status: " + this.fed_up);
	}
	
}


