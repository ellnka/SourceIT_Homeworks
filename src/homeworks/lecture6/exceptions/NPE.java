package edu.source.it.lectures.lecture6.examples.exceptions;

public class NPE {
    public static void main(String[] args) {
        Object o = null;

        /*try {
            o.equals("");
        } catch (NullPointerException npe) {
            *//*NOP*//*
        }*/

        if (o != null) {
            o.equals("");
        }
    }
}
