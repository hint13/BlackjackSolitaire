package dev.hint13.bjs.game;

import dev.hint13.bjs.cards.Card;
import dev.hint13.bjs.exceptions.NotEnoughSpaceException;
import dev.hint13.bjs.exceptions.WrongIndexException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final String MSG_NOT_ENOUGH_SPACE = "Ups! No more cards can be added.";
    private static final String MSG_WRONG_INDEX_TEMPLATE = "I can't find an empty cell with an index {0}";

    public static final int BOARD_SIZE = 16;
    public static final int TRASH_SIZE = 4;

    private final List<Card> board;

    private final List<Card> trash;

    public Board() {
        board = new ArrayList<>();
        fillByNullValues(board, BOARD_SIZE);
        trash = new ArrayList<>();
        fillByNullValues(trash, TRASH_SIZE);
    }

    public Card[] getCards(int...indexes) {
        Card[] cards = new Card[indexes.length];
        int current = 0;
        for (int index : indexes) {
            cards[current++] = board.get(index-1);
        }
        return cards;
    }

    private void fillByNullValues(List<Card> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(null);
        }
    }

    public void putCardByIndex(int index, Card card) throws WrongIndexException {
        index -= 1;
        if (isBoardFull())
            throw new NotEnoughSpaceException(MSG_NOT_ENOUGH_SPACE);
        if (isIndexIncorrect(index))
            throw new WrongIndexException(MessageFormat.format(MSG_WRONG_INDEX_TEMPLATE, index+1));
        if (index < BOARD_SIZE) {
            board.set(index, card);
        } else {
            trash.set(toTrashIndex(index), card);
        }
    }

    public boolean isBoardFull() {
        return !board.contains(null);
    }

    public boolean isIndexIncorrect(int index) {
        if (index < 0 || index > BOARD_SIZE + TRASH_SIZE - 1) {
            return true;
        }
        if (index < BOARD_SIZE) {
            return board.get(index) != null;
        }
        return trash.get(toTrashIndex(index)) != null;
    }

    private int toTrashIndex(int index) {
        return index - BOARD_SIZE;
    }

    public String getValueOrIndex(int index) {
        if (index < BOARD_SIZE)
            return board.get(index) != null ? board.get(index).toString() : "" + (index+1);
        else
            return trash.get(toTrashIndex(index)) != null ? trash.get(toTrashIndex(index)).toString() : "" + (index+1);
    }
}
