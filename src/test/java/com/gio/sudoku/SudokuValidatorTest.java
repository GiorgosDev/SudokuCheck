package com.gio.sudoku;

import com.gio.sudoku.exceptions.SudokuException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import static com.gio.sudoku.SudokuConstants.VALID_RESPONSE;

public class SudokuValidatorTest {

//todo test no file
//todo test incorrect char in file
//todo test incorrect field format
//todo test number out of range
//todo test incorrect sum in row/col/box
//todo test duplicat in row/col/box

    @Test
    public void testValidateCorrectFile() throws SudokuException, FileNotFoundException {
        Assert.assertEquals(VALID_RESPONSE, SudokuValidator.validate("/test-correct.csv"));
    }

    @Test(expected = FileNotFoundException.class)
    public void testValidateNoFile() throws SudokuException, FileNotFoundException {
        Assert.assertEquals(VALID_RESPONSE, SudokuValidator.validate("/no-file.csv"));
    }
}
