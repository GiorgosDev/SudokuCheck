package com.gio.sudoku;

import com.gio.sudoku.exceptions.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class SudokuValidatorTest {

    @Test
    public void testValidateCorrectFile() throws SudokuException, FileNotFoundException {
        Assert.assertTrue(SudokuValidator.validate(resourcesDirectory.getAbsolutePath() + "/test-correct.csv"));
    }

    @Test(expected = FileNotFoundException.class)
    public void testValidateNoFile() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate(resourcesDirectory.getAbsolutePath() + "/no-file.csv");
    }

    @Test(expected = IncorrectCharException.class)
    public void testValidateIncorrectChar() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate(resourcesDirectory.getAbsolutePath() + "/test-incorrect-char.csv");
    }

    @Test(expected = IncorrectInputRowLengthException.class)
    public void testValidateIncorrectFieldSizeChar() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate(resourcesDirectory.getAbsolutePath() + "/test-incorrect-field-size.csv");
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void testValidateNumberOutOfRange() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate(resourcesDirectory.getAbsolutePath() + "/test-number-out-of-range.csv");
    }

    @Test(expected = IncorrectSumInRowException.class)
    public void testValidateIncorrectSum() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate(resourcesDirectory.getAbsolutePath() + "/test-incorrect-sum.csv");
    }

    @Test(expected = DuplicateException.class)
    public void testValidateDuplicate() throws SudokuException, FileNotFoundException {
        SudokuValidator.validate(resourcesDirectory.getAbsolutePath() + "/test-duplicate.csv");
    }

    File resourcesDirectory = new File("src/test/resources");

}
