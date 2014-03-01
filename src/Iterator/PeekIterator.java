package Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PeekIterator<T> implements Iterator<T>{
    
    Iterator<T> iter;
    T nextItem;
    
    public PeekIterator(Iterator<T> iter){
        this.iter = iter;
        this.nextItem = null;
    }
    
    @Override
    public boolean hasNext() {
        if(nextItem != null)
            return true;
        
        if(iter.hasNext()){
            nextItem = iter.next();
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        T ans = nextItem;
        nextItem = null;
        return ans;
    }
    
    public T peek(){
        if(!hasNext())
            throw new NoSuchElementException();
        return nextItem;
    }
    
    @Override
    public void remove() {
    }
    
    public static void main(String[] args) {
        Integer[] array = new Integer[] { 1, 2, 3, 4, 5 };
        List<Integer> list= Arrays.asList(array);
        PeekIterator<Integer> it = new PeekIterator<Integer>(list.iterator());
        while(it.hasNext()){
            System.out.print("peek: " + it.peek() + "\t");
            System.out.print("peek: " + it.peek() + "\t");
            System.out.println("pop: " + it.next());
        }
    }
}
