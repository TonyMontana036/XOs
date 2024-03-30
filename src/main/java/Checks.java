import java.lang.reflect.Array;

public class Checks {
    boolean isWin;
    Figures[][] checkedPole;
    int checkedlPole;
    int checkedwPole;

    void check(PolePoint polePoint, Figures figures, Figures[][] gameMap) {
        isWin = false;
        checkedPole = gameMap;
        checkedlPole = polePoint.getlPole();
        checkedwPole = polePoint.getwPole();

        checksByPole(polePoint.getConvertedPole(), checkedlPole, checkedwPole);
    }

    private void checksByPole(int poleNumber, int lPole, int wPole) {
        switch (poleNumber) {
            case 1: {
                lineCheck(0);
                columnCheck(0);
                rightCrossCheck();
            }
            break;
            case 2: {
                lineCheck(0);
                columnCheck(1);
            }
            break;
            case 3: {
                lineCheck(0);
                columnCheck(2);
                rightCrossCheck();
            }
            break;
            case 4: {
                lineCheck(1);
                columnCheck(0);
            }
            break;
            case 5: {
                lineCheck(1);
                columnCheck(1);
                rightCrossCheck();
                leftCrossCheck();
            }
            break;
            case 6: {
                while (!isWin) {
                    lineCheck(1);
                    columnCheck(2);
                }
            }
            break;
            case 7: {
                lineCheck(2);
                columnCheck(0);
                rightCrossCheck();
            }
            break;
            case 8: {
                lineCheck(2);
                columnCheck(1);
            }
            break;
            case 9: {
                lineCheck(2);
                columnCheck(2);
                rightCrossCheck();
            }
            break;

        }
    }

    private void rightCrossCheck() {
        if (checkedPole[0][0].equals(checkedPole[1][1]) && checkedPole[0][0].equals(checkedPole[2][2])) {
            isWin = true;
        }
    }

    private void leftCrossCheck() {
        if (checkedPole[0][2].equals(checkedPole[1][1]) && checkedPole[0][0].equals(checkedPole[2][0])) {
            isWin = true;
        }
    }

    private void columnCheck(int i) {
        if (checkedPole[0][i] != null || checkedPole[1][i] != null || checkedPole[2][i] != null) {
            if (checkedPole[0][i].equals(checkedPole[1][i]) && checkedPole[0][i].equals(checkedPole[2][i])) {
                isWin = true;
            }
        }
    }

    private void lineCheck(int i) {
        Figures p1 = checkedPole[i][0];
        Figures p2 = checkedPole[i][1];
        Figures p3 = checkedPole[i][2];

        if (p1 == null && p2 == null && p3 == null) {
            if (p1.equals(p2) && p1.equals(p3)) {
                isWin = true;
            }
        }
    }
}
