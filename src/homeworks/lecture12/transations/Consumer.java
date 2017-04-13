package homeworks.lecture12.transations;

import java.util.Deque;

public class Consumer implements Runnable {
    private static int count = 0;
    private int number;
    private Deque<Transaction> transactionsQueue;

    public Consumer(Deque<Transaction> transactions) {
        this.transactionsQueue = transactions;
        number = ++count;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                System.out.println("Consumer number " + number + " was interrupted");
                return;
            }

            Transaction transaction = null;
            synchronized (transactionsQueue) {
                transaction = transactionsQueue.pollFirst();
            }

            if (transaction == null) {
                //ToDo : I should wait!

                /* start: added by EY : Wait, queue, you're empty. You'll be notified when you can continue*/
                try {
                    synchronized (transactionsQueue) {
                       System.out.println("Transaction#" + number + " is waiting for notification...");
                       transactionsQueue.wait();
                       System.out.println("Transaction#" + number + " has been notified");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Transaction has been interrupted!");
                    System.out.println("No new transactionsQueue in list for consumer " + number);
                }
                /* end: added by EY */

            } else {
                if (!transaction.perform()) {
                    System.out.println("Transaction was not performed " + transaction);
                }
            }
        }

        System.out.println("Finished work in consumer number " + number);
    }
}
