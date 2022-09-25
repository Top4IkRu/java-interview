# Популярные вопросы

1. [Что такое многопоточность и зачем она нужна в Java?](#что-такое-многопоточность-и-зачем-она-нужна-в-java)
2. [Как создать и запустить поток в Java?](#как-создать-и-запустить-поток-в-java)
3. [Что такое race condition и как его избежать в Java?](#что-такое-race-condition-и-как-его-избежать-в-java)
4. [Какие методы синхронизации доступны в Java и в чем их различия?](#какие-методы-синхронизации-доступны-в-java-и-в-чем-их-различия)
5. [Что такое монитор (monitor) и как он связан с блокировками в Java?](#что-такое-монитор-monitor-и-как-он-связан-с-блокировками-в-java)
6. [Что такое deadlock (взаимная блокировка) и как его избежать?](#что-такое-deadlock-взаимная-блокировка-и-как-его-избежать)
7. [Как работает пул потоков (thread pool) в Java и как его создать?](#как-работает-пул-потоков-thread-pool-в-java-и-как-его-создать)
8. [Что такое Callable и Future в Java concurrency?](#что-такое-callable-и-future-в-java-concurrency)

---

## Ответы

### Что такое многопоточность и зачем она нужна в Java?

Многопоточность позволяет выполнять несколько потоков одновременно, что повышает производительность и позволяет
эффективнее использовать ресурсы системы.

```java
public class MultiThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            // Код, выполняемый в потоке 1
        });

        Thread thread2 = new Thread(() -> {
            // Код, выполняемый в потоке 2
        });

        thread1.start();
        thread2.start();
    }
}

```

---

### Как создать и запустить поток в Java?

В Java поток можно создать путем наследования от класса Thread или путем реализации интерфейса Runnable.

```java
// Путем наследования от класса Thread
public class MyThread extends Thread {
    public void run() {
        // Код, выполняемый в потоке
    }
}

// Путем реализации интерфейса Runnable
public class MyRunnable implements Runnable {
    public void run() {
        // Код, выполняемый в потоке
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
    }
}

```

---

### Что такое race condition и как его избежать в Java?

Race condition возникает, когда несколько потоков пытаются одновременно обращаться к общим данным и вносить изменения в
них, что может привести к непредсказуемым результатам. Чтобы избежать race condition, можно использовать синхронизацию,
например, с помощью ключевого слова **synchronized**.

```java
public class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        // Ожидаем завершения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Результат: " + counter.getCount());
    }
}

```

---

### Какие методы синхронизации доступны в Java и в чем их различия?

В Java доступны несколько методов синхронизации, таких как использование ключевого слова synchronized, использование
блокировок (например, **Lock** из пакета _java.util.concurrent_), использование условных переменных (**Condition**) и
атомарных классов (например, **AtomicInteger** из пакета _java.util.concurrent.atomic_). Различия заключаются в
механизмах, которые они предоставляют для обеспечения синхронизации и контроля доступа к общим данным.

#### Synchronized

Ключевое слово synchronized может использоваться для синхронизации
методов и блоков кода. Оно обеспечивает взаимное исключение и гарантирует, что только один поток может одновременно
выполнять код, защищенный блокировкой synchronized.

```java
public class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }
}
```

##### Особенности

1. Простота использования, поскольку блокировка происходит автоматически при входе в синхронизированный метод или блок
   кода.
2. Взаимное исключение гарантировано, так как только один поток может одновременно выполнять код, защищенный блокировкой
   **synchronized**.
3. Ключевое слово **synchronized** автоматически обеспечивает синхронизацию монитора объекта, на котором оно
   используется.

#### Использование блокировок - Lock

Блокировки представлены интерфейсом **Lock** и его реализациями,
такими как **ReentrantLock**. Блокировки обеспечивают более гибкий контроль над блокировками,
чем ключевое слово **synchronized**. Они позволяют управлять захватом и освобождением блокировок вручную
и поддерживать более сложные сценарии синхронизации.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```

##### Особенности

1. Блокировки являются более гибкими, чем ключевое слово **synchronized**, поскольку они позволяют управлять захватом и
   освобождением блокировок вручную.
2. Можно использовать несколько условных переменных (**Condition**) с одной блокировкой для организации сложной логики
   синхронизации.
3. Можно использовать попытки захвата блокировки с ожиданием определенного времени (```tryLock()```) и различные
   стратегии ожидания (**LockSupport**).

#### Использование условных переменных (**Condition**).

Условные переменные позволяют потокам ждать определенных условий и уведомлять другие потоки о выполнении этих условий.
Они используются вместе с блокировками и предоставляют дополнительные возможности для синхронизации.

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Message {
    private String message;
    private boolean empty = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public String read() {
        lock.lock();
        try {
            while (empty) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = true;
            condition.signalAll();
            return message;
        } finally {
            lock.unlock();
        }
    }

    public void write(String message) {
        lock.lock();
        try {
            while (!empty) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = false;
            this.message = message;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
```

##### Особенности

1. Условные переменные позволяют потокам ждать определенных условий и уведомлять другие потоки о выполнении этих
   условий.
2. Условные переменные используются вместе с блокировками и позволяют более точно управлять ожиданием и уведомлением
   потоков.
3. Методы ```await()```, ```signal()```, ```signalAll()``` позволяют потокам взаимодействовать с условными переменными.

### Что такое монитор (monitor) и как он связан с блокировками в Java?

Монитор - это средство синхронизации, используемое в Java для обеспечения взаимного исключения и управления доступом к
общим данным. В Java монитор связан с блокировками, такими как блокировки **synchronized**. Каждый объект в Java имеет
связанный с ним монитор, который блокируется и разблокируется при использовании блокировок **synchronized**. Это
позволяет гарантировать, что только один поток может одновременно выполнять код, защищенный блокировкой
**synchronized**.

Пример с использованием блокировки synchronized:

```java
public class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }
}
```

Пример с использованием метода wait() и notify():

```java
public class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

```

### Что такое deadlock (взаимная блокировка) и как его избежать?

Взаимная блокировка, или deadlock, возникает, когда два или более потока оказываются заблокированными и ожидают друг
друга для освобождения ресурсов. Как результат, потоки останавливаются и не могут продолжить свою работу.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void firstCall() {
        lock1.lock();
        try {
            // Критическая секция, требующая lock2
            lock2.lock();
            try {
                // Выполнение операций
            } finally {
                lock2.unlock();
            }
        } finally {
            lock1.unlock();
        }
    }

    public void secondCall() {
        lock2.lock();
        try {
            // Критическая секция, требующая lock1
            lock1.lock();
            try {
                // Выполнение операций
            } finally {
                lock1.unlock();
            }
        } finally {
            lock2.unlock();
        }
    }
}
```

#### Как избежать deadlock

Чтобы избежать deadlock, необходимо следовать некоторым правилам:

1. Избегайте циклической зависимости блокировок.
2. Используйте только одну блокировку за раз, если это возможно.
3. Используйте стратегии предотвращения deadlock, такие как упорядочивание блокировок или ожидание с тайм-аутом.
4. Используйте инструменты анализа deadlock, чтобы выявить потенциальные проблемы заранее.

### Как работает пул потоков (thread pool) в Java и как его создать?

Пул потоков (**thread pool**) в Java представляет собой группу предварительно созданных потоков, которые могут
выполнять задачи асинхронно. Он обеспечивает эффективное управление потоками и повторное использование уже созданных
потоков для выполнения задач.
В Java пул потоков можно создать с использованием класса **ExecutorService**, который предоставляет интерфейс для
управления потоками и выполнения задач.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); // Создание пула потоков с фиксированным размером

        for (int i = 0; i < 10; i++) {
            Runnable task = new MyTask();
            executor.execute(task); // Передача задачи на выполнение пулу потоков
        }

        executor.shutdown(); // Завершение работы пула потоков
    }
}

class MyTask implements Runnable {
    public void run() {
        // Код задачи
    }
}
```

### Что такое Callable и Future в Java concurrency?

**Callable** и **Future** - это интерфейсы в пакете *java.util.concurrent*, предоставляющие возможность возвращать
результаты выполнения задач в многопоточной среде.

**Callable** - это функциональный интерфейс, представляющий задачу, которая может быть выполнена и возвращать результат.
Он объявляет метод ```call()```, который возвращает результат выполнения задачи.

**Future** - это интерфейс, представляющий результат выполнения задачи, который может быть доступен в будущем.
Он предоставляет методы для проверки статуса задачи, ожидания ее выполнения и получения результата.

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = new MyTask();

        Future<Integer> future = executor.submit(task); // Передача задачи на выполнение и получение Future

        // Другие действия...

        try {
            Integer result = future.get(); // Ожидание результата выполнения задачи
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

class MyTask implements Callable<Integer> {
    public Integer call() throws Exception {
        // Код задачи
        return 1; // Возврат результата
    }
}
```

## Дополнительные материалы

### Статьи

1. [Notes On Concurrency In Jvm](https://wuciawe.github.io/jvm/2017/02/13/notes-on-concurrency-in-jvm.html)
2. [Разбор основных концепций параллелизма](https://habr.com/ru/company/otus/blog/353414/)
3. [А как же всё-таки работает многопоточность? Часть I: синхронизация](https://web.archive.org/web/20220628134440/https://habr.com/ru/post/143237/)
4. [Модель памяти в примерах и не только](https://web.archive.org/web/20220519121335/https://habr.com/en/post/133981/)
5. [Глубокое погружение в Java Memory Model](https://habr.com/en/articles/685518/)
6. [JSR 133 (Java Memory Model)](https://habr.com/en/companies/golovachcourses/articles/221133/)
7. [Lock-Free Data](https://www.baeldung.com/lock-free-programming)
8. [Difference Between Java Threads and OS Threads](https://www.geeksforgeeks.org/difference-between-java-threads-and-os-threads/)

### Youtube лекции

1. [Алексей Шипилёв — Перформанс: Что В Имени Тебе Моём?](https://youtu.be/CgRJUqO-dMQ)
2. [Глеб Смирнов — Расчленяя многопоточность](https://youtu.be/arGcok_I_DY)
3. [Роман Елизаров — Многопоточное программирование — теория и практика](https://youtu.be/mf4lC6TpclM)
4. [Алексей Шипилёв - Java Memory Model Pragmatics, part 1](https://youtu.be/noDnSV7NCtw)
5. [Алексей Шипилёв - Java Memory Model Pragmatics, part 2](https://youtu.be/Ky1_5mabd18)
6. [Роман Елизаров — Жди своего счастья без блокировки!](https://youtu.be/XivoUctdPIU)