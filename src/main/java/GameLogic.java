import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    Figures currentFigure = Figures.POINT;
    Checks checks = new Checks();
    GraphicMapXO graphicMapXO = new GraphicMapXO();
    PolePoint currentPolePoint;
    boolean isExitGame = false;

    public void gameProcessSolo(GameSettings newGame, Figures[][] currentGameMap) {
        Scanner scanner = new Scanner(System.in);
        graphicMapXO.printMap(currentGameMap);

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
                isExitGame = true;
            }
        } while (!isExitGame);
        whoWin(currentFigure, checks);
        oneMoreTimePrint();
    }

    public void gameProcessVsBot(GameSettings newGame, Figures[][] currentGameMap, boolean isPlayerFirst) {
        Scanner scanner = new Scanner(System.in);
        graphicMapXO.printMap(currentGameMap);
        boolean isPlayerStep = !isPlayerFirst;
        ArrayList<Integer> i;
        i = addIntegers();

        do {
            int num;
            System.out.println("Ход " + newGame.getStepCounter());

            //region Определяем тип фигуры для хода
            currentFigure = figureSwitch(currentFigure);
            //endregion

            //region Определяем
            isPlayerStep = !isPlayerStep;
            //endregion

            if (isPlayerStep) {
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
                            i.remove(Integer.valueOf(num));
                        }
                    } else {
                        graphicMapXO.printRule(currentFigure, newGame);
                        scanner.next();
                        num = 0;
                    }
                } while (num < 1);
                //endregion
            } else {
                num = getRandomFromSteps(i);
                i.remove(Integer.valueOf(num));
                newGame.getArrayOfSteps().add(num);
            }

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
                isExitGame = true;
            }
        } while (!isExitGame);
        whoWin(currentFigure, checks);
        oneMoreTimePrint();
    }

    private void oneMoreTimePrint() {
        System.out.println();
        System.out.println("Еще Раз? Y/N");
        System.out.println();
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

    boolean isExit() {
        String goToExit = "";
        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        while (goToExit.isEmpty()) {
            goToExit = scanner.next();
            if (goToExit.equalsIgnoreCase("Y")) {
                isExit = false;
            } else if (goToExit.equalsIgnoreCase("N")) {
                isExit = true;
            } else {
                goToExit = "";
                oneMoreTimePrint();
            }
        }
        return isExit;
    }

    public void whoWin(Figures currentFigure, Checks checks) {
        if (checks.isWin()) {
            System.out.println("Победитель " + currentFigure.getNamed());
        } else {
            System.out.println("Ничья");
        }
    }

    public static int getRandomFromSteps(ArrayList<Integer> array) {
        int rnd = new Random().nextInt(array.size());
        return array.get(rnd);
    }

    private ArrayList<Integer> addIntegers() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }
}
