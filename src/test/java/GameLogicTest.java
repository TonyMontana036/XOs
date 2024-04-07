import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class GameLogicTest {
    @Test
    @Disabled
    @DisplayName("Переписать тест когда будет БД")
    void successfulStopGameAfter9TurnAndDraw() {
        GameLogic gameLogic = new GameLogic();
        GameSettings newGame = new GameSettings(3);
        Figures currentFigure = Figures.POINT;
        Figures[][] currentGameMap = newGame.getGamePoles();
        GraphicMapXO graphicMapXO = new GraphicMapXO();
        Checks checks = new Checks();
        Scanner scanner = new Scanner("2");

        final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));


        for (int i = 0; i <8; i++){
            newGame.incStepCounter();
        }

        gameLogic.getFigures(newGame, currentFigure, graphicMapXO, currentGameMap, checks, scanner);

        gameLogic.whoWin(currentFigure, checks);

        System.err.print("Ничья");
        assertEquals("Ничья", errContent.toString());
    }

    @Test
    void successfulChangeFigureAfterTurn() {

    }

    @Test
    void tryToPlaceFigureOnOccupiedPlace() {

    }

    @Test
    void tryToPlaceFigureOverTheSquare() {
    }

    @Test
    void tryToPlaceFigureByLetter() {
    }
}
