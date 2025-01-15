public class Application {

    /**
     * []Юнит тесты
     * [x]Перезапуск игры
     * [x]Выбор одного игрока или 2х
     * []Узнать как делать консольное приложение
     * []Форсированный конец?
     */

    public static void main(String[] args) {
        boolean isExit;
        boolean isFirst = false;
        do {
            GameLogic gameLogic = new GameLogic();

            GameSettings newGame = new GameSettings(3);
            Figures[][] currentGameMap = newGame.getGamePoles();

            //gameLogic.gameProcessSolo(newGame, currentGameMap);

            gameLogic.gameProcessVsBot(newGame, currentGameMap, isFirst);

            isExit = gameLogic.isExit();
        } while (!isExit);
    }
}