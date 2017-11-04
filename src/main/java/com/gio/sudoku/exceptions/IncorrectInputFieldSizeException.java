package com.gio.sudoku.exceptions;

public class IncorrectInputFieldSizeException extends SudokuException{
    public IncorrectInputFieldSizeException() {
        super();
    }

    public IncorrectInputFieldSizeException(String message) {
        super(message);
    }

    public IncorrectInputFieldSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
