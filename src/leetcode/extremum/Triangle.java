package leetcode.extremum;
import java.util.ArrayList;

public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (triangle == null || triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int numRows = triangle.size();
        for (int i = numRows - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = triangle.get(i).get(j);
                min += triangle.get(i + 1).get(j) < triangle.get(i + 1).get(j + 1) ? triangle.get(i + 1).get(j)
                        : triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }

}
