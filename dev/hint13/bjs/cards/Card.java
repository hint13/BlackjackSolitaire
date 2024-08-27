package dev.hint13.bjs.cards;

public class Card {
    private final CardValue value;
    private final CardSuit suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getPrice() {
        return value.getPrice();
    }

    public String getValue() {
        return value.toString();
    }

    public String getSuit() {
        return suit.toString();
    }

    public static Card fromString(String name) {
        CardSuit cardSuit = CardSuit.fromVal(name.substring(name.length()-1));
        CardValue cardValue = CardValue.fromVal(name.substring(0, name.length() - 1));
        return new Card(cardValue, cardSuit);
    }

    @Override
    public String toString() {
        return value.getVal() + suit.getVal();
    }
}
