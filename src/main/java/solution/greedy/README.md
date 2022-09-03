## Теория:

### Где я смотрел:

1. Geeksforgeeks (Много примеров использования) - (https://www.geeksforgeeks.org/greedy-algorithms/)
2. Статья с визуализацией и задачками на понимание - (https://brilliant.org/wiki/greedy-algorithm/)

## Пример

Задача: [MaximumSubarray.java](medium/MaximumSubarray.java)

1. Инициализируем две переменные: **maxSum** и **currentSum**, обе равны первому элементу в массиве.

2. Проходим по оставшимся элементам массива, начиная со второго элемента:

    1. Для каждого элемента:
    2. Обновляем currentSum, добавляя текущий элемент к предыдущей сумме (**currentSum** + текущий элемент).
    3. Если currentSum становится больше текущего значения **maxSum**, обновляем maxSum значением **currentSum**.
    4. Если currentSum становится отрицательным, сбрасываем его в ноль, так как негативная сумма не может быть частью
       максимальной подпоследовательности.

3. В конце прохода по массиву возвращаем **maxSum**, которая будет содержать максимальную сумму подмассива.

```java
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Инициализация maxSum значением первого элемента
        int currentSum = nums[0]; // Инициализация currentSum значением первого элемента

        // Проход по остальным элементам массива
        for (int i = 1; i < nums.length; i++) {
            // Обновление текущей суммы
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            // Обновление максимальной суммы
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

```