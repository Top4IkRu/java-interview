package spring;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionService {
    private final TransactionTemplate transactionTemplate;

    public TransactionService(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Transactional
    public void withInternalTransaction() {
        int one = 1, two = 2;
        internalTransaction();
        System.out.println(one + two);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                internalTransaction();
            }
        });
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void internalTransaction() {
        System.out.println("Internal transaction call");
    }

    @Transactional
    public void longTransaction() throws InterruptedException {
        System.out.println("Start long work.");
        Thread.sleep(10000);
        System.out.println("Work is completed.");
    }
}
