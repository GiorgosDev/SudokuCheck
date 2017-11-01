package com.gio.sudoku;

//DONE  # - validate number range
//todo  # - read file csv
//todo  # - validate row sum ? is enough
//todo  # - validate column sum
//todo  # - validate row duplicates
//todo  # - validate column duplicates
//todo  # - validate duplicates parallel implementation
//todo  # - validate while reading ?
//todo  # - small type

import org.junit.Assert;
import org.junit.Test;

public class SudokuValidatorTest {

    @Test
    public void testNumberRange(){
        SudokuValidator validator = new SudokuValidator();
        Assert.assertEquals(true, validator.validate(5));
        Assert.assertEquals(false, validator.validate(10));
        Assert.assertEquals(false, validator.validate(0));
        Assert.assertEquals(false, validator.validate(-1));
    }

    @Test
    public void testColumnSum(){
        int [] columnCorrect = new int [] {1, 2 ,3, 4, 5, 6, 7, 8, 9};
        int [] columnMore = new int [] {1, 2 ,3, 4, 5, 6, 7, 9, 9};
        int [] columnLess = new int [] {1, 2 ,3, 4, 5, 6, 7, 1, 1};

        SudokuValidator validator = new SudokuValidator();
        Assert.assertEquals( true, validator.checkColumn(columnCorrect));
        Assert.assertEquals( false, validator.checkColumn(columnMore));
        Assert.assertEquals( false, validator.checkColumn(columnLess));
    }
}
