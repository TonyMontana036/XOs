import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChecksTest {

    Checks checks;
    int square;
    Figures[][] figures;
    PolePoint polePoint;

    @BeforeEach
    public void initEach() {
        checks = new Checks();
        square = 3;
        figures = new Figures[square][square];
    }

    @Test
    void returnWinFalseWhenLineHas3Null() {
        polePoint = new PolePoint(1);

        checks.check(polePoint, figures);

        Assertions.assertFalse(checks.isWin(), "Победа засчитана ошибочно");
    }

    @Test
    void returnWinTrueWhenLineSameSymbolOn3Square() {
        polePoint = new PolePoint(1);

        for (int i = 0; i < square; i++) {
            figures[0][i] = Figures.POINT;
        }

        checks.check(polePoint, figures);

        Assertions.assertTrue(checks.isWin(), "Фигуры в линии не совпадают");
    }

    @Test
    void returnWinTrueWhenColumnSameSymbolOn3Square() {
        polePoint = new PolePoint(1);

        for (int i = 0; i < square; i++) {
            figures[i][0] = Figures.POINT;
        }

        checks.check(polePoint, figures);

        Assertions.assertTrue(checks.isWin(), "Фигуры в cтолбе не совпадают");
    }

    @Test
    void returnWinFalseWhenDifferentSymbolsWithoutNullInLone() {
        polePoint = new PolePoint(1);

        for (int i = 0; i < square; i++) {
            figures[i][0] = Figures.POINT;
            if (i == square - 1) {
                figures[i][0] = Figures.CROSS;
            }
        }

        checks.check(polePoint, figures);

        Assertions.assertFalse(checks.isWin(), "Фигуры в cтолбе совпадают");
    }

    @Test
    void returnWinTrueWhenRightDiagonalHasSameSymbols() {
        polePoint = new PolePoint(1);

        for (int i = 0; i < square; i++) {
            figures[i][i] = Figures.POINT;
        }

        checks.check(polePoint, figures);

        Assertions.assertTrue(checks.isWin(), "Фигуры в диагонали не совпадают");
    }

    @Test
    void returnWinTrueWhenLeftDiagonalHasSameSymbols() {
        polePoint = new PolePoint(3);
        int j = square - 1;
        for (int i = 0; i < square; i++) {
            figures[j--][i] = Figures.POINT;
        }

        checks.check(polePoint, figures);

        Assertions.assertTrue(checks.isWin(), "Фигуры в диагонали не совпадают");
    }
}
