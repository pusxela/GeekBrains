/**
 * Java. Level 1. Lesson 7. Homework.
 *
 * @author Alexey Krylov
 * @version dated May 27, 2017
 */
 
 
// ���� 7. �������� ��� � ������ �� ��������
/*
* 1. ��������� ������ ��� ����� � ������� � ����
* 2. ������� ���, ����� � ������� � ���� �� ����� ���������� �������������� ���������� ���
* (��������, � ����� 10 ���, � ��� �������� �������� 15-20)
* 3. ������� ���� ����� �������� ���� ������� (����� ������� �����, ��� �������). ���� ����
* ������� �������� (������� ���), ������� = true
* 4. �������, ��� ���� ���� ���� ��� � �������, �� �� �� ������ �� �������, �� ���� �� ����� ����
* ���������� ��� (��� ������� ��� ��������� ������ ���������)
* 5. ������� ������ ����� � ������� � ����, ��������� ���� ����� �������� �� ���� ������� �
* ����� ������� ���������� � ������� ����� � �������
* 6. �������� � ������� �����, � ������� �������� ����� ���� �� ��������� ��� � �������
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
		
		plate.addFood(50);	// ��������� ���
		
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
	private boolean fed_up; // ���� �������
	
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


