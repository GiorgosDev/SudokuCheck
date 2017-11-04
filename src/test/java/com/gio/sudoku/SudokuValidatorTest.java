package com.gio.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SudokuValidatorTest {

//todo create general validation from file function
//todo add error reason

    @Test
    public void testNumberRange(){
        Assert.assertTrue(SudokuValidator.isElementInRange(5));
        Assert.assertFalse(SudokuValidator.isElementInRange(10));
        Assert.assertFalse(SudokuValidator.isElementInRange(0));
        Assert.assertFalse(SudokuValidator.isElementInRange(-1));
    }

    @Test
    public void testBoxSum(){
        Assert.assertTrue( SudokuValidator.checkRowSum(groupCorrect));
        Assert.assertTrue( SudokuValidator.checkRowSum(groupDuplicates));
        Assert.assertFalse( SudokuValidator.checkRowSum(groupMore));
        Assert.assertFalse( SudokuValidator.checkRowSum(groupLess));
    }

    @Test
    public void testBoxContent(){
        Assert.assertTrue( SudokuValidator.checkRowContent(groupCorrect));
        Assert.assertFalse( SudokuValidator.checkRowContent(groupMore));
        Assert.assertFalse( SudokuValidator.checkRowContent(groupLess));
        Assert.assertFalse( SudokuValidator.checkRowContent(groupDuplicates));
    }

    @Test
    public void testRowsValidation(){
        Assert.assertFalse( SudokuValidator.validateRows(fieldDuplicates));
        Assert.assertFalse( SudokuValidator.validateRows(fieldOutOfRange));
        Assert.assertTrue( SudokuValidator.validateRows(fieldCorrect));
    }

    @Test
    public void testColumnsValidation(){
        Assert.assertFalse( SudokuValidator.validateColumns(fieldDuplicates));
        Assert.assertFalse( SudokuValidator.validateColumns(fieldOutOfRange));
        Assert.assertTrue( SudokuValidator.validateColumns(fieldCorrect));
    }

    @Test
    public void testBoxesValidation(){
        Assert.assertFalse(SudokuValidator.validateBoxes(fieldDuplicates));
        Assert.assertFalse( SudokuValidator.validateBoxes(fieldOutOfRange));
        Assert.assertFalse(SudokuValidator.validateBoxes(fieldCorrectRowsColsWrongBoxes));
        Assert.assertTrue(SudokuValidator.validateBoxes(fieldCorrect));
    }


    @Test
    public void testBoxesToArrays(){
        Assert.assertTrue(
                Arrays.deepEquals(fieldTransformed,
                        SudokuValidator.boxesToArrays(fieldCorrect)));
        Assert.assertFalse(
                Arrays.deepEquals(fieldTransformed,
                        SudokuValidator.boxesToArrays(fieldDuplicates)));
    }

    @Test
    public void testTransposeArray(){
        Assert.assertTrue( Arrays.deepEquals(subArrayTransponed,
                        SudokuValidator.transposeArray(subArray)));
        Assert.assertFalse( Arrays.deepEquals(subArray,
                        SudokuValidator.transposeArray(subArray)));
    }

    @Test
    public void testFieldSize(){
        Assert.assertTrue(SudokuValidator.validateFieldSize(fieldCorrect));
        Assert.assertFalse(SudokuValidator.validateFieldSize(subArray));
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
