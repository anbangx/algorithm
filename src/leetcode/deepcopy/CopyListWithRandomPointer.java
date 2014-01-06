package leetcode.deepcopy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import leetcode.data.RandomListNode;


public class CopyListWithRandomPointer {
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        LinkedList<RandomListNode> queue = new LinkedList<RandomListNode>();
        queue.add(head);
        RandomListNode cloneHead = new RandomListNode(head.label);
        // map helps memorize the relative position of the random node to the current node
        Map<RandomListNode, RandomListNode> real2Clone = new HashMap<RandomListNode, RandomListNode>();
        real2Clone.put(head, cloneHead);
        
        Set<RandomListNode> visited = new HashSet<RandomListNode>();
        while(!queue.isEmpty()){
            RandomListNode cur = queue.removeFirst();
            if(visited.contains(cur))
                continue;
            // copy self
            RandomListNode clone;
            if(real2Clone.containsKey(cur))
                clone = real2Clone.get(cur);
            else{
                clone = new RandomListNode(cur.label);
                real2Clone.put(cur, clone);
            }
            // copy next
            if(cur.next != null){
                RandomListNode cloneNext;
                if(real2Clone.containsKey(cur.next))
                    cloneNext = real2Clone.get(cur.next);
                else{
                    cloneNext = new RandomListNode(cur.next.label);
                    real2Clone.put(cur.next, cloneNext);
                }
                clone.next = cloneNext;
                queue.add(cur.next);
            }
            // copy random
            if(cur.random != null){
                RandomListNode cloneRandom;
                if(real2Clone.containsKey(cur.random))
                    cloneRandom = real2Clone.get(cur.random);
                else{
                    cloneRandom = new RandomListNode(cur.random.label);
                    real2Clone.put(cur.random, cloneRandom);
                }
                clone.random = cloneRandom;
                queue.add(cur.random);
            }
            visited.add(cur);
        }
        return cloneHead;
    }
    
    public static void main(String[] args) {
        CopyListWithRandomPointer cl = new CopyListWithRandomPointer();
        RandomListNode a = new RandomListNode(-1);
        RandomListNode b = new RandomListNode(-1);
        a.next = b;
        a.random = b;
        b.random = a;
        System.out.println(cl.copyRandomList(a));
    }

}
