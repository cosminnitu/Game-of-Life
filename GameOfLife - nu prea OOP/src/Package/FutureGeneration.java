package Package;

public class FutureGeneration {

    private int rows;
    private int col;
    private int aliveNeighbours[][];
    private Grid cw;

    public FutureGeneration(Grid con) {
        this.rows = con.getRows();
        this.col = con.getColumns();
        aliveNeighbours = new int[rows][col];
        cw = con;
    }

    public void nextGen() {

        char allNeighbours[][] = new char[rows + 2][col + 2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                allNeighbours[i + 1][j + 1] = cw.mat[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            allNeighbours[i + 1][0] = cw.mat[i][col - 1];
            allNeighbours[i + 1][col + 1] = cw.mat[i][0];
            allNeighbours[0][i + 1] = cw.mat[rows - 1][i];
            allNeighbours[rows + 1][i + 1] = cw.mat[0][i];
        }

        allNeighbours[0][0] = cw.mat[rows - 1][col - 1];
        allNeighbours[rows + 1][0] = cw.mat[0][col - 1];
        allNeighbours[rows + 1][col + 1] = cw.mat[0][0];
        allNeighbours[0][col + 1] = cw.mat[rows - 1][0];

        for (int l = 1; l <= rows; l++) {
            for (int m = 1; m <= col; m++) {

                int count = 0;
                if (allNeighbours[l][m] == 'x') {
                    count--;
                }

                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {

                        if (allNeighbours[l + i][m + j] == 'x') {
                            count++;
                        }
                    }
                }

                aliveNeighbours[l - 1][m - 1] = count;

            }
        }
    }


    public void rulesOfLife() {

            for (int l = 0; l < rows; l++) {
                for (int m = 0; m < col; m++) {
                    if ((cw.mat[l][m] == 'x') && ((aliveNeighbours[l][m] < 2) || (aliveNeighbours[l][m] > 3))) {
                        cw.mat[l][m] = 'o';
                    } else if ((cw.mat[l][m] == 'x') && ((aliveNeighbours[l][m] == 2) || (aliveNeighbours[l][m] == 3))) {
                        cw.mat[l][m] = 'x';
                    }
                    if (cw.mat[l][m] == 'o' && aliveNeighbours[l][m] == 3) {
                        cw.mat[l][m] = 'x';
                    }
                }
            }
    }

    public char [][] getter() {
        return cw.mat;
    }

}
