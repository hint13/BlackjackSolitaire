package dev.hint13.bjs.cards;

public enum CardSuit {
    HEARTS("H"),
    SPADES("S"),
    DIAMONDS("D"),
    CLUBS("C");

    private final String val;

    CardSuit(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public static CardSuit fromVal(String name) {
        return switch (name) {
            case "H" -> HEARTS;
            case "S" -> SPADES;
            case "D" -> DIAMONDS;
            default -> CLUBS;
        };
    }
}
