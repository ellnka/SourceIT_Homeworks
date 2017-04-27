package homeworks.lecture12.transations;

import java.util.List;

public class AccountObserver implements Runnable {
    private List<Account> accounts;

    public AccountObserver(List<Account> accounts) {
        this.accounts = accounts;
    }


    /* modified by EY: accounts are locked(synchronized) while total amount is being calculated */
    @Override
    public void run() {
        long prevTotalAmount = 0;
        while(!Thread.currentThread().isInterrupted()) {

            long totalAmount = 0;
            synchronized (accounts) {
                for (Account account : accounts) {
                    totalAmount += account.getAmount();
                }
            }

            if (totalAmount != prevTotalAmount) {
                System.out.println("Total amount now is " + totalAmount);
            }
            prevTotalAmount = totalAmount;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {/*NOP*/}
        }
    }
}
