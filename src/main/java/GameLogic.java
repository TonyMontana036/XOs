import java.util.Scanner;

public class GameLogic {
    Figures currentFigure = Figures.POINT;
    Checks checks = new Checks();
    GraphicMapXO graphicMapXO = new GraphicMapXO();


    public void gameProcess(GameSettings newGame, Figures[][] currentGameMap, Scanner scanner) {
        graphicMapXO.printMap(currentGameMap);
        PolePoint currentPolePoint;
        boolean isExitGame = false;

        do {
            int num;
            System.out.println("Ход " + newGame.getStepCounter());

            //region Определяем тип фигуры для хода
            currentFigure = figureSwitch(currentFigure);
            //endregion

            //region Считваем ввод для поля
            do {
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    if (num < 1 || num > newGame.getSquare()) {
                        graphicMapXO.printRule(currentFigure, newGame);
                        num = 0;
                    } else if (newGame.getArrayOfSteps().contains(num)) {
                        graphicMapXO.enterFigureIntoRightPolePrinter(currentFigure);
                        graphicMapXO.printMap(currentGameMap);
                        num = 0;
                    } else {
                        newGame.getArrayOfSteps().add(num);
                    }
                } else {
                    graphicMapXO.printRule(currentFigure, newGame);
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
        whoWin(currentFigure, checks);
    }

    private Figures figureSwitch(Figures currentFigure) {
        if (currentFigure == Figures.CROSS) {
            currentFigure = Figures.POINT;
            System.out.println("Ходит " + currentFigure.getNamed());
        } else {
            currentFigure = Figures.CROSS;
            System.out.println("Ходит " + currentFigure.getNamed());
        }
        return currentFigure;
    }

    public void whoWin(Figures currentFigure, Checks checks) {
        if (checks.isWin()) {
            System.out.println("Победитель " + currentFigure.getNamed());
        } else {
            System.out.println("Ничья");
        }
    }
}
