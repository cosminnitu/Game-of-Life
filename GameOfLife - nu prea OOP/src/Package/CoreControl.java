package Package;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CoreControl {

     static JFrame window;
     Grid grid;

    public static char[][] matrix;
    static boolean bec = false;

    public CoreControl(char [][] matrix){
        this.matrix = matrix;
    }

    public static class Grid extends JPanel {

        private List<Point> fillCells;

        public Grid() {
            fillCells = new ArrayList<>(10000);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point fillCell : fillCells) {
                int cellX = 20 + (fillCell.x * 20);
                int cellY = 20 + (fillCell.y * 20);
                g.setColor(Color.RED);
                g.fillRect(cellY, cellX, 20, 20);
            }

            g.setColor(Color.BLACK);
            g.drawRect(20, 20, matrix.length*20, matrix.length*20);

            for (int i = 20; i <= matrix.length*20; i += 20) {
                g.drawLine(i, 20, i, matrix.length*20 + 20);
            }

            for (int i = 20; i <= matrix.length*20; i += 20) {
                g.drawLine(20, i, matrix.length*20 + 20, i);
            }
        }

        public void fillCell(int x, int y) {
            fillCells.add(new Point(x, y));
            repaint();
        }

    }

    public void show(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                if(bec == false) {
                    window = new JFrame();

                    bec = true;
                }
                    grid = new Grid();
                    window.setSize(matrix.length * 20 + 100, matrix.length * 20 + 100);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setVisible(true);

                    window.add(grid);

                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix.length; j++) {
                            if (matrix[i][j] == 'x') {
                                grid.fillCell(i, j);
                            }
                        }
                    }


            }

        });
    }
}