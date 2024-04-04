import java.util.Scanner;

public class Aplication {

    /**
     * [x]Ничья
     * []Юнит тесты
     * []Перезапуск игры
     * []Выбор одного игрока или 2х
     * []Узнать как делать консольное приложение
     */

    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        Checks checks = new Checks();
        Scanner scanner = new Scanner(System.in);

        GameSettings newGame = new GameSettings(3);
        Figures[][] currentGameMap = newGame.getGamePoles();
        Figures currentFigure = Figures.POINT;
        MapXO mapXO = new MapXO();
        mapXO.printMap(currentGameMap);


        currentFigure = gameLogic.getFigures(newGame, currentFigure, mapXO, currentGameMap, checks, scanner);
        gameLogic.whoWin(currentFigure, checks);

        scanner.close();
    }
}