package com.gio.sudoku;

import com.gio.sudoku.exceptions.DuplicateException;
import com.gio.sudoku.exceptions.IncorrectSumInRowException;
import com.gio.sudoku.exceptions.NumberOutOfRangeException;
import com.gio.sudoku.exceptions.SudokuException;

import static com.gio.sudoku.SudokuConstants.*;

public enum ValidatedInstance {
    ROW, COLUMN, BOX;

    String errorMessage(SudokuException ex) {
        if(ex instanceof IncorrectSumInRowException){
            switch (this) {
                case ROW:
                    return ERR_INCORRECT_ROW_SUM;
                case COLUMN:
                    return ERR_INCORRECT_COL_SUM;
                case BOX:
                    return ERR_INCORRECT_BOX_SUM;
                default:
                    return ERR_INCORRECT_ROW_SUM;
            }
        } else if(ex instanceof NumberOutOfRangeException){
            switch (this) {
                case ROW:
                    return ERR_ROW_ELEMENT_OUT_OF_RANGE;
                case COLUMN:
                    return ERR_COL_ELEMENT_OUT_OF_RANGE;
                case BOX:
                    return ERR_BOX_ELEMENT_OUT_OF_RANGE;
                default:
                    return ERR_ROW_ELEMENT_OUT_OF_RANGE;
            }
        } else if (ex instanceof DuplicateException) {
            switch (this) {
                case ROW:
                    return ERR_DUPLICATE_IN_ROW;
                case COLUMN:
                    return ERR_DUPLICATE_IN_COL;
                case BOX:
                    return ERR_DUPLICATE_IN_BOX;
                default:
                    return ERR_DUPLICATE_IN_ROW;
            }
        } else return "";
    }

}
