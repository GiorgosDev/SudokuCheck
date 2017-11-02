package com.gio.sudoku;

//DONE  # - validate number range
//todo  # - read file csv
//DONE  # - validate group sum
//DONE  # - validate group pattern
//todo  # - validate duplicates parallel implementation
//todo  # - validate while reading ?
//todo  # - small type
//todo  # - refactor to reuse sum check
//DONE  # - validate field rows
//todo  # - validate field columns
//todo  # - validate field groups ?
//DONE  # - sub array
//DONE  # - transpose array

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SudokuValidatorTest {
    int [] groupCorrect;
    int [] groupMore;
    int [] groupLess;
    int [] groupDuplicates;
    int [][] fieldCorrect;
    int [][] fieldDuplicates;
    int [][] subArray;
    int [][] subArrayTransponed;
    SudokuValidator validator;



    @Test
    public void testNumberRange(){
        Assert.assertEquals(true, validator.validate(5));
        Assert.assertEquals(false, validator.validate(10));
        Assert.assertEquals(false, validator.validate(0));
        Assert.assertEquals(false, validator.validate(-1));
    }

    @Test
    public void testGroupSum(){
        Assert.assertEquals( true, validator.checkGroupSum(groupCorrect));
        Assert.assertEquals( true, validator.checkGroupSum(groupDuplicates));
        Assert.assertEquals( false, validator.checkGroupSum(groupMore));
        Assert.assertEquals( false, validator.checkGroupSum(groupLess));
    }

    @Test
    public void testGroupContent(){
        Assert.assertEquals( true, validator.checkGroupContent(groupCorrect));
        Assert.assertEquals( false, validator.checkGroupContent(groupMore));
        Assert.assertEquals( false, validator.checkGroupContent(groupLess));
        Assert.assertEquals( false, validator.checkGroupContent(groupDuplicates));
    }

    @Test
    public void testRowsValidation(){
        Assert.assertEquals( false, validator.validateRows(fieldDuplicates));
        Assert.assertEquals( true, validator.validateRows(fieldCorrect));
    }

    @Test
    public void testColumnsValidation(){
        Assert.assertEquals( false, validator.validateColumns(fieldDuplicates));
        Assert.assertEquals( true, validator.validateColumns(fieldCorrect));
    }

    @Test
    public void testSubArray(){
        Assert.assertEquals( true,
                Arrays.deepEquals(subArray,
                        validator.subArray(fieldCorrect, 0, 0, 1, 3)));
        Assert.assertEquals( false,
                Arrays.deepEquals(subArray,
                        validator.subArray(fieldDuplicates, 0, 0, 1, 3)));
    }

    @Test
    public void testTransposeArray(){
        Assert.assertEquals( true,
                Arrays.deepEquals(subArrayTransponed,
                        validator.transposeArray(subArray)));
        Assert.assertEquals( false,
                Arrays.deepEquals(subArray,
                        validator.transposeArray(subArray)));
    }


    @Before
    public void initTestGroups(){
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

}
