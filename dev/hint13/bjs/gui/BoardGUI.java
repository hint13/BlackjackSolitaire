package dev.hint13.bjs.gui;

import dev.hint13.bjs.game.Board;

public interface BoardGUI {
    void display(Board board);

    int getIndex(Board board);
    
    void showMessage(String messageTemplate, Object...values);

    default void update(Board board) {
        throw new RuntimeException("Method not implemented");
    }

}
