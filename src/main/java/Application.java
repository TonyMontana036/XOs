import java.util.Scanner;

public class Application {

    /**
     * []Юнит тесты
     * [x]Перезапуск игры
     * []Выбор одного игрока или 2х
     * []Узнать как делать консольное приложение
     * []Форсированный конец?
     */

    public static void main(String[] args) {
        boolean isExit = false;

        do {
            String goToExit = null;
            GameLogic gameLogic = new GameLogic();

            GameSettings newGame = new GameSettings(3);
            Figures[][] currentGameMap = newGame.getGamePoles();

            gameLogic.gameProcess(newGame, currentGameMap);

            Scanner scanner = new Scanner(System.in);
            while (goToExit == null) {
                goToExit = scanner.next();
                if (goToExit.equals("Y") || goToExit.equals("y")) {
                    isExit = false;
                } else if (goToExit.equals("N") || goToExit.equals("n")) {
                    isExit = true;
                } else {
                    goToExit = null;
                    System.out.println();
                    System.out.println("Y/N");
                    System.out.println();
                }
            }
        } while (!isExit);
    }
}