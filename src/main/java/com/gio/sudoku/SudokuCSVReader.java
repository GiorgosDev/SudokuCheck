package com.gio.sudoku;

import com.gio.sudoku.exceptions.IncorrectCharException;
import com.gio.sudoku.exceptions.IncorrectInputRowLengthException;
import com.gio.sudoku.exceptions.SudokuException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.gio.sudoku.SudokuConstants.SUDOKU_CSV_SEPARATOR;
import static com.gio.sudoku.SudokuConstants.SUDOKU_FIELD_SIDE_LENGTH;

public class SudokuCSVReader {
    public int[][] readField(String filePath) throws SudokuException, FileNotFoundException {
        int[][] field = new int[9][];
        String url = getClass().getResource(filePath).getFile();
        try(Scanner in = new Scanner(new File(url))){
            int i = 0;
            while(in.hasNext()){
                String[] numbers = in.nextLine().split(SUDOKU_CSV_SEPARATOR);
                if(numbers.length != SUDOKU_FIELD_SIDE_LENGTH)
                    throw new IncorrectInputRowLengthException();
                field[i] = convertStringArrayToInt(numbers);
                i++;
            }
        }

        return field;
    }

    protected int[] convertStringArrayToInt(String[] numbers) throws SudokuException{
        int[] row = new int[numbers.length];
        try{
            for(int i = 0; i< numbers.length; i++){
                row[i] = Integer.parseInt(numbers[i].trim());
            }
            return row;
        } catch (NumberFormatException e){
            throw new IncorrectCharException();
        }
    }
}
