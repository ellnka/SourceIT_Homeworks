package homeworks.lecture4;

public class FibonacciExample {
    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        // The first 15 Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377
        // The Fibonacci sequence using a recursive function
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 35; i++) {
            System.out.print(((i > 0) ? ", " : "") + fibonacciRecursion(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("\n\rRecursion took = " + (endTime - startTime) + " ms");

        // The Fibonacci sequence using a loop
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 35; i++) {
            System.out.print(((i > 0) ? ", " : "") + fibonacciLoop(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("\n\rLoop took = " + (endTime - startTime) + " ms");
    }


    public static int fibonacciRecursion(int n) {
        if (n < 0) {
            System.out.println("Illegal argument");
            return -1;
        }
        return (n < 2) ? n : fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
    }


    public static int fibonacciLoop(int n) {
        if (n < 0) {
            System.out.println("Illegal argument");
            return -1;
        }

        int lastNumber = 1;
        int preLastNumber = 1;
        int result = 0;

        for(int i = 0; i < n; i++) {
            preLastNumber = lastNumber;
            lastNumber = result;
            result = lastNumber + preLastNumber;
        }

        return result;
    }


}
