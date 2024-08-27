package dev.hint13.bjs;

import dev.hint13.bjs.cards.Deck;
import dev.hint13.bjs.game.Board;
import dev.hint13.bjs.cards.Card;
import dev.hint13.bjs.game.ScoreCalculator;
import dev.hint13.bjs.gui.BoardConsoleGUI;
import dev.hint13.bjs.gui.BoardGUI;

public class BlackjackSolitaire {

    protected final Deck deck;

    protected final Board board;

    protected final BoardGUI gui;

    public BlackjackSolitaire() {
        this.deck = new Deck();
        this.board = new Board();
        this.gui = new BoardConsoleGUI();
    }

    public void play() {
        int index;
        gui.display(board);
        for (Card card : deck.getCards()) {
            gui.showMessage("The next card is {0} {1} ({2}). Select a cell to put: ",
                    card.getValue(), card.getSuit(), card.toString());
            index = gui.getIndex(board);
            board.putCardByIndex(index, card);
            gui.display(board);
            if (board.isBoardFull()) {
                showScoreMessage(ScoreCalculator.calculateScore(board));
                break;
            }
        }
    }

    protected void showScoreMessage(int score) {
        String finalMessage;
        if (score < 10) {
            finalMessage = "Not the most successful attempt...";
        } else if (score < 20) {
            finalMessage = "You can do better...";
        } else if (score < 30) {
            finalMessage = "Not a bad result!";
        } else if (score < 60) {
            finalMessage = "A very good result!";
        } else {
            finalMessage = "It's amazing! You are the best!";
        }
        gui.showMessage("Your score is {0}. {1}\n", score, finalMessage);
    }

}
