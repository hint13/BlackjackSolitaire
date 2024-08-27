package dev.hint13.bjs.game;

import dev.hint13.bjs.cards.Card;
import dev.hint13.bjs.cards.CardValue;

public class ScoreCalculator {

    public static int calculateScore(Board board) {
        final int[][] cardLines = {
                {1, 6},  // check BlackJack
                {5, 10}, // check BlackJack
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13},
                {14, 15, 16},
                {2, 7, 11, 14},
                {3, 8, 12, 15},
                {4, 9, 13, 16}
        };

        int score = 0;
        int countBlackJackLines = 2;
        for (int[] cards : cardLines) {
            score += getScoreForCardLine(board, countBlackJackLines-- > 0, cards);
        }

        return score;
    }

    private static int getScoreForCardLine(Board board, boolean checkBJ, int[] cards) {
        int currentScore = sumCardsPrice(board.getCards(cards));
        return (checkBJ && currentScore == 21) ? 10 : getScoreBySumPrice(currentScore);
    }

    private static int getScoreBySumPrice(int sum) {
        if (sum > 21)
            return 0;
        return switch (sum) {
            case 21 -> 7;
            case 20 -> 5;
            case 19 -> 4;
            case 18 -> 3;
            case 17 -> 2;
            default -> 1;
        };
    }

    private static int sumCardsPrice(Card[] cards) {
        int sum = 0;
        int aceCount = 0;
        for (Card card : cards) {
            if (card == null) continue;
            sum += card.getPrice();
            if (card.getValue().equals(CardValue.ACE.toString()))
                aceCount++;
        }
        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }
        return sum;
    }
}
