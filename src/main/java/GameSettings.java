import java.util.ArrayList;
import java.util.List;

public class GameSettings {

    private int stepCounter = 1;

    private final Figures[][] gamePole;

    private final List<Integer> arrayOfSteps = new ArrayList<>();

    private int square;

    public List<Integer> getArrayOfSteps() {
        return arrayOfSteps;
    }

    public int getSquare() {
        return square;
    }

    public Figures[][] getGamePoles() {
        return gamePole;
    }

    public GameSettings(int lengthWidthPole) {
        gamePole = new Figures[lengthWidthPole][lengthWidthPole];
        square = lengthWidthPole * lengthWidthPole;
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
