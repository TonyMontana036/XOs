public class GameSettings {

    private int stepCounter;

    private final Figures[][] gamePole;

    public Figures[][] getGamePole() {
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


    public void setStepCounter(int stepCounter) {
        this.stepCounter = stepCounter;
    }

    public void incStepCounter() {
        stepCounter++;
    }
}
