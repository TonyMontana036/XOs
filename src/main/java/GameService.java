import java.sql.SQLOutput;

public class GameService {

    /**
     * [x]Переменная для ходов
     * [x]Запускать проверку победы после 5го хода
     * [x]Проверять победу только для линий в которых установлен знак
     * [x]Ходить по очереди автоматически
     * [x]включить Гит
     * [x]Нарисовать карту
     * [x]Заполнить карту
     * []Юнит тесты
     * []Перезапуск игры
     * []Выбор одного игрока или 2х
     * [x]Проверка по линии
     * [x]проверка по столбику
     * [x]проверка по диагонали — вниз влево инкремент (вниз вправо инкремент)
     * [x]Подумать над конструктором в Game что бы размер карты передавать
     */

    public static void main(String[] args) {
        Checks checks = new Checks();
        PolePoint currentPolePoint;

        GameSettings newGame = new GameSettings(3);
        Figures[][] currentGameMap = newGame.getGamePoles();
        Figures currentFigure = Figures.POINT;

        MapXO x = new MapXO();

//        currentGameMap[0][0] =  Figures.CROSS;
//        currentGameMap[1][1] =  Figures.CROSS;
//        currentGameMap[2][2] =  Figures.CROSS;
//        currentGameMap[0][1] =  Figures.POINT;
//        currentGameMap[0][2] =  Figures.POINT;
//        currentGameMap[2][1] =  Figures.POINT;

        x.printMap(currentGameMap);
        x.printMap(currentGameMap);
        x.printMap(currentGameMap);
//        Scanner in = new Scanner(System.in);
//        System.out.println("Введите чистло число");
//        int num = in.nextInt();
//        System.out.println(in);
//        in.close();

        //вывод теста Укажите поле для символа
        //ввод поля
        //проверка что поле пустое
        //передаем поле

        int i = 3;

        do {
            System.out.println("Ход " + newGame.getStepCounter());

            if (currentFigure == Figures.CROSS) {
                currentFigure = Figures.POINT;
                System.out.println("Ходит " + currentFigure.getNamed());
            } else {
                currentFigure = Figures.CROSS;
                System.out.println("Ходит " + currentFigure.getNamed());
            }


            currentPolePoint = new PolePoint(i);
            newGame.addFigureIntoPole(currentPolePoint, currentFigure);

            if (newGame.getStepCounter() > 4) {
                checks.isWin = true;
            } else {

            }
            newGame.incStepCounter();
        } while (!checks.isWin);

        System.out.println("Победитель " + currentFigure.getNamed());
    }
}
