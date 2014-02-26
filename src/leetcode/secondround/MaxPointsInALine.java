package leetcode.secondround;

import java.util.HashMap;

public class MaxPointsInALine {
	
	
	public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)    return 0;
        if(points.length <= 2)  return points.length;
        
        int max = 0;        
        int len = points.length;
        for(int i = 0; i < len; i++){
            HashMap<Double, Integer> hM = new HashMap<Double, Integer>();
            int numOfSamePoints = 0;
            for(int j = i + 1; j < len; j++){
                double slope = 0.0;
                if(points[j].x == points[i].x && points[j].y == points[i].y){
                    numOfSamePoints++;
                    continue;
                }
                if(points[j].x == points[i].x){
                    slope = Double.MAX_VALUE;
                }else{
                    slope = (double)(points[j].y - points[i].y)/(points[j].x - points[i].x);
                }
                int count = 0;
                if(slope == 0.0)	slope = 0.0;
                if(hM.containsKey(slope)){
                    count = hM.get(slope);
                    count++;
                    hM.put(slope, count);
                } else{
                    count = 2;
                    hM.put(slope, count);
                }
            }
            max = numOfSamePoints + 1 > max ? (numOfSamePoints + 1) : max;
            for(Integer count : hM.values()){
                count += numOfSamePoints;
                max = count > max ? count : max;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		MaxPointsInALine mp = new MaxPointsInALine();
		Point[] points = new Point[3];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 1);
		points[2] = new Point(1, 1);
		System.out.println(mp.maxPoints(points));
	}

}
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    public Point(int a, int b) { x = a; y = b; }
}
