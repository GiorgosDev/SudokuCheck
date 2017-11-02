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

    public boolean validateColumns(int[][] field) {
        for(int i = 0; i<field[0].length; i++){
            int[][] sub = subArray(field, 0, i, field.length, i);
        }
        return false;
    }

    public int[][] subArray(int[][] field, int rowFrom, int colFrom, int rowTo, int colTo) {
        int[][] subField = new int [colTo - colFrom + 1][rowTo - rowFrom + 1];
        for (int i = colFrom; i <= colTo; i++){
            for (int j = rowFrom; j <= rowTo; j++){
                subField[i - rowFrom][j - colFrom] = field[i][j];
            }
        }
        return subField;
    }

    public int[][] transposeArray(int[][] array) {
        int[][] transposedArray = new int[array[0].length][array.length];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                transposedArray[j][i] = array[i][j];
            }
        }
        return  transposedArray;
    }
}
