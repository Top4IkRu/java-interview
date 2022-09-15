## Теория:

Жадный алгоритм - это метод, при котором решение строится пошагово, всегда выбирая лучший вариант здесь и сейчас. Таким
образом, задачи, где выбор локально оптимального решения приводит к глобальному оптимальному решению, наиболее подходят
для применения жадного подхода.

### Где я смотрел:

1. Geeksforgeeks (Много примеров использования) - (https://www.geeksforgeeks.org/greedy-algorithms/)
2. Статья с визуализацией и задачками на понимание - (https://brilliant.org/wiki/greedy-algorithm/)
3. Для тех кто любит много теории. "Greedy Algorithms" by Stanford University
    1. Greedy Algorithms Part 1: (https://web.stanford.edu/class/archive/cs/cs161/cs161.1138/lectures/13/Small13.pdf)
    2. Greedy Algorithms Part 2: (https://web.stanford.edu/class/archive/cs/cs161/cs161.1138/lectures/14/Small14.pdf)
    3. Greedy Algorithms Part 3: (https://web.stanford.edu/class/archive/cs/cs161/cs161.1138/lectures/15/Small15.pdf)
    4. Article: (http://web.stanford.edu/class/archive/cs/cs161/cs161.1166/lectures/lecture14.pdf)

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