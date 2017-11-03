package com.gio.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;

public class SudokuValidator {

    public static final int SUDOKU_FIELD_SIDE_LENGTH = 9;
    public static final int SUDOKU_BOX_SIDE_LENGTH = 3;
    public static final int SUDOKU_BOX_SUM = 45;
    public static final String SUDOKU_CSV_SEPARATOR = ",";

    public boolean validate (int n){
        return n>0 & n<10;
    }

    public boolean checkBoxSum(int [] box) {
        int sum = 0;
        for(int element : box){
            sum += element;
        }
        return sum == SUDOKU_BOX_SUM;
    }

    public boolean checkBoxContent(int[] box) {
        BitSet numbersTracked = new BitSet(SUDOKU_FIELD_SIDE_LENGTH);
        for(int number : box) {
            if (numbersTracked.get(number))
                return false;
            else
                numbersTracked.set(number);
        }
        return true;
    }

    public boolean validateRows(int[][] field) {
        for(int[] row : field){
            if (! checkBoxSum(row) || !checkBoxContent(row))
                return false;
        }
        return true;
    }

    public boolean validateColumns(int[][] field) {
        int[][] fieldTransposed = transposeArray(field);
        return validateRows(fieldTransposed);
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

    public boolean validateBoxes(int[][] field) {
        int[][] transformedField = boxesToArrays(field);
        return validateRows(transformedField);
    }

    public int[][] boxesToArrays(int[][] field) {
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

    private int[] flatArray(int[][] array, int colShift, int rowShift) {
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

    public boolean validateFieldSize(int[][] fieldCorrect) {
        if(fieldCorrect.length != SUDOKU_FIELD_SIDE_LENGTH)
            return false;
        for(int[] line : fieldCorrect){
            if(line.length != SUDOKU_FIELD_SIDE_LENGTH)
                return false;
        }
        return true;
    }

    public int[][] readField(String filePath) throws IncorrectInputRowLengthException, FileNotFoundException {
        int[][] field = new int[9][];
        String url = getClass().getResource(filePath).getFile();
        try(Scanner in = new Scanner(new File(url))){
            int i = 0;
            while(in.hasNext()){
                String[] numbers = in.nextLine().split(SUDOKU_CSV_SEPARATOR);
                if(numbers.length != SUDOKU_FIELD_SIDE_LENGTH)
                    throw new IncorrectInputRowLengthException();
                field[i] = convertStringArrayToInt(numbers);
                i++;
            }
        }

        return field;
    }

    private int[] convertStringArrayToInt(String[] numbers) {
        int[] row = new int[numbers.length];
        for(int i = 0; i< numbers.length; i++){
            row[i] = Integer.parseInt(numbers[i].trim());
        }
        return row;
    }


}
