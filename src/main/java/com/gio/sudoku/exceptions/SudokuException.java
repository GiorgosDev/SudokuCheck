package com.gio.sudoku.exceptions;

public class SudokuException extends Exception{
    public SudokuException() {
        super();
    }

    public SudokuException(String message) {
        super(message);
    }

    public SudokuException(String message, Throwable cause) {
        super(message, cause);
    }
}
