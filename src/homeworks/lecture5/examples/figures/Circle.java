package edu.source.it.lectures.lecture5.examples.figures;

import com.sun.org.apache.bcel.internal.generic.NEW;
import edu.source.it.lectures.lecture5.examples.figures.AbstractFigure;

public class Circle extends AbstractFigure
        implements Figure, NewFigure {
    private int x;
    private int y;
    private float radius;

    public Circle(int x, int y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return (Math.PI * Math.pow(radius, 2));
    }
}
