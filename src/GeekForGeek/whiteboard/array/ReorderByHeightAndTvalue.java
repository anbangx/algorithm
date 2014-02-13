package GeekForGeek.whiteboard.array;

import java.util.ArrayList;

import leetcode.data.Person;

public class ReorderByHeightAndTvalue {
	
	public Person[] reorder(Person[] persons){
		int len = persons.length;
		Person[] result = new Person[len];
		ArrayList<Integer> availIndex = new ArrayList<Integer>();
		for(int i = 0; i < len; i++)
			availIndex.add(i);
		for(int i = 0; i < len; i++){
			int ranking = persons[i].Tvalue;
			int index = availIndex.get(ranking);
			result[index] = persons[i];
			availIndex.remove(ranking);
		}
		return result;
	}
	
	public static void main(String[] args) {
		ReorderByHeightAndTvalue r = new ReorderByHeightAndTvalue();
		Person[] persons = new Person[5];
		Person p1 = new Person(1, 1); persons[0] = p1;
		Person p2 = new Person(2, 3); persons[1] = p2;
		Person p3 = new Person(3, 1); persons[2] = p3;
		Person p4 = new Person(4, 0); persons[3] = p4;
		Person p5 = new Person(5, 0); persons[4] = p5;
		Person[] result = r.reorder(persons);
		for(Person p : result){
			System.out.println(p.height);
		}
	}

}
