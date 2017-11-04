package com.gio.sudoku;

import com.gio.sudoku.exceptions.SudokuException;

import java.io.FileNotFoundException;

public class SudokuValidator {
    public static boolean validate(String file) throws SudokuException, FileNotFoundException {
        SudokuCSVReader reader = new SudokuCSVReader();
        int[][] field = reader.readField(file);
        return
            SudokuValidationUtils.validateFieldSize(field) &&
            SudokuValidationUtils.validateRows(field) &&
            SudokuValidationUtils.validateColumns(field) &&
            SudokuValidationUtils.validateBoxes(field) ;
    }
}
