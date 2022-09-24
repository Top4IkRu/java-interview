# Транзакции в Spring Data

Транзакции в Spring Data предоставляют механизм управления базами данных, который обеспечивает целостность данных и
поддерживает консистентность при выполнении операций чтения и записи. В этом обучающем материале мы рассмотрим основы
работы с транзакциями в Spring Data, начиная с простых примеров и постепенно переходя к более сложным сценариям.

## Основы транзакций:

Первым шагом является настройка транзакционной поддержки в вашем приложении Spring Data. Для этого можно использовать
аннотацию `@EnableTransactionManagement` в конфигурационном классе вашего приложения.

```java

@SpringBootApplication
@EnableTransactionManagement
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
   ```

## Аннотации транзакций:

В Spring Data для работы с транзакциями можно использовать несколько аннотаций, таких как `@Transactional`
и `@Modifying`.

### Transactional

Аннотация `@Transactional` является одним из ключевых элементов в Spring Framework для управления транзакциями. Она
позволяет определить транзакционное поведение для методов в вашем приложении. Аннотация `@Transactional` может быть
применена к методам или классам.

```java

@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;

    @Transactional
    public void performTransaction() {
        // Логика обернутая в транзакцию
    }
}
```

Прежде чем рассмотреть параметры аннотации `@Transactional`, давайте рассмотрим основные аспекты этой аннотации:

1. Уровень изоляции (Isolation Level). Уровень изоляции определяет, как одна транзакция видит изменения, внесенные
   другими транзакциями. Spring поддерживает различные уровни изоляции, такие
   как `DEFAULT`, `READ_UNCOMMITTED`, `READ_COMMITTED`, `REPEATABLE_READ` и `SERIALIZABLE`.

2. Поведение прокси (Proxying Behavior). Spring использует прокси для применения аспектов транзакций к методам,
   помеченным `@Transactional`. Параметр `proxyMode` позволяет определить, как должно быть создано прокси. Возможные
   значения: `DEFAULT`, `PROXY`, `ASPECTJ`.

3. Управление точками сохранения (Rollback Rules):.Параметр `rollbackFor` позволяет указать исключения, при
   возникновении которых транзакция должна быть откачена. Параметр `noRollbackFor` определяет исключения, при
   возникновении которых транзакция не должна быть откачена.

4. Таймаут транзакции (Transaction Timeout). Параметр `timeout` позволяет указать время в секундах, в пределах которого
   транзакция должна завершиться. Если время превышено, транзакция будет автоматически откачена.

5. Управление сохранением (Propagation Behavior). Параметр `propagation` определяет, как транзакция должна
   распространяться при вызове других транзакционных методов. Возможные
   значения: `REQUIRED`, `REQUIRES_NEW`, `SUPPORTS`, `NOT_SUPPORTED`, `NEVER` и `MANDATORY`.

```java

@Service
public class MyService {
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 30)
    public void performTransactionalOperation() {
        // Выполнение операций внутри транзакции
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {SQLException.class, DataAccessException.class})
    public void performAnotherTransactionalOperation() {
        // Выполнение операций внутри транзакции
    }

    @Transactional(noRollbackFor = NotFoundException.class)
    public void performTransactionalOperationWithNoRollback() {
        // Выполнение операций внутри транзакции
    }
}
```

1. В первом примере, мы указали уровень изоляции `READ_COMMITTED` и таймаут транзакции в 30 секунд.

2. Во втором примере, мы использовали распространение `REQUIRES_NEW` и определили, что транзакция должна
   откатываться при возникновении исключений `SQLException` и `DataAccessException`.

3. В третьем примере, мы указали, что исключение `NotFoundException` не должно приводить к откату транзакции.

### Modifying

`@Modifying` применяется к методам, которые выполняют изменяющие операции в базе данных, такие как добавление,
обновление или удаление данных. Например:

```java

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
    @Modifying
    @Query("UPDATE MyEntity SET name = :name WHERE id = :id")
    void updateNameById(@Param("name") String name, @Param("id") Long id);
}
```

## Управление транзакциями:

Spring Data предоставляет удобные методы для управления транзакциями, такие как `PlatformTransactionManager`
и `TransactionTemplate`. Эти классы позволяют явно управлять началом, фиксацией и откатом транзакций. Например:

```java

@Service
public class MyService {
    @Autowired
    private PlatformTransactionManager transactionManager;

    public void performTransaction() {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            // Логика чтения/записи
            transactionManager.commit(status);
        } catch (Exception ex) {
            transactionManager.rollback(status);
        }
    }
}
```

### TransactionTemplate

`TransactionTemplate` - это класс в Spring Framework, который предоставляет удобный способ для программного управления
транзакциями. Он предоставляет абстракцию над управлением транзакциями и облегчает выполнение операций внутри
транзакций. `TransactionTemplate` предоставляет следующие преимущества:

1. Управление границами транзакции. `TransactionTemplate` позволяет явно указывать, где начинается и где заканчивается
   транзакция, в отличие от использования аннотации `@Transactional`, которая управляет транзакцией на основе методов.

2. Управление точками сохранения. `TransactionTemplate` позволяет управлять точками сохранения внутри транзакции. Вы
   можете явно указать, когда данные должны быть сброшены на диск, что может быть полезно в случае работы с большим
   объемом данных.

3. Более гибкое программное управление. Используя `TransactionTemplate`, вы можете выполнять более сложные операции с
   транзакциями, такие как вложенные транзакции или управление точками сохранения в зависимости от условий.

```java

@Service
public class MyService {
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void performTransactionalOperation() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // Выполнение операций внутри транзакции
                // Например, вызовы методов доступа к данным или бизнес-логика
                // Если происходит исключение, транзакция будет откатана
            }
        });
    }
}
```

В этом примере мы используем `TransactionTemplate` для выполнения операций внутри транзакции. Метод `execute` принимает
в качестве параметра `TransactionCallback`, который представляет собой функциональный интерфейс с
методом `doInTransactionWithoutResult`. Внутри этого метода мы выполняем нужные операции внутри транзакции. Если
происходит исключение, транзакция будет автоматически откатана, иначе она будет зафиксирована.

Вы также можете использовать `TransactionTemplate` для получения результата из транзакционной операции с
помощью `TransactionCallback`:

```java

@Service
public class MyService {
    public Object performTransactionalOperationWithResult() {
        return transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus status) {
                // Выполнение операций внутри транзакции
                // Возврат результата операции
            }
        });
    }
}
```

В этом примере мы использовали `TransactionCallback`, который возвращает результат операции внутри транзакции.

## Нестандартные сценарии.

Иногда возникают ситуации, когда нужно настроить транзакции в соответствии с нестандартными сценариями. В таких случаях
можно использовать аннотацию `@Transactional` с различными параметрами, такими как `isolation`, `propagation`
и `readOnly`, чтобы указать требуемые свойства транзакции.

```java

@Service
public class MyService {
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public void performReadOnlyTransaction() {
        // Логика чтения
    }
}
```

В этом примере транзакция будет настроена с уровнем изоляции `READ_COMMITTED`, распространением `REQUIRES_NEW` и
режимом `readOnly`.

## Обработка исключений:

Spring Data предоставляет возможность обработки исключений, возникающих в рамках транзакций. Вы можете использовать
аннотацию `@Transactional` с параметром `rollbackFor`, чтобы указать, какие исключения должны приводить к откату
транзакции. Например:

```java

@Service
public class MyService {
    @Transactional(rollbackFor = {SQLException.class, IOException.class})
    public void performTransactionWithException() throws SQLException, IOException {
        // Логика операций чтения/записи
    }
}
```

В этом примере транзакция будет откатываться при возникновении исключений типа `SQLException` и `IOException`.

Транзакции в Spring Data предоставляют мощный механизм управления базами данных в многопоточных средах. Понимание основ
работы с транзакциями и применение соответствующих аннотаций и методов позволяет создавать надежные и эффективные
приложения, обеспечивая целостность данных и консистентность операций чтения и записи.

## Дополнительные материалы

1. https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
2. https://www.baeldung.com/spring-programmatic-transaction-management
3. https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth
4. https://vladmihalcea.com/spring-transaction-best-practices/
5. https://medium.com/javarevisited/spring-core-managing-transactions-effectively-781bba6c47e8