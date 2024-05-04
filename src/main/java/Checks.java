import java.io.OptionalDataException;
import java.util.ArrayList;

public class Checks {
   // public ArrayList<> forceDraw;
    private boolean isWin;

    public boolean isWin() {
        return isWin;
    }

    private Figures[][] checkedPole;

    void check(PolePoint polePoint, Figures[][] gameMap) {
        isWin = false;
        checkedPole = gameMap;
        int checkedlPole = polePoint.getlPole();
        int checkedwPole = polePoint.getwPole();

        checksByPole(polePoint.getConvertedPole(), checkedlPole, checkedwPole);
    }

    private void checksByPole(int poleNumber, int lPole, int wPole) {
        switch (poleNumber) {
            case 1, 9: {
                lineCheck(lPole);
                columnCheck(wPole);
                rightCrossCheck();
            }
            break;
            case 2, 4, 6, 8: {
                lineCheck(lPole);
                columnCheck(wPole);
            }
            break;
            case 3, 7: {
                lineCheck(lPole);
                columnCheck(wPole);
                leftCrossCheck();
            }
            case 5: {
                lineCheck(lPole);
                columnCheck(wPole);
                rightCrossCheck();
                leftCrossCheck();
            }
            default:
                break;
        }

    }

    private void rightCrossCheck() {
        Figures p1 = checkedPole[0][0];
        Figures p2 = checkedPole[1][1];
        Figures p3 = checkedPole[2][2];

        compareFigures(p1, p2, p3);
    }

    private void leftCrossCheck() {
        Figures p1 = checkedPole[0][2];
        Figures p2 = checkedPole[1][1];
        Figures p3 = checkedPole[2][0];

        compareFigures(p1, p2, p3);
    }

    private void columnCheck(int i) {
        Figures p1 = checkedPole[0][i];
        Figures p2 = checkedPole[1][i];
        Figures p3 = checkedPole[2][i];

        compareFigures(p1, p2, p3);
    }

    private void lineCheck(int i) {
        Figures p1 = checkedPole[i][0];
        Figures p2 = checkedPole[i][1];
        Figures p3 = checkedPole[i][2];

        compareFigures(p1, p2, p3);
    }

    private void compareFigures(Figures p1, Figures p2, Figures p3) {
        if (p1 != null && p2 != null && p3 != null) {
            if (p1.equals(p2) && p1.equals(p3)) {
                isWin = true;
            }
        }
    }
}
