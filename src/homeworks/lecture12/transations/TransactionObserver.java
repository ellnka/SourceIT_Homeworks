package homeworks.lecture12.transations;

import java.util.Deque;


/**
 * Created by ElenaY on 4/13/2017.
 */

public class TransactionObserver implements Runnable {
    private Deque<Transaction> transactionsQueue;

    public TransactionObserver(Deque<Transaction> transactionsQueue) {
        this.transactionsQueue = transactionsQueue;
    }

    @Override
    public void run() {
        int prevCountElementsInQueue = 0;
        while(!Thread.currentThread().isInterrupted()) {

            int countElementsInQueue = 0;
            try {
                synchronized (transactionsQueue) {
                    countElementsInQueue = transactionsQueue.size();
                    if (countElementsInQueue == 0) {
                        System.out.println("Wait!");
                        transactionsQueue.wait();
                        System.out.println("Continue!");
                    }
                }


            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (countElementsInQueue != prevCountElementsInQueue) {
                System.out.println("Queue size now is " + countElementsInQueue);
            }
            prevCountElementsInQueue = countElementsInQueue;

            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {*//*NOP*//*}*/
        }
    }




}
