package com.gio.sudoku.exceptions;

public class IncorrectSumInRowException extends SudokuException {
    public IncorrectSumInRowException() {
        super();
    }

    public IncorrectSumInRowException(String message) {
        super(message);
    }

    public IncorrectSumInRowException(String message, Throwable cause) {
        super(message, cause);
    }
}
