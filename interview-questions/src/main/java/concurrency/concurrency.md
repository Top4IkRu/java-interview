# Популярные вопросы

1. [Что такое многопоточность и зачем она нужна в Java?](#что-такое-многопоточность-и-зачем-она-нужна-в-java)
2. [Как создать и запустить поток в Java?](#как-создать-и-запустить-поток-в-java)
3. [Что такое race condition и как его избежать в Java?](#что-такое-race-condition-и-как-его-избежать-в-java)
4. [Какие методы синхронизации доступны в Java и в чем их различия?](#какие-методы-синхронизации-доступны-в-java-и-в-чем-их-различия)
5. [Что такое монитор (monitor) и как он связан с блокировками в Java?](#что-такое-монитор-monitor-и-как-он-связан-с-блокировками-в-java)

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