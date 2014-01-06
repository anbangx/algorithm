package leetcode.extremum;
import java.util.ArrayList;
import java.util.HashMap;

import leetcode.data.Point;

public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        // base case
        if (points == null || points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;
        // generate map - <gradient, points>
        int globalMax = 0;
        for (int n = 0; n < points.length; n++) {
            Point start = points[n];
            HashMap<Double, ArrayList<Point>> map = new HashMap<Double, ArrayList<Point>>();
            int addition = 0;
            for (int i = n + 1; i < points.length; i++) {
                Point p = points[i];
                if(start.x == p.x && start.y == p.y){
                    addition++;
                    continue;
                }
                double gradient = (start.x == p.x) ? Double.MAX_VALUE : (start.y - p.y) * 1.0 / (start.x - p.x);
                if(gradient == -0.0)
                    gradient = 0.0; 
                ArrayList<Point> list = null;
                if (map.containsKey(gradient))
                    list = map.get(gradient);
                else {
                    list = new ArrayList<Point>();
                    map.put(gradient, list);
                }
                list.add(p);
            }

            // get max number of points that lie on the same straight line
            int max = 0;
            for (Double key : map.keySet()) {
                int size = map.get(key).size();
                if (max < size)
                    max = size;
            }
            if (globalMax < max + addition + 1)
                globalMax = max + addition + 1;
        }
        return globalMax;
    }

    public static void main(String[] args) {
        MaxPointsOnALine mp = new MaxPointsOnALine();
//        Point p1 = new Point(2, 1);
//        Point p11 = new Point(2, 1);
//        Point p12 = new Point(2, 1);
//        Point p13 = new Point(2, 1);
//        Point p14= new Point(2, 1);
//        Point p15 = new Point(2, 1);
//        Point p16 = new Point(2, 1);
//        Point p2 = new Point(4, 2);
//        Point p3 = new Point(3, 3);
//        Point p4 = new Point(4, 4);
//        Point p5 = new Point(5, 5);
//        Point p6 = new Point(6, 6);
//        Point p7 = new Point(0, 0);
//        Point p8 = new Point(0, 0);
//        Point p9 = new Point(0, -8);
//        Point p10 = new Point(0, -7);
//        Point p20 = new Point(0, -9);
//        Point p30 = new Point(0, -10);
        // (-4,-4),(-8,-582),(-3,3),(-9,-651),(9,591)
        // (0,-12),(5,2),(2,5),(0,-5),(1,5),(2,-2),(5,-4),(3,4),(-2,4),(-1,4),(0,-5),(0,-8),(-2,-1),(0,-11),(0,-9)
//        Point[] points = { new Point(0,-12), 
//                new Point(5,2),
//                new Point(2,5),
//                new Point(0,-5),
//                new Point(1,5),
//                new Point(2,-2),
//                new Point(5,-4),
//                new Point(3,4),
//                new Point(-2,4),
//                new Point(-1,4),
//                new Point(0,-5),
//                new Point(0,-8),
//                new Point(-2,-1),
//                new Point(0, -11),
//                new Point(0, 9)};
        Point[] points = { new Point(2,3), 
                new Point(3,3),
                new Point(-5,3)};
        System.out.println(mp.maxPoints(points));
    }

}
