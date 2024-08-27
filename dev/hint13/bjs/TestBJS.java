package dev.hint13.bjs;

import dev.hint13.bjs.cards.Card;
import dev.hint13.bjs.game.Board;
import dev.hint13.bjs.game.ScoreCalculator;

public class TestBJS extends BlackjackSolitaire {

    public static int testSolitaire(String[] cards) {
        BlackjackSolitaire bjs = new BlackjackSolitaire();
        for (int i = 0; i < Math.min(cards.length, Board.BOARD_SIZE); i++) {
            Card card = Card.fromString(cards[i]);
            bjs.board.putCardByIndex(i+1, card);
        }
        bjs.gui.display(bjs.board);
        int score = ScoreCalculator.calculateScore(bjs.board);
        bjs.showScoreMessage(score);
        return score;
    }

    private static void test_C_1bj_24() {
        String[] cards = {
                "JS", "9H", "3C", "5D", "JC",
                "AH", "9C", "4C", "6H", "6C",
                "3D", "8S", "8C",
                "2D", "3H", "AS"
        };
       assert testSolitaire(cards) == 24 : "test_C_1bj_24: Expected 24, but got other";
    }

    private static void test_C_1bj_26() {
        String[] cards = {
                "10C", "7S", "7C", "6S", "QS",
                "AS", "9S", "4C", "2C", "QC",
                "KH", "KC", "4S",
                "5C", "5D", "9H"
        };
        assert testSolitaire(cards) == 26 : "test_C_1bj_26: Expected 26, but got other";
    }

    private static void test_C_2bj_30() {
        String[] cards = {
                "KS", "9C", "8S", "6D", "AC",
                "AS", "4C", "9S", "6S", "JC",
                "6C", "4S", "QD",
                "8D", "9H", "3D"
        };
        assert testSolitaire(cards) == 30 : "test_C_2bj_30: Expected 30, but got other";
    }

    private static void test_C_2bj_41() {
        String[] cards = {
                "QH", "2C", "3H", "QS", "AC",
                "AD", "4H", "KH", "7C", "JH",
                "6D", "7H", "8S",
                "9D", "9S", "3D"
        };
        assert testSolitaire(cards) == 41 : "test_C_2bj_41: Expected 41, but got other";
    }

    private static void test_C_2bj_42() {
        String[] cards = {
                "AS", "9H", "4D", "3S", "10D",
                "JD", "6S", "5H", "4H", "AC",
                "JH", "2D", "6D",
                "4C", "QH", "7D"
        };
        assert testSolitaire(cards) == 42 : "test_C_2bj_42: Expected 42, but got other";
    }

    private static void test_C_2bj_67() {
        String[] cards = {
                "10S", "2D", "5S", "3S", "AC",
                "AD", "4D", "4C", "2H", "10C",
                "5C", "9C", "7C",
                "JD", "3H", "8D"
        };
        assert testSolitaire(cards) == 67 : "test_C_2bj_67: Expected 67, but got other";
    }

    private static void test_C_12() {
        String[] cards = {
                "JD", "5H", "KC", "QD", "9C",
                "JH", "2C", "4S", "2D", "QH",
                "4H", "KH", "10C",
                "AD", "8S", "8C"
        };
        assert testSolitaire(cards) == 12 : "test_C_2bj_12: Expected 12, but got other";
    }

    public static void main(String[] args) {
        test_C_1bj_24();
        test_C_1bj_26();
        test_C_2bj_30();
        test_C_2bj_41();
        test_C_2bj_42();
        test_C_2bj_67();
        test_C_12();
    }
}
