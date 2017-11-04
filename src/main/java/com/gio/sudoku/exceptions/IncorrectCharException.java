package com.gio.sudoku.exceptions;

public class IncorrectCharException extends SudokuException {
    public IncorrectCharException() {
        super();
    }

    public IncorrectCharException(String message) {
        super(message);
    }

    public IncorrectCharException(String message, Throwable cause) {
        super(message, cause);
    }
}
