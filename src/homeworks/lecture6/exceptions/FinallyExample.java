package edu.source.it.lectures.lecture6.examples.exceptions;

public class FinallyExample {
    public static void main(String[] args) {
        /*try {
            int i = 1 / 0;
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
            System.exit(0);
        } finally {
            System.out.println("I'm in finally");
        }*/

        /*try {
            int i = 1 / 0;

        } finally {
            System.out.println("I'm in finally");
        }*/

        try {
            throw new RuntimeException();
        } finally {
            throw new Error();
        }
    }
}














