package solution.heap.medium;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/task-scheduler/description/">Task 621</a>
 */
// TODO I know that it's not optimum, but it's easy to understand
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Node> q = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(node -> node.counter)));

        for (char letter : tasks) map.compute(letter, (l, v) -> v == null ? 1 : v + 1);
        for (char letter : map.keySet()) q.add(new Node(letter, map.get(letter)));

        Map<Integer, List<Node>> waiting = new HashMap<>();
        int round = 0;
        while (!q.isEmpty() || !waiting.isEmpty()) {
            round++;
            Node node = q.poll();
            if (node != null) {
                node.counter--;
                if (node.counter > 0) {
                    if (n > 0) {
                        List<Node> list = waiting.getOrDefault(round + n, new ArrayList<>());
                        list.add(node);
                        waiting.put(round + n, list);
                    } else {
                        q.add(node);
                    }
                }
            }
            if (waiting.containsKey(round)) {
                q.addAll(waiting.get(round));
                waiting.remove(round);
            }
        }
        return round;
    }

    private class Node {
        char letter;
        int counter;

        Node(char letter, int counter) {
            this.letter = letter;
            this.counter = counter;
        }
    }
}
