package content;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadFileByLine {

    public static class wrapperReadFileByLine {


        public static List readMyFile(String path) {

            ArrayList<Point> points = new ArrayList<>();

            try {
                File file = new File(path);

                FileReader fileReader = new FileReader(file);

                BufferedReader reader = new BufferedReader(fileReader);

                String line = reader.readLine();

                while (line != null) {

                    String[] parts = line.split(",");

                    double x = Double.parseDouble(parts[0]);
                    double y = Double.parseDouble(parts[1]);

                    points.add(new Point(x, y));

                    line = reader.readLine();

                }
            } catch (IOException e) {
                System.out.println("Файл с координатами должен быть оформлен правильно, пожалуйста, воспользуйтесь документацией.");
            }

            return points;
        }
    }
}
