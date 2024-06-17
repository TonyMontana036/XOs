public class Application {

    /**
     * []Юнит тесты
     * []Перезапуск игры
     * []Выбор одного игрока или 2х
     * []Узнать как делать консольное приложение
     */

    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();

        GameSettings newGame = new GameSettings(3);
        Figures[][] currentGameMap = newGame.getGamePoles();

        gameLogic.gameProcess(newGame, currentGameMap);
    }
}