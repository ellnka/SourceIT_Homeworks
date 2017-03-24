package edu.source.it.lectures.lecture5.examples.figures;

import edu.source.it.lectures.lecture5.examples.figures.AbstractFigure;

public class Square extends AbstractFigure {
    private int x1, y1;
    private int x2, y2;

    public Square(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        if (y2 - y1 != x2 -x1) {
            System.out.println("It's not a square");
        }
    }

    @Override
    public double getSquare() {
        return Math.pow((x2-x1), 2);
    }
}
