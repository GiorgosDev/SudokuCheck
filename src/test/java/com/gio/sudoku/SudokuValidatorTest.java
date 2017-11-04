package com.gio.sudoku;

import com.gio.sudoku.exceptions.IncorrectCharException;
import com.gio.sudoku.exceptions.IncorrectInputRowLengthException;
import com.gio.sudoku.exceptions.NumberOutOfRangeException;
import com.gio.sudoku.exceptions.SudokuException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SudokuValidatorTest {

//DONE test no file
//DONE test incorrect char in file
//DONE test incorrect field format
//DONE test number out of range
//todo test incorrect sum in row/col/box
//todo test duplicat in row/col/box

    @Test
    public void testValidateCorrectFile() throws SudokuException, FileNotFoundException {
        Assert.assertTrue(SudokuValidator.validate("/test-correct.csv"));
    }

    @Test(expected = FileNotFoundException.class)
    public void testValidateNoFile() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate("/no-file.csv");
    }

    @Test(expected = IncorrectCharException.class)
    public void testValidateIncorrectChar() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate("/test-incorrect-char.csv");
    }

    @Test(expected = IncorrectInputRowLengthException.class)
    public void testValidateIncorrectFieldSizeChar() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate("/test-incorrect-field-size.csv");
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void testValidateNumberOutOfRange() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate("/test-number-out-of-range.csv");
    }

}
