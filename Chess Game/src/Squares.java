/******************************************************************************
 *  Compilation:  javac Squares.java
 *  Execution:    java Squares n
 *  Dependencies: Draw.java DrawListener.java
 *
 *  Draw an n-by-n grid of squares. User clicks a grid
 *  square. Alternate between drawing a red or blue circle
 *  in the grid square.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.Color;

public class Squares implements DrawListener {
    private int pieces = 0;
    private Draw draw = new Draw();

    public Squares(int n) {
        draw.addListener(this);
        draw.setXscale(0, n);
        draw.setYscale(0, n);

        // draw black grid lines with gray background
        draw.clear(Color.LIGHT_GRAY);
        draw.setPenColor(Color.BLACK);
        for (int i = 0; i <= n; i++) draw.line(i, 0, i, n);
        for (int j = 0; j <= n; j++) draw.line(0, j, n, j);
        draw.show();
    }

    public void mousePressed(double x, double y) {
        if (pieces % 2 == 0) draw.setPenColor(Color.BLUE);
        else                 draw.setPenColor(Color.RED);
        draw.filledCircle(Math.floor(x) + 0.5, Math.floor(y) + 0.5, .375);
        pieces++;
        draw.show();
    }


    public void keyTyped(char c) {
        draw.save("squares" + c + ".png");
    }

    // test client
    public static void main(String[] args) {
        int n = Integer.parseInt("20");
        new Squares(n);
    }

}
