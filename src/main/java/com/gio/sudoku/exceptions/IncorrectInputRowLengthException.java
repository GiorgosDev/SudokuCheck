package com.gio.sudoku.exceptions;

public class IncorrectInputRowLengthException extends SudokuException {
    public IncorrectInputRowLengthException() {
        super();
    }

    public IncorrectInputRowLengthException(String message) {
        super(message);
    }

    public IncorrectInputRowLengthException(String message, Throwable cause) {
        super(message, cause);
    }
}
