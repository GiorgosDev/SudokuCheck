package com.gio.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SudokuValidatorTest {

//DONE  # - validate number range
//todo  # - read file csv <<<<
//DONE  # - validate group sum
//DONE  # - validate group pattern
//DONE  # - validate field rows
//DONE  # - validate field columns
//DONE  # - validate field groups
//DONE  # - transform groups to rows(arrays)
//DONE  # - sub array
//DONE  # - transpose array
//todo  # - return validation failure reason
//DONE  # - implement field size validation
//DONE  # - refactor test group sum (streams too slow)

    @Test
    public void testNumberRange(){
        Assert.assertTrue(validator.validate(5));
        Assert.assertFalse(validator.validate(10));
        Assert.assertFalse(validator.validate(0));
        Assert.assertFalse(validator.validate(-1));
    }

    @Test
    public void testBoxSum(){
        Assert.assertTrue( validator.checkBoxSum(groupCorrect));
        Assert.assertTrue( validator.checkBoxSum(groupDuplicates));
        Assert.assertFalse( validator.checkBoxSum(groupMore));
        Assert.assertFalse( validator.checkBoxSum(groupLess));
    }

    @Test
    public void testBoxContent(){
        Assert.assertTrue( validator.checkBoxContent(groupCorrect));
        Assert.assertFalse( validator.checkBoxContent(groupMore));
        Assert.assertFalse( validator.checkBoxContent(groupLess));
        Assert.assertFalse( validator.checkBoxContent(groupDuplicates));
    }

    @Test
    public void testRowsValidation(){
        Assert.assertFalse( validator.validateRows(fieldDuplicates));
        Assert.assertTrue( validator.validateRows(fieldCorrect));
    }

    @Test
    public void testColumnsValidation(){
        Assert.assertFalse( validator.validateColumns(fieldDuplicates));
        Assert.assertTrue( validator.validateColumns(fieldCorrect));
    }

    @Test
    public void testBoxesValidation(){
        Assert.assertFalse(validator.validateBoxes(fieldDuplicates));
        Assert.assertFalse(validator.validateBoxes(fieldCorrectRowsColsWrongBoxes));
        Assert.assertTrue(validator.validateBoxes(fieldCorrect));
    }


    @Test
    public void testBoxesToArrays(){
        Assert.assertTrue(
                Arrays.deepEquals(fieldTransformed,
                        validator.boxesToArrays(fieldCorrect)));
        Assert.assertFalse(
                Arrays.deepEquals(fieldTransformed,
                        validator.boxesToArrays(fieldDuplicates)));
    }

    @Test
    public void testTransposeArray(){
        Assert.assertTrue( Arrays.deepEquals(subArrayTransponed,
                        validator.transposeArray(subArray)));
        Assert.assertFalse( Arrays.deepEquals(subArray,
                        validator.transposeArray(subArray)));
    }

    @Test
    public void testFieldSize(){
        Assert.assertTrue(validator.validateFieldSize(fieldCorrect));
        Assert.assertFalse(validator.validateFieldSize(subArray));
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
        validator = new SudokuValidator();
    }

    int [] groupCorrect;
    int [] groupMore;
    int [] groupLess;
    int [] groupDuplicates;
    int [][] fieldCorrect;
    int [][] fieldDuplicates;
    int [][] fieldTransformed;
    int [][] fieldCorrectRowsColsWrongBoxes;
    int [][] subArray;
    int [][] subArrayTransponed;
    SudokuValidator validator;

}
