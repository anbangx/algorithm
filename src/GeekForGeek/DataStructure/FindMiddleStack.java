package GeekForGeek.DataStructure;

import leetcode.data.DoublyListNode;

public class FindMiddleStack {
	
	/**
	 * Design a stack with operations on middle element
	 */

    DoublyListNode head = null;
    DoublyListNode middle = null;
    int count = 0;
    
    public void push(int val){
        DoublyListNode newNode = new DoublyListNode(val);
        if(head == null)
            head = newNode;
        else{
            head.next = newNode;
            newNode.pre = head;
            head = newNode;
        }
        count++;
        updateMiddlePoint();
    }
    
    public int pop(){
        if(count == 0)
            return -1;
        int ans = head.val;
        head.pre.next = null;
        head = head.pre;
        count--;
        updateMiddlePoint();
        return ans;
    }
    
    public void updateMiddlePoint(){
        if((count & 1) == 1){
            if(middle == null)
                middle = head;
            else
                middle = middle.next;
        }
    }
    
    public int findMiddle(){
        if(count == 0)
            return -1;
        return middle.val;
    }
    
    public boolean deleteMiddle(){
        if(count == 0)
            return false;
        middle.pre.next = middle.next;
        middle = middle.pre;
        return true;
    }
    
	public static void main(String[] args) {
		FindMiddleStack stack = new FindMiddleStack();
		stack.push(1);
		System.out.println(stack.findMiddle());
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.findMiddle());
		stack.push(8);
		System.out.println(stack.findMiddle());
		stack.deleteMiddle();
		System.out.println(stack.findMiddle());
	}

}
