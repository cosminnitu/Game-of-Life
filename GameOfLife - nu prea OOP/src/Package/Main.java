package Package;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Grid con = new Grid(15, 15);
        con.generateMatrix();

        System.out.println("First Generation: ");

        for (char[] row : con.mat) {
            System.out.println(Arrays.toString(row));
        }

        CoreControl core;

        core = new CoreControl(con.mat);
        core.show();

        Thread.sleep(500);

        for(int i = 0; i < 500; i++) {
            FutureGeneration future = new FutureGeneration(con);
            future.nextGen();
            future.rulesOfLife();
            core = new CoreControl(future.getter());
            core.show();
            Thread.sleep(100);
        }



    }
}



