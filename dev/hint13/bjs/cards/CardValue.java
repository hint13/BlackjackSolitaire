package dev.hint13.bjs.cards;

public enum CardValue {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 11);

    private final String val;
    private final Integer price;

    CardValue(String val, Integer price) {
        this.val = val;
        this.price = price;
    }

    public String getVal() {
        return val;
    }

    public int getPrice() {
        return price;
    }

    public static CardValue fromVal(String val) {
        return switch (val) {
            case "2" -> TWO;
            case "3" -> THREE;
            case "4" -> FOUR;
            case "5" -> FIVE;
            case "6" -> SIX;
            case "7" -> SEVEN;
            case "8" -> EIGHT;
            case "9" -> NINE;
            case "10" -> TEN;
            case "J" -> JACK;
            case "Q" -> QUEEN;
            case "K" -> KING;
            default -> ACE;
        };
    }
}
