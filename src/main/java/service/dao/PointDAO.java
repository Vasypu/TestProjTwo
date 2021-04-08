package service.dao;

import org.springframework.stereotype.Component;
import service.models.Point;
import java.util.ArrayList;
import java.util.List;

@Component
public class PointDAO {

    private static int POINTS_COUNT;
    private List<Point> points;

    {
        points = new ArrayList<>();

        points.add(new Point(++POINTS_COUNT, "Tom", "Some1"));
        points.add(new Point(++POINTS_COUNT, "Bob", "Some2"));
        points.add(new Point(++POINTS_COUNT, "Mike", "Some3"));
        points.add(new Point(++POINTS_COUNT, "Katy", "Some4"));
    }

    public List<Point> index() {
        return points;
    }

    public Point show(int id) {
        return points.stream().filter(point -> point.getId() == id).findAny().orElse(null);
    }
}
