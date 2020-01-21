import content.*;
import org.opencv.core.Core;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {

        double r = 50; // радиус поиска

        Files file = new Files();

        List<Point> points = ReadFileByLine.wrapperReadFileByLine.readMyFile(file.getInputTxt2()); // чтение координат точек из файла (выборки),преобразование их в объекты Point и запись в список.

        //Calculation.InsideClass.printPoints((ArrayList<Point>) points, file.getImtTest(), file.getOutJpg2()); // рисует точки из выборки на изображении с белоым фоном и размером 1000x1000 px

        List answer = new ArrayList<>();

        while (points.size() != 0) {

            List calculatedList = Calculation.InsideClass.getCalculatedList(points, r, points.get(0));

            Point prevMass = CalculateCenter.innerCalculateCent.centerOfMass(calculatedList);

            Point currentMass;

            while (true) {
                List calculatedList1 = Calculation.InsideClass.getCalculatedList(points, r, prevMass);
                currentMass = prevMass;
                if (currentMass.getX() == prevMass.getX() && currentMass.getY() == prevMass.getY()) {
                    for (int i = 0; i < points.size(); i++) {
                        for (Object o : calculatedList1) {
                            if (points.get(i).equals(o)) {
                                points.remove(i);
                            }
                        }
                    }
                    answer.add(new ArrayList<Point>(calculatedList1));
                }
                break;
            }
        }

        Calculation.InsideClass.getAnswerJpg(answer, file.getOutJpg2(), file.getAnswerJpg2());
    }
}



