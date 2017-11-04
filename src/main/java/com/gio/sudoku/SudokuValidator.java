package com.gio.sudoku;

import com.gio.sudoku.exceptions.SudokuException;

import java.io.FileNotFoundException;

import static com.gio.sudoku.SudokuConstants.INVALID_RESPONSE;
import static com.gio.sudoku.SudokuConstants.VALID_RESPONSE;

public class SudokuValidator {
    public static String validate(String file) throws SudokuException, FileNotFoundException {
        SudokuCSVReader reader = new SudokuCSVReader();
        int[][] field = reader.readField(file);
        return
            SudokuValidationUtils.validateFieldSize(field) &&
            SudokuValidationUtils.validateRows(field) &&
            SudokuValidationUtils.validateColumns(field) &&
            SudokuValidationUtils.validateBoxes(field) ? VALID_RESPONSE : INVALID_RESPONSE;
    }
}
