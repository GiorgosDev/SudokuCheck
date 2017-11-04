package com.gio.sudoku;

import com.gio.sudoku.exceptions.NumberOutOfRangeException;
import com.gio.sudoku.exceptions.SudokuException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.gio.sudoku.SudokuConstants.SUDOKU_ELEMENT_MAX;
import static com.gio.sudoku.SudokuConstants.SUDOKU_ELEMENT_MIN;

public class SudokuValidationUtilsTest {

    @Test
    public void testNumberInRange() throws SudokuException{
        Assert.assertTrue(SudokuValidationUtils.isElementInRange((SUDOKU_ELEMENT_MAX - SUDOKU_ELEMENT_MIN)/2));
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void testNumberMoreThenMaxAllowed() throws SudokuException{
        SudokuValidationUtils.isElementInRange(SUDOKU_ELEMENT_MAX+1);
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void testNumberMessThanMinAllowed() throws SudokuException{
        SudokuValidationUtils.isElementInRange(SUDOKU_ELEMENT_MIN-1);
    }

    @Test
    public void testBoxSum() throws SudokuException{
        Assert.assertTrue( SudokuValidationUtils.checkRowSum(groupCorrect));
        Assert.assertTrue( SudokuValidationUtils.checkRowSum(groupDuplicates));
        Assert.assertFalse( SudokuValidationUtils.checkRowSum(groupMore));
        Assert.assertFalse( SudokuValidationUtils.checkRowSum(groupLess));
    }

    @Test
    public void testBoxContent() throws SudokuException{
        Assert.assertTrue( SudokuValidationUtils.checkRowContent(groupCorrect));
        Assert.assertFalse( SudokuValidationUtils.checkRowContent(groupMore));
        Assert.assertFalse( SudokuValidationUtils.checkRowContent(groupLess));
        Assert.assertFalse( SudokuValidationUtils.checkRowContent(groupDuplicates));
    }

    @Test
    public void testRowsValidation() throws SudokuException{
        Assert.assertFalse( SudokuValidationUtils.validateRows(fieldDuplicates));
        Assert.assertTrue( SudokuValidationUtils.validateRows(fieldCorrect));
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void testRowsValidationOutOfRange() throws SudokuException{
        SudokuValidationUtils.validateRows(fieldOutOfRange);
    }


    @Test
    public void testColumnsValidation() throws SudokuException{
        Assert.assertFalse( SudokuValidationUtils.validateColumns(fieldDuplicates));
        Assert.assertTrue( SudokuValidationUtils.validateColumns(fieldCorrect));
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void testColumnsValidationOutOfRange() throws SudokuException{
        SudokuValidationUtils.validateColumns(fieldOutOfRange);
    }

    @Test
    public void testBoxesValidation() throws SudokuException{
        Assert.assertFalse(SudokuValidationUtils.validateBoxes(fieldDuplicates));
        Assert.assertFalse(SudokuValidationUtils.validateBoxes(fieldCorrectRowsColsWrongBoxes));
        Assert.assertTrue(SudokuValidationUtils.validateBoxes(fieldCorrect));
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void testBoxesValidationOutOfRange() throws SudokuException{
        SudokuValidationUtils.validateBoxes(fieldOutOfRange);
    }


    @Test
    public void testBoxesToArrays(){
        Assert.assertTrue(
                Arrays.deepEquals(fieldTransformed,
                        SudokuValidationUtils.boxesToArrays(fieldCorrect)));
        Assert.assertFalse(
                Arrays.deepEquals(fieldTransformed,
                        SudokuValidationUtils.boxesToArrays(fieldDuplicates)));
    }

    @Test
    public void testTransposeArray(){
        Assert.assertTrue( Arrays.deepEquals(subArrayTransponed,
                        SudokuValidationUtils.transposeArray(subArray)));
        Assert.assertFalse( Arrays.deepEquals(subArray,
                        SudokuValidationUtils.transposeArray(subArray)));
    }

    @Test
    public void testFieldSize(){
        Assert.assertTrue(SudokuValidationUtils.validateFieldSize(fieldCorrect));
        Assert.assertFalse(SudokuValidationUtils.validateFieldSize(subArray));
    }



    @Before
    public void initTestBoxes(){
        groupCorrect = new int [] {1, 2 ,3, 4, 5, 6, 7, 8, 9};
        groupMore = new int [] {1, 2 ,3, 4, 5, 6, 7, 9, 9};
        groupLess = new int [] {1, 2 ,3, 4, 5, 6, 7, 1, 1};
        groupDuplicates = new int [] {8, 2 ,4, 4, 5, 6, 7, 8, 1};
        fieldDuplicates = new int[][]{
                {8, 2 ,4, 4, 5, 6, 7, 8, 1},
                {1, 2 ,3, 4, 5, 6, 7, 9, 9},
                {1, 2 ,3, 4, 5, 6, 7, 8, 9},
                {1, 2 ,3, 4, 5, 6, 7, 1, 1},
                {8, 2 ,4, 4, 5, 6, 7, 8, 1},
                {1, 2 ,3, 4, 5, 6, 7, 9, 9},
                {1, 2 ,3, 4, 5, 6, 7, 8, 9},
                {1, 2 ,3, 4, 5, 6, 7, 1, 1},
                {1, 2 ,3, 4, 5, 6, 7, 1, 1}
        };
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

        fieldOutOfRange = new int[][]{
                {3, 2, 9, 6, 8, 7, 5, 4, 1},
                {5, 1, 4, 9, 3, 2, 7, 8, 6},
                {8, 7, -6, 4, 5, 1, 2, 9, 3},
                {6, 5, 2, 3, 7, 999, 8, 1, 4},
                {7, 4, 3, 5, 1, 8, 6, 2, 9},
                {9, 8, 1, 2, 6, 4, 3, 7, 5},
                {4, 6, 0, 7, 9, 3, 1, 5, 2},
                {1, 9, 5, 8, 2, 6, 4, 3, 7},
                {2, 3, 7, 1, 4, 10, 9, 6, 8}
        };

        fieldCorrectRowsColsWrongBoxes = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };

        fieldTransformed = new int[][]{
                {3, 2, 9, 5, 1, 4, 8, 7, 6},
                {6, 8, 7, 9, 3, 2, 4, 5, 1},
                {5, 4, 1, 7, 8, 6, 2, 9, 3},
                {6, 5, 2, 7, 4, 3, 9, 8, 1},
                {3, 7, 9, 5, 1, 8, 2, 6, 4},
                {8, 1, 4, 6, 2, 9, 3, 7, 5},
                {4, 6, 8, 1, 9, 5, 2, 3, 7},
                {7, 9, 3, 8, 2, 6, 1, 4, 5},
                {1, 5, 2, 4, 3, 7, 9, 6, 8}
        };
        subArray  = new int[][]{
                {3, 2},
                {5, 1},
                {8, 7},
                {6, 5}
        };

        subArrayTransponed  = new int[][]{
                {3, 5, 8, 6},
                {2, 1, 7, 5}
        };
    }

    private int [] groupCorrect;
    private int [] groupMore;
    private int [] groupLess;
    private int [] groupDuplicates;
    private int [][] fieldCorrect;
    private int [][] fieldDuplicates;
    private int [][] fieldTransformed;
    private int [][] fieldOutOfRange;
    private int [][] fieldCorrectRowsColsWrongBoxes;
    private int [][] subArray;
    private int [][] subArrayTransponed;

}
