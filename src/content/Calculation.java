package content;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Calculation {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static class InsideClass {
        public static List getCalculatedList(List<Point> points, double radius, Point newCenterPoint) {

            List<Point> belongList = new ArrayList<>();

            for (Point point : points) {
                if (Math.sqrt(Math.pow(point.getX() - newCenterPoint.getX(), 2) +
                        Math.pow(point.getY() - newCenterPoint.getY(), 2))
                        <= radius) {

                    belongList.add(new Point(point.getX(), point.getY()));
                }
            }
            return belongList;
        }

        public static void printPoints(ArrayList<Point> points, String fileNameInputImg, String fileNameOutImg) {

            Mat img = Imgcodecs.imread(fileNameInputImg);

            if (img.empty()) {
                System.out.println("Не удалось загрузить изображение");
            }
            for (Point point : points) {
                Imgproc.ellipse(img, new org.opencv.core.Point(
                                point.getX() + 500, 500 - point.getY()), new Size(3, 3),
                        0, 0, 360, new Scalar(50, 50, 50), Core.FILLED);
            }

            boolean st = Imgcodecs.imwrite(fileNameOutImg, img);
            if (!st) {
                System.out.println("Не удалось сохранить изображение");
            }
        }

        public static void getAnswerJpg(List answer, String fileNameInputImg, String fileNameOutImg) {
            Mat outJpg = Imgcodecs.imread(fileNameInputImg);
            if (outJpg.empty()) {
                System.out.println("Не удалось загрузить изображение");
                return;
            }

            int count = 1;
            for (List<Point> pointList : (Iterable<List<Point>>) answer) {
                Iterator<Point> siter = pointList.iterator();
                System.out.println("Кластер № " + count);

                count++;
                double firstColor = Math.random() * 450;
                double secondColor = Math.random() * 500;
                double thirdColor = Math.random() * 320;

                while (siter.hasNext()) {
                    Point p = siter.next();
                    Imgproc.ellipse(outJpg, new org.opencv.core.Point(
                                    p.getX() + 500, 500 - p.getY()), new Size(3, 3),
                            0, 0, 360, new Scalar(firstColor, secondColor, thirdColor), Core.FILLED);
                    System.out.println(p);
                }
            }
            boolean jpgAnswer = Imgcodecs.imwrite(fileNameOutImg, outJpg);
            if (!jpgAnswer) {
                System.out.println("Не удалось сохранить изображение");
            }
        }
    }
}
