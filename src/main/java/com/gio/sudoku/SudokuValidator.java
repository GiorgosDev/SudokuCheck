package com.gio.sudoku;

import java.util.stream.IntStream;

public class SudokuValidator {

    public boolean validate (int n){
        return n>0 & n<10;
    }

    public boolean checkColumn(int [] column) {
        return IntStream.of(column).sum() == 45;
    }
}
