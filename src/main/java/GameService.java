public class GameService {

    /**
     * [x]Переменная для ходов
     * [x]Запускать проверку победы после 5го хода
     * [x]Проверять победу только для линий в которых установлен знак
     * []Ходить по очереди автоматически
     * []включить Гит
     * []Нарисовать карту
     * []Заполнить карту
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

        GameSettings newGame = new GameSettings(3);
        Figures[][] currentGamePole = newGame.getGamePole();

        int step = Integer.parseInt("3");

        PolePoint s = new PolePoint(step);

        Figures currentFigure = Figures.CROSS;

        newGame.addFigureIntoPole(new PolePoint(1), currentFigure);
        newGame.addFigureIntoPole(new PolePoint(2), currentFigure);
        newGame.addFigureIntoPole(s, currentFigure);

        newGame.setStepCounter(4);
        newGame.incStepCounter();

        while (newGame.getStepCounter() > 4) {
            checks.check(s, currentFigure, currentGamePole);
            if (checks.isWin) {
                break;
            }

            newGame.incStepCounter();
        }

        System.out.println("Победитель " + currentFigure.name());

    }
}
