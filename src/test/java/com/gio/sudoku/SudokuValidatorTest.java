package com.gio.sudoku;

//DONE  # - validate number range
//todo  # - read file csv
//todo  # - validate row sum ? is enough
//todo  # - validate column sum
//todo  # - validate row duplicates
//todo  # - validate column duplicates
//todo  # - validate duplicates parallel implementation
//todo  # - validate while reading ?


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
}
