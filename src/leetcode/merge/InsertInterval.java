package leetcode.merge;

import java.util.ArrayList;

import leetcode.data.Interval;

public class InsertInterval {
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> results = new ArrayList<Interval>();
        results.add(newInterval);
        for(int i = 0; i < intervals.size(); i++){
            Interval cur = results.get(results.size() - 1);
            results.remove(results.size() - 1);
            if(cur.start > intervals.get(i).end){
                results.add(intervals.get(i));
                results.add(cur);
            } else if(cur.end < intervals.get(i).start){
                results.add(cur);
                results.add(intervals.get(i));
            } else{
                int start = cur.start < intervals.get(i).start ? cur.start : intervals.get(i).start;
                int end = cur.end > intervals.get(i).end ? cur.end : intervals.get(i).end;
                results.add(new Interval(start, end));
            }
        }
        return results;
    }
    
}
