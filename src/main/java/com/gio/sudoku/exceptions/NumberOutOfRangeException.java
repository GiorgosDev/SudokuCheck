package com.gio.sudoku.exceptions;

public class NumberOutOfRangeException extends SudokuException{
    public NumberOutOfRangeException() {
        super();
    }

    public NumberOutOfRangeException(String message) {
        super(message);
    }

    public NumberOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
