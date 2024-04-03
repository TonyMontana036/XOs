public enum Figures {
    CROSS("Крестик"),
    POINT("Нолик");

    private final String named;

    Figures(String named) {
        this.named = named;
    }

    public String getNamed() {
        return named;
    }
}
