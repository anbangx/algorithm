package leetcode;
import java.util.ArrayList;


public class MergeInterval {
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> results = new ArrayList<Interval>();
        if(intervals.size() == 0)
            return results;
        ArrayList<Interval> preResults = null;
        for(int i = 0; i < intervals.size(); i++){
            preResults = results;
            insert(preResults, intervals.get(i), results);
        }
        return results;
    }
    
    public void insert(ArrayList<Interval> intervals, Interval newInterval, ArrayList<Interval> results) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
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
    }
    
    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
    }

}
