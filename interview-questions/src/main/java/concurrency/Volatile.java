package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Основная цель volatile - гарантировать, что чтение и запись значения переменной будут атомарными (неделимыми) операциями
 * и что изменения, внесенные одним потоком, будут видны другим потокам немедленно. Без использования volatile или
 * других механизмов синхронизации, изменения переменной, внесенные одним потоком, могут не отразиться в значениях,
 * видимых другим потокам.
 * <p>
 * ATTENTION: concurrency.Volatile сам по себе не гарантирует атомарности или последовательности операций.
 * <p>
 * Доп материалы:
 * 1. <a href="https://www.baeldung.com/java-volatile">concurrency.Volatile</a>
 * 2. <a href="https://www.baeldung.com/java-atomic-variables">Atomic</a>
 */

public class Volatile {

    private static int value = 0;
    private static volatile int volatileValue = value;
    private static final AtomicInteger atomicInteger = new AtomicInteger(value);

    public static void main(String[] args) throws InterruptedException {
        int repeatTime = 1000;
        int numberOfThreads = 100;
        int expect = repeatTime * numberOfThreads;

        doTheWorkInParallel(repeatTime, numberOfThreads, (index) -> value++);
        System.out.printf("Int value: expect = %d, actual = %d\n", expect, value);

        doTheWorkInParallel(repeatTime, numberOfThreads, (index) -> volatileValue++);
        System.out.printf("Int volatile value: expect = %d, actual = %d\n", expect, volatileValue);

        doTheWorkInParallel(repeatTime, numberOfThreads, (index) -> atomicInteger.incrementAndGet());
        System.out.printf("Atomic int value: expect = %d, actual = %d\n", expect, atomicInteger.get());
    }


    private static void doTheWorkInParallel(
            int repeatTime,
            int numberOfThreads,
            Consumer<Integer> action
    ) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < repeatTime; i++) action.accept(i);
        };

        Thread[] workers = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            workers[i] = new Thread(runnable, String.valueOf(i));
            workers[i].start();
        }

        for (int j = 0; j < numberOfThreads; j++) workers[j].join();
    }
}
