package content;

import java.util.List;

public class CalculateCenter {
    public static class innerCalculateCent {
        public static Point centerOfMass(List<Point> belongList) {

            double sumX = 0;
            double sumY = 0;

            for (Point point : belongList) {
                sumX += point.getX();
                sumY += point.getY();
            }

            double arithmeticX = sumX / belongList.size();
            double arithmeticY = sumY / belongList.size();

            return new Point(arithmeticX, arithmeticY);
        }
    }
}
