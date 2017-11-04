package com.gio.sudoku;

import java.util.BitSet;

import static com.gio.sudoku.SudokuConstants.*;

public class SudokuValidationUtils {

    public static boolean isElementInRange (int n){
        return n>0 & n<10;
    }

    public static boolean checkRowSum(int [] box) {
        int sum = 0;
        for(int element : box){
            sum += element;
        }
        return sum == SUDOKU_BOX_SUM;
    }

    public static boolean checkRowContent(int[] box) {
        BitSet numbersTracked = new BitSet(SUDOKU_FIELD_SIDE_LENGTH);
        for(int number : box) {

            if (!isElementInRange(number) || numbersTracked.get(number))
                return false;
            else
                numbersTracked.set(number);
        }
        return true;
    }

    public static boolean validateRows(int[][] field) {
        for(int[] row : field){
            if (! checkRowSum(row) || !checkRowContent(row))
                return false;
        }
        return true;
    }

    public static boolean validateColumns(int[][] field) {
        int[][] fieldTransposed = transposeArray(field);
        return validateRows(fieldTransposed);
    }

    public static int[][] transposeArray(int[][] array) {
        int[][] transposedArray = new int[array[0].length][array.length];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                transposedArray[j][i] = array[i][j];
            }
        }
        return  transposedArray;
    }

    public static boolean validateBoxes(int[][] field) {
        int[][] transformedField = boxesToArrays(field);
        return validateRows(transformedField);
    }

    public static int[][] boxesToArrays(int[][] field) {
        int[][] transformedField = new int[SUDOKU_FIELD_SIDE_LENGTH][SUDOKU_FIELD_SIDE_LENGTH];
        int l = 0;
        for(int colShift = 0; colShift < SUDOKU_FIELD_SIDE_LENGTH; colShift += SUDOKU_BOX_SIDE_LENGTH){
            for(int rowShift = 0; rowShift < SUDOKU_FIELD_SIDE_LENGTH; rowShift += SUDOKU_BOX_SIDE_LENGTH){
                transformedField[l] = flatArray(field, colShift, rowShift);
                l++;
            }
        }
        return transformedField;
    }

    private static int[] flatArray(int[][] array, int colShift, int rowShift) {
        int[] row = new int[SUDOKU_FIELD_SIDE_LENGTH];
        int l =0;
        for(int i = colShift; i < colShift + SUDOKU_BOX_SIDE_LENGTH; i++) {
            for (int j = rowShift; j < rowShift + SUDOKU_BOX_SIDE_LENGTH; j++) {
                row[l] = array[i][j];
                l++;
            }
        }
        return row;
    }

    public static boolean validateFieldSize(int[][] fieldCorrect) {
        if(fieldCorrect.length != SUDOKU_FIELD_SIDE_LENGTH)
            return false;
        for(int[] line : fieldCorrect){
            if(line.length != SUDOKU_FIELD_SIDE_LENGTH)
                return false;
        }
        return true;
    }




}