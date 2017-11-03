package com.gio.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.gio.sudoku.SudokuConstants.SUDOKU_CSV_SEPARATOR;
import static com.gio.sudoku.SudokuConstants.SUDOKU_FIELD_SIDE_LENGTH;

public class SudokuCSVReader {
    public int[][] readField(String filePath) throws IncorrectInputRowLengthException, FileNotFoundException {
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

    private int[] convertStringArrayToInt(String[] numbers) {
        int[] row = new int[numbers.length];
        for(int i = 0; i< numbers.length; i++){
            row[i] = Integer.parseInt(numbers[i].trim());
        }
        return row;
    }
}
