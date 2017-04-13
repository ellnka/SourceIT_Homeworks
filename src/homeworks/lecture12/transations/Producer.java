package homeworks.lecture12.transations;

import java.util.Deque;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private static final Random random = new Random();
    private static int count = 0;
    private int number;
    private List<Account> accounts;
    private Deque<Transaction> transactionsQueue;

    public Producer(List<Account> accounts, Deque<Transaction> transactionsQueue) {
        this.accounts = accounts;
        this.transactionsQueue = transactionsQueue;
        number = ++count;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Producer number " + number + " was interrupted");
                return;
            }
            int fromIndex = random.nextInt(accounts.size());
            int toIndex = random.nextInt(accounts.size());
            Account from = accounts.get(fromIndex);
            Account to = accounts.get(toIndex);
            long amount = random.nextInt(10_000);
            Transaction transaction = new Transaction(from, to, amount);

            //ToDo: WOW-WOW!!!!
            synchronized (transactionsQueue) {
                transactionsQueue.addLast(transaction);
                /* start: added by EY : wake up, queue, new  element is added. Consumer can take one now*/
                transactionsQueue.notify();
                /* end: added by EY */
            }
        }
        System.out.println("Finished work in producer number " + number);
    }
}
