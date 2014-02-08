package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T>{
    T[] array;
    int counter;
    
    public ArrayIterator(T[] A){
        this.array = A;
        this.counter = 0;
    }
    
    @Override
    public boolean hasNext() {
        return counter < array.length;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        T ans = array[counter];
        counter++;
        return ans;
    }

    @Override
    public void remove() {
        
    }
    
    public static void main(String[] args) {
        Integer [] array = new Integer[] { 1, null, 4, 3, 5 }; 
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(array); 
        while(it.hasNext()){
            System.out.println(it.next());
        } 
    }
}
