public class GameService {

    /**
     * [x]Ничья
     * []Юнит тесты
     * []Перезапуск игры
     * []Выбор одного игрока или 2х
     * []Узнать как делать консольное приложение
     */

    public static void main(String[] args) {
        Checks checks = new Checks();
        PolePoint currentPolePoint;

        GameSettings newGame = new GameSettings(3);
        Figures[][] currentGameMap = newGame.getGamePoles();
        Figures currentFigure = Figures.POINT;
        MapXO mapXO = new MapXO();

        mapXO.printMap(currentGameMap);

        do {
            int num;
            System.out.println("Ход " + newGame.getStepCounter());

            //Определяем тип фигуры для хода
            if (currentFigure == Figures.CROSS) {
                currentFigure = Figures.POINT;
                System.out.println("Ходит " + currentFigure.getNamed());
            } else {
                currentFigure = Figures.CROSS;
                System.out.println("Ходит " + currentFigure.getNamed());
            }

            //Считваем ввод для поля
            //  System.out.println("Укажите поле для " + currentFigure.getNamed() + "а");
            do {
                if (newGame.getIn().hasNextInt()) {
                    num = newGame.getIn().nextInt();
                    if (num < 1 || num > 9) {
                        System.out.println("Введите номер поля для " + currentFigure.getNamed() + "а : 1 - 9");
                        num = 0;
                    } else if (newGame.getArray().contains(num)) {
                        System.out.println();
                        System.out.println("Укажите свободное поле для ввода " + currentFigure.getNamed() + "а");
                        System.out.println();
                        mapXO.printMap(currentGameMap);
                        num = 0;
                    } else {
                        newGame.getArray().add(num);
                    }
                } else {
                    System.out.println("Введите номер поля для " + currentFigure.getNamed() + "а : 1 - 9");
                    newGame.getIn().next();
                    num = 0;
                }
            } while (num < 1);

            currentPolePoint = new PolePoint(num);
            newGame.addFigureIntoPole(currentPolePoint, currentFigure);
            mapXO.printMap(currentGameMap);

            //Проверяем наступление победы
            if (newGame.getStepCounter() > 4) {
                checks.check(currentPolePoint, currentGameMap);
            }

            newGame.incStepCounter();
        } while ((!checks.isWin()) && (newGame.getStepCounter() < 10));

        if (checks.isWin()) {
            System.out.println("Победитель " + currentFigure.getNamed());
        } else {
            System.out.println("Ничья");
        }
    }
}
