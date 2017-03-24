package edu.source.it.lectures.lecture5.examples.figures;

public class FiguresTest {
    public static void main(String[] args) {
        Figure figure = new Circle(0, 0, 1);
        figure.introduce();
        System.out.println("Circles square is " + figure.getSquare());

        Figure square = new Square(0, 0, 1, 1);
        square.introduce();
        System.out.println("Square's square is " + square.getSquare());

        System.out.println(1 + 1);
        System.out.println("ab" + "ba");
    }

    public static Figure getFigure() {
        return new Square(0, 0, 1, 1);
    }
}
