package com.gio.sudoku;

import com.gio.sudoku.exceptions.IncorrectCharException;
import com.gio.sudoku.exceptions.IncorrectInputRowLengthException;
import com.gio.sudoku.exceptions.SudokuException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class SudokuCSVReaderTest {

    @Test
    public void testReadFieldFromCSV() throws FileNotFoundException, SudokuException {
        Assert.assertTrue( Arrays.deepEquals(fieldCorrect, reader.readField(resourcesDirectory.getAbsolutePath() + "/test-correct.csv")));
    }

    @Test(expected = IncorrectInputRowLengthException.class)
    public void testReadFieldWrongFromCSV() throws FileNotFoundException, SudokuException {
        reader.readField(resourcesDirectory.getAbsolutePath() + "/test-incorrect-field-size.csv");
    }

    @Test(expected = IncorrectCharException.class)
    public void testReadFieldwrongCharFromCSV() throws FileNotFoundException, SudokuException {
        reader.readField(resourcesDirectory.getAbsolutePath() + "/test-incorrect-char.csv");
    }

    @Test
    public void testStringArrayToIntConversion() throws FileNotFoundException, SudokuException {
        Assert.assertTrue(Arrays.equals(numbersCorrect, reader.convertStringArrayToInt(lineCorrect)));
    }


    @Test(expected = IncorrectCharException.class)
    public void testStringArrayToIntConversionIncorrectChar() throws FileNotFoundException, SudokuException {
        reader.convertStringArrayToInt(lineIncorrect);
    }

    @Test(expected = IncorrectCharException.class)
    public void testStringArrayToIntConversionIncorrectChar2() throws FileNotFoundException, SudokuException {
        reader.convertStringArrayToInt(lineIncorrect2);
    }

    @Before
    public void initTestBoxes(){

        fieldCorrect = new int[][]{
                {3, 2, 9, 6, 8, 7, 5, 4, 1},
                {5, 1, 4, 9, 3, 2, 7, 8, 6},
                {8, 7, 6, 4, 5, 1, 2, 9, 3},
                {6, 5, 2, 3, 7, 9, 8, 1, 4},
                {7, 4, 3, 5, 1, 8, 6, 2, 9},
                {9, 8, 1, 2, 6, 4, 3, 7, 5},
                {4, 6, 8, 7, 9, 3, 1, 5, 2},
                {1, 9, 5, 8, 2, 6, 4, 3, 7},
                {2, 3, 7, 1, 4, 5, 9, 6, 8}
        };

        lineCorrect = new String[]{" 1", "2 " , "3"};
        lineIncorrect = new String[]{" 1", "a" , "3"};
        lineIncorrect2 = new String[]{" 1", "" , "3"};
        numbersCorrect = new int[] {1, 2, 3};
        reader = new SudokuCSVReader();
    }


    int [][] fieldCorrect;
    String[] lineCorrect;
    String[] lineIncorrect;
    String[] lineIncorrect2;
    int[] numbersCorrect;
    SudokuCSVReader reader;
    File resourcesDirectory = new File("src/test/resources");
}
