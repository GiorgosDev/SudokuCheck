package com.gio.sudoku;

//DONE  # - validate number range
//todo  # - read file csv
//DONE  # - validate group sum
//todo  # - validate row pattern
//todo  # - validate duplicates parallel implementation
//todo  # - validate while reading ?
//todo  # - small type
//todo refactor to reuse sum check

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SudokuValidatorTest {
    int [] groupCorrect;
    int [] groupMore;
    int [] groupLess;
    int [] groupDuplicates;
    SudokuValidator validator;

    @Before
    public void initTestGroups(){
        groupCorrect = new int [] {1, 2 ,3, 4, 5, 6, 7, 8, 9};
        groupMore = new int [] {1, 2 ,3, 4, 5, 6, 7, 9, 9};
        groupLess = new int [] {1, 2 ,3, 4, 5, 6, 7, 1, 1};
        groupDuplicates = new int [] {8, 2 ,4, 4, 5, 6, 7, 8, 1};
        validator = new SudokuValidator();
    }

    @Test
    public void testNumberRange(){
        Assert.assertEquals(true, validator.validate(5));
        Assert.assertEquals(false, validator.validate(10));
        Assert.assertEquals(false, validator.validate(0));
        Assert.assertEquals(false, validator.validate(-1));
    }

    @Test
    public void testColumnSum(){
        Assert.assertEquals( true, validator.checkGroupSum(groupCorrect));
        Assert.assertEquals( true, validator.checkGroupSum(groupDuplicates));
        Assert.assertEquals( false, validator.checkGroupSum(groupMore));
        Assert.assertEquals( false, validator.checkGroupSum(groupLess));
    }

    @Test
    public void testColumnContent(){
        Assert.assertEquals( true, validator.checkGroupContent(groupCorrect));
        Assert.assertEquals( false, validator.checkGroupContent(groupMore));
        Assert.assertEquals( false, validator.checkGroupContent(groupLess));
        Assert.assertEquals( false, validator.checkGroupContent(groupDuplicates));
    }



}
