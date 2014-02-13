package GeekForGeek.whiteboard.array;

import java.util.ArrayList;

import leetcode.data.Interval;

public class InsertInterval {
	
	public Interval insertInterval(ArrayList<Interval> intervals, Interval insert){
		for(int i = 0; i < intervals.size(); i++){
			Interval cur = intervals.get(i);
			if(insert.start > cur.end)
				continue;
			if(insert.end < cur.start)
				break;
			// merge two cur and insert
			int min = insert.start < cur.start ? insert.start : cur.start;
			int max = insert.end > cur.end ? insert.end : cur.end;
			insert.start = min;
			insert.end = max;
		}
		return insert;
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		Interval iv1 = new Interval(1, 3);
		Interval iv2 = new Interval(6, 9);
		intervals.add(iv1);
		intervals.add(iv2);
		Interval insert = new Interval(2, 5);
		InsertInterval ii = new InsertInterval();
		Interval result = ii.insertInterval(intervals, insert);
		System.out.println(result.start + " - " + result.end);
	}

}
