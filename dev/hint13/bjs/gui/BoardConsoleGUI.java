package dev.hint13.bjs.gui;

import dev.hint13.bjs.exceptions.WrongIndexException;
import dev.hint13.bjs.game.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

public class BoardConsoleGUI implements BoardGUI, AutoCloseable {

    private static final String GUI_HR_LINE = "===============================================";
    private static final String GUI_TITLE_BAR = "Card board                           || Trash";
    private static final String GUI_VR_LINE = "                 || ";
    private static final String GUI_LEFT_SPACER = "    ";

    private static final String MSG_WRONG_INDEX = "I did not understand you, in which cell should I put the card? ";
    private static final String MSG_ERROR_NOT_NUMBER = "A strange value was received. I need a number of an empty cell: ";

    private final BufferedReader reader;

    public BoardConsoleGUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void display(Board board) {
        System.out.println(GUI_HR_LINE);
        System.out.println(GUI_TITLE_BAR);
        System.out.println(GUI_HR_LINE);
        System.out.print(getFormatedLine(0, 5, board));
        System.out.println(GUI_VR_LINE + getFormatedLine(16, 2, board));
        System.out.print(getFormatedLine(5, 5, board));
        System.out.println(GUI_VR_LINE + getFormatedLine(18, 2, board));
        System.out.print(GUI_LEFT_SPACER + getFormatedLine(10, 3, board));
        System.out.println(GUI_LEFT_SPACER + GUI_VR_LINE);
        System.out.print(GUI_LEFT_SPACER + getFormatedLine(13, 3, board));
        System.out.println(GUI_LEFT_SPACER + GUI_VR_LINE);
    }

    @Override
    public int getIndex(Board board) {
        int index;
        do {
            try {
                index = Integer.parseInt(reader.readLine());
                if (board.isIndexIncorrect(index - 1))
                    throw new WrongIndexException(MSG_WRONG_INDEX);
            } catch (WrongIndexException ex) {
                System.out.print(MSG_WRONG_INDEX);
                index = -1;
            } catch (NumberFormatException | IOException ex) {
                System.out.print(MSG_ERROR_NOT_NUMBER);
                index = -1;
            }
        } while (index == -1);
        return index;
    }

    @Override
    public void showMessage(String messageTemplate, Object... values) {
        System.out.print(MessageFormat.format(messageTemplate, values));
    }

    private String getFormatedLine(int from, int count, Board board) {
        StringBuilder result = new StringBuilder();
        for (int i = from; i < from + count; i++) {
            String part = String.format("%-4s", board.getValueOrIndex(i));
            result.append(part);
        }
        return result.toString();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
