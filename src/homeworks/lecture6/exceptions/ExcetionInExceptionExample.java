package edu.source.it.lectures.lecture6.examples.exceptions;

public class ExcetionInExceptionExample {
    public static void main(String[] args) {
        try {
            try {
                throw new RuntimeException("RtE");
            } catch (RuntimeException e) {
                throw new Exception(e);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
