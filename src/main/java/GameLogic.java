import java.util.Scanner;

public class GameLogic {
    // boolean exit;
    public Figures getFigures(GameSettings newGame, Figures currentFigure, GraphicMapXO graphicMapXO, Figures[][] currentGameMap, Checks checks, Scanner scanner) {
        PolePoint currentPolePoint;
        boolean isExitGame = false;

        do {
            int num;
            System.out.println("Ход " + newGame.getStepCounter());

            //region Определяем тип фигуры для хода
            if (currentFigure == Figures.CROSS) {
                currentFigure = Figures.POINT;
                System.out.println("Ходит " + currentFigure.getNamed());
            } else {
                currentFigure = Figures.CROSS;
                System.out.println("Ходит " + currentFigure.getNamed());
            }
            //endregion

            //region Считваем ввод для поля
            do {
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    if (num < 1 || num > newGame.getSquare()) {
                        printRule(currentFigure, newGame);
                        num = 0;
                    } else if (newGame.getArray().contains(num)) {
                        enterFigureIntoRightPolePrinter(currentFigure);
                        graphicMapXO.printMap(currentGameMap);
                        num = 0;
                    } else {
                        newGame.getArray().add(num);
                    }
                } else {
                    printRule(currentFigure, newGame);
                    scanner.next();
                    num = 0;
                }
            } while (num < 1);
            //endregion

            currentPolePoint = new PolePoint(num);
            newGame.addFigureIntoPole(currentPolePoint, currentFigure);
            graphicMapXO.printMap(currentGameMap);

            //region Проверяем наступление победы
            if (newGame.getStepCounter() > 4) {
                checks.check(currentPolePoint, currentGameMap);
            }
            //endregion

            newGame.incStepCounter();

            if (checks.isWin() || !(newGame.getStepCounter() < newGame.getSquare() + 1)) {
                //|| checks.forceDraw.isEmpty()
                isExitGame = true;
            }
        } while (!isExitGame);
        return currentFigure;
    }

    private void enterFigureIntoRightPolePrinter(Figures currentFigure) {
        System.out.println();
        System.out.println("Укажите свободное поле для ввода " + currentFigure.getNamed() + "а");
        System.out.println();
    }

    private void printRule(Figures currentFigure, GameSettings newGame) {
        System.out.println("Введите номер поля для " + currentFigure.getNamed() + "а : 1 - " + newGame.getSquare());
    }

    public void whoWin(Figures currentFigure, Checks checks) {
        if (checks.isWin()) {
            System.out.println("Победитель " + currentFigure.getNamed());
        } else {
            System.out.println("Ничья");
        }
    }
}
