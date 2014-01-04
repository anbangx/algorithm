package leetcode;
import java.util.ArrayList;


public class MergeKSortedList {
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(lists == null || lists.size() == 0)
            return null;
        if(lists.size() == 1)
            return lists.get(0);
        
        ArrayList<ListNode> newLists = new ArrayList<ListNode>();
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null){
                newLists.add(lists.get(i));
            }
        }
        if(newLists.isEmpty())
            return null;
        int max = 0;
        int index = 0;
        for(int i = 0; i < newLists.size(); i++){
            if(max < newLists.get(i).val){
                max = newLists.get(i).val;
                index = i;
            }
        }
        ListNode head = newLists.get(index);
        newLists.set(index, newLists.get(index).next);
        head.next = mergeKLists(newLists);
        
        return head;
    }
    
}
