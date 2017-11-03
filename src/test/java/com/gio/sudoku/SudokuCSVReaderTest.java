package com.gio.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class SudokuCSVReaderTest {
    //todo test incorrect file

    @Test
    public void testReadFieldFromCSV() throws FileNotFoundException, IncorrectInputRowLengthException {
        Assert.assertTrue( Arrays.deepEquals(fieldCorrect, reader.readField("/test-correct.csv")));
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
        reader = new SudokuCSVReader();
    }


    int [][] fieldCorrect;

    SudokuCSVReader reader;
}
