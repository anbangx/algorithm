package leetcode.data;

public class List {
	
	public int val;
	public List next;
	public List child;
	
	public List(int val){
		this.val = val;
		this.next = null;
		this.child = null;
	}
}
