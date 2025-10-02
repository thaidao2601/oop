import java.util.*;

/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class Shape {
    private List<Point> points;
    public Shape(String data) {
        points = new ArrayList<>();
        String[] tokens = data.trim().split("\\s+");
        for (int i = 0; i < tokens.length; i += 2) {
            double x = Double.parseDouble(tokens[i]);
            double y = Double.parseDouble(tokens[i+1]);
            points.add(new Point(x, y));
        }
    }
}

