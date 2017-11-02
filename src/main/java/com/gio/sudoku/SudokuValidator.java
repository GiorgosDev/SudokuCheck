package com.gio.sudoku;

import java.util.BitSet;
import java.util.stream.IntStream;

public class SudokuValidator {

    public boolean validate (int n){
        return n>0 & n<10;
    }

    public boolean checkGroupSum(int [] group) {
        return IntStream.of(group).sum() == 45;
    }

    public boolean checkGroupContent(int[] group) {
        BitSet numbersTracked = new BitSet(9);
        for(int number : group) {
            if (numbersTracked.get(number))
                return false;
            else
                numbersTracked.set(number);
        }
        return true;
    }

    public boolean validateRows(int[][] field) {
        for(int[] row : field){
            if (! checkGroupSum(row) || !checkGroupContent(row))
                return false;
        }
        return true;
    }
}
