package content;

public class Files {

    public String getImtTest() {
        // 1000x1000 px белый фон
        return "imgTest.jpg";
    }

    public String getInputTxt() {
        // координаты точек для записи в список вариант №1
        return "input.txt";
    }

    public String getInputTxt2() {
        // координаты точек для записи в список вариант №2
        return "input2.txt";
    }

    public String getOutJpg() {
        // первый вариант точек из input.txt для answer.jpg
        return "out.jpg";
    }

    public String getOutJpg2() {
        // второй вариант точек из input2.txt для answer2.jpg
        return "out2.jpg";
    }

    public String getAnswerJpg() {
        // готовый jpg с кластерами разных цветов вариант №1
        return "answer.jpg";
    }

    public String getAnswerJpg2() {
        // готовый jpg с кластерами разных цветов вариант №2
        return "answer2.jpg";
    }
}
