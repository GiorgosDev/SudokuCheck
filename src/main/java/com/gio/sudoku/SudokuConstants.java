package com.gio.sudoku;

public class SudokuConstants {
    public static final int SUDOKU_FIELD_SIDE_LENGTH = 9;
    public static final int SUDOKU_BOX_SIDE_LENGTH = 3;
    public static final int SUDOKU_ELEMENT_MIN = 1;
    public static final int SUDOKU_ELEMENT_MAX = 9;
    public static final int SUDOKU_BOX_SUM = 45;
    public static final String SUDOKU_CSV_SEPARATOR = ",";
    public static final String VALID_RESPONSE = "VALID";
    public static final String INVALID_RESPONSE = "INVALID";
    public static final String PROCESSED = "PROCESSED";
    public static final String ERROR = "ERROR";

    public static final String ERR_FIELD_SIZE = "Field size should be 9x9";
    public static final String ERR_NO_ARG = "Please provide input file name as argument";
    public static final String ERR_FILE_NOT_FOUND = "File %s was not found";
    public static final String ERR_INCORRECT_ROW_LENGTH = "Row %d has incorrect length";
    public static final String ERR_INCORRECT_CHAR = "Incorrect character in row %d";
    public static final String ERR_ROW_ELEMENT_OUT_OF_RANGE = "Element out of range in row %d";
    public static final String ERR_COL_ELEMENT_OUT_OF_RANGE = "Element out of range in column %d";
    public static final String ERR_BOX_ELEMENT_OUT_OF_RANGE = "Element out of range in box %d";
    public static final String ERR_INCORRECT_ROW_SUM = "Incorrect sum in row %d";
    public static final String ERR_INCORRECT_COL_SUM = "Incorrect sum in column %d";
    public static final String ERR_INCORRECT_BOX_SUM = "Incorrect sum in box %d";
    public static final String ERR_DUPLICATE_IN_ROW = "Duplicate in row %d";
    public static final String ERR_DUPLICATE_IN_COL = "Duplicate in column %d";
    public static final String ERR_DUPLICATE_IN_BOX = "Duplicate in box %d";
}
