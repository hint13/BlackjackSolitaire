package dev.hint13.bjs.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        this(true);
    }

    public Deck(boolean shuffled) {
        initDeck();
        if (shuffled)
            shuffleDeck();
    }

    public List<Card> getCards() {
        return cards;
    }

    private void initDeck() {
        cards.clear();
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

}
