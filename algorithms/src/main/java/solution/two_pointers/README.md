# Two pointers

The two pointers algorithm is a popular technique used in computer science and programming for solving various problems
efficiently. It involves using **two pointers** that traverse a data structure simultaneously, usually from different
starting points or at different speeds, to solve the problem at hand.

The basic idea behind the two pointers algorithm is to reduce the time complexity of a problem by avoiding redundant
computations. By using **two pointers**, we can often achieve a linear - _O(n)_ or sub-linear - _O(const * n)_ runtime
complexity, compared to a naive
approach that would require nested loops or multiple iterations.

The two pointers are typically initialized to different positions in the data structure and then updated based on
certain conditions. These conditions can be defined according to the requirements of the problem being solved. As the
pointers move through the data structure, they narrow down the search space or perform specific operations until the
desired result is obtained.

The two pointers algorithm is commonly used for solving problems such as:

1. Array manipulation: For example, finding a pair of elements in an array that satisfies a specific condition, such as
   the
   sum being equal to a target value. The two pointers can start from the beginning and end of the array and move
   towards
   each other until the desired pair is found.

2. String manipulation: In problems involving strings, the two pointers can be used to compare characters or search for
   patterns. For instance, in palindrome-related problems, two pointers can start from the beginning and end of the
   string
   and check if the characters match.

3. Linked list traversal: When working with linked lists, two pointers can be employed to traverse the list at different
   speeds, allowing operations like cycle detection or finding the middle element efficiently.

4. Searching and sorting: The two pointers algorithm can also be utilized for searching or sorting problems. For
   instance,
   in binary search, two pointers can be used to define the search range and update them based on the comparison of the
   target element with the middle element.

## Example 1: Finding a pair of elements with a sum equal to a target in a sorted array.

```java
public class TwoPointersExample {
    public static int[] findPairWithTargetSum(int[] nums, int targetSum) {
        int left = 0; // Left pointer
        int right = nums.length - 1; // Right pointer

        while (left < right) {
            int currentSum = nums[left] + nums[right];

            if (currentSum == targetSum) {
                return new int[]{nums[left], nums[right]}; // Pair found
            } else if (currentSum < targetSum) {
                left++; // Increase the left pointer to increase the sum
            } else {
                right--; // Decrease the right pointer to decrease the sum
            }
        }

        return new int[0]; // Pair not found
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 12, 30};
        int targetSum = 20;

        int[] result = findPairWithTargetSum(nums, targetSum);

        if (result.length == 2) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Pair not found.");
        }
    }
}
```

In this example, using the Two Pointers algorithm, we are looking for a pair of elements in a sorted array whose sum is
equal to a target value. We initialize the **left** pointer **left** to the start of the array and the **right** pointer right to
the end of the array. Then, we compare the sum of the elements pointed to by **left** and **right** with targetSum. If the sum
is equal to targetSum, we return the found pair. If the sum is less than targetSum, we increment **left** to increase the
sum. If the sum is greater than targetSum, we decrement **right** to decrease the sum. The process continues until **left**
becomes greater than or equal to **right** (indicating no pair is found) or until a pair with the sum targetSum is found.
