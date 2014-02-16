package GeekForGeek.LinkedList.Merge;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.data.List;

public class FlattenMultiLevelLinkedList {
	
	/**
	 * Flatten a multilevel linked list
	 */

	public void flattenMultilevelLinkedList(List head){
	    if(head == null)
	        return;
	    
	    Queue<List> q = new LinkedList<List>();
	    q.add(head);
	    while(!q.isEmpty()){
	        List cur = q.poll();
        	System.out.println(cur.val);
	        while(cur != null){
	            if(cur.child != null)
	                q.add(cur.child);
	            cur.child = null;
	            cur = cur.next;
	            if(cur != null)
	            	System.out.println(cur.val);
	        }
	    }
	}
	
	public static void main(String[] args) {
		List l11 = new List(10);
		List l12 = new List(5);
		List l13 = new List(12);
		List l14 = new List(7);
		List l15 = new List(11);
		l11.next = l12; l12.next = l13; l13.next = l14; l14.next = l15;
		List l21 = new List(4);
		List l22 = new List(20);
		List l23 = new List(13);
		List l24 = new List(17);
		List l25 = new List(6);
		l21.next = l22; l22.next = l23; l24.next =l25;
		List l32 = new List(2);
		List l33 = new List(16);
		List l34 = new List(9);
		List l35 = new List(8);
		l34.next = l35;
		List l43 = new List(3);
		List l44 = new List(19);
		List l45 = new List(15);
		l44.next = l45;
		l11.child = l21;
		l14.child = l24;
		l22.child = l32;
		l23.child = l33;
		l24.child = l34;
		l33.child = l43;
		l34.child = l44;
		FlattenMultiLevelLinkedList fll = new FlattenMultiLevelLinkedList();
		fll.flattenMultilevelLinkedList(l11);
	}
}
