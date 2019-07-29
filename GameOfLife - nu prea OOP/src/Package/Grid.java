package Package;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Grid {

    private int rows, columns;
    char [][] mat;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        mat = new char[rows][columns];
    }

    public void generateMatrix() {

        Random r = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (r.nextDouble() >= 0.5) {
                    mat[i][j] = 'x';
                } else
                    mat[i][j] = 'o';
            }
        }
    }

    public void setter(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


}

