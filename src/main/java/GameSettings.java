import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSettings {

    private int stepCounter = 1;

    private final Figures[][] gamePole;

    private final List<Integer> array = new ArrayList<>();

    public List<Integer> getArray() {
        return array;
    }

    public Figures[][] getGamePoles() {
        return gamePole;
    }

    public GameSettings(int lengthWidthPole) {
        gamePole = new Figures[lengthWidthPole][lengthWidthPole];
    }

    public void addFigureIntoPole(PolePoint polePoint, Figures figure) {
        gamePole[polePoint.getlPole()][polePoint.getwPole()] = figure;
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public void incStepCounter() {
        stepCounter++;
    }
}
