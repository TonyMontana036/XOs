public class PolePoint {
    private int lPole;
    private int wPole;

    private int convertedPole;

    public int getlPole() {
        return lPole;
    }

    public int getwPole() {
        return wPole;
    }

    public int getConvertedPole() {
        return convertedPole;
    }

    public PolePoint(int convertedPole) {
        this.convertedPole = convertedPole;
        switch (convertedPole) {
            case 1:
                lPole = 0;
                wPole = 0;
                break;
            case 2:
                lPole = 0;
                wPole = 1;
                break;
            case 3:
                lPole = 0;
                wPole = 2;
                break;
            case 4:
                lPole = 1;
                wPole = 0;
                break;
            case 5:
                lPole = 1;
                wPole = 1;
                break;
            case 6:
                lPole = 1;
                wPole = 2;
                break;
            case 7:
                lPole = 2;
                wPole = 0;
                break;
            case 8:
                lPole = 2;
                wPole = 1;
                break;
            case 9:
                lPole = 2;
                wPole = 2;
                break;
            default:
                break;
        }
    }
}
