package Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class LinkedListIterator2 implements Iterator{
    
    Iterator curIt;
    Stack<Iterator> stack;
    
    public LinkedListIterator2(LinkedList list){
        curIt = list.iterator();
        stack = new Stack<Iterator>();
    }
    
    @Override
    public boolean hasNext() {
        if(curIt.hasNext())
            return true;
        if(stack.isEmpty())
            return false;
        curIt = stack.pop();
        return hasNext();
    }

    @Override
    public Object next() {
        if(!hasNext())
            throw new NoSuchElementException();
        Object next = curIt.next();
        if(next instanceof Iterable){
            stack.push(((Iterable) next).iterator());
            return next();
        } else{ 
            return next;
        }
    }

    @Override
    public void remove() {
        
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        LinkedList subList = new LinkedList();
        subList.add(2);
        subList.add(3);
        subList.add(4);
        LinkedList subsubList = new LinkedList();
        subsubList.add(5);
        subsubList.add(6);
        subList.add(subsubList);
        list.add(subList);
        list.add(7);
        list.add(8);
        System.out.println(list);
        LinkedListIterator2 it = new LinkedListIterator2(list);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
