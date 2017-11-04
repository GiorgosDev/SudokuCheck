package com.gio.sudoku;

import com.gio.sudoku.exceptions.IncorrectInputFieldSizeException;
import com.gio.sudoku.exceptions.SudokuException;

import java.io.FileNotFoundException;

import static com.gio.sudoku.SudokuConstants.*;

public class SudokuValidationApplication {
    public static void main(String[] args){
        if(checkArgs(args)){
            final String filename = args[0];
            try{

                if (SudokuValidator.validate(filename)){
                    System.out.println(VALID_RESPONSE);
                    System.out.println(PROCESSED);
                }
            } catch (FileNotFoundException e) {
                System.out.println(INVALID_RESPONSE);
                System.out.println(ERROR);
                System.out.println(String.format(ERR_FILE_NOT_FOUND, filename));

            } catch (IncorrectInputFieldSizeException e) {
                System.out.println(INVALID_RESPONSE);
                System.out.println(ERROR);
                System.out.println(ERR_FIELD_SIZE);
            } catch (SudokuException e) {
                System.out.println(INVALID_RESPONSE);
                System.out.println(PROCESSED);
                System.out.println(e.getMessage());
            }
        }

    }

    private static boolean checkArgs(String[] args) {
        if(args.length == 0){
            System.out.println(ERR_NO_ARG);
            return false;
        }
        return true;
    }


}
