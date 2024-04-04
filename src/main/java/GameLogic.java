import java.util.Scanner;

public class GameLogic {
    boolean exit;
    public Figures getFigures(GameSettings newGame, Figures currentFigure, MapXO mapXO, Figures[][] currentGameMap, Checks checks, Scanner scanner) {
        PolePoint currentPolePoint;

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
            do {
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
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
                    scanner.next();
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
        return currentFigure;
    }

    public void whoWin(Figures currentFigure, Checks checks){
        if (checks.isWin()) {
            System.out.println("Победитель " + currentFigure.getNamed());
        } else {
            System.out.println("Ничья");
        }
        exit = true;
    }
}