package GeekForGeek.Java;

public class Polymorphism {
	
	public static void main(String[] args) {
		A b = new B();
		b.print();
		System.out.println(b.x);
		System.out.println(b.getX());
	}

}

class A{
	int x = 1;
	public void print(){
		System.out.println("A " + x);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
}

class B extends A{
	int x = 2;
	public void print(){
		System.out.println("B" + x);
	}
	
	public void isB(){
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
