package solution.sliding_window.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Task 3</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Основная идея:
     * Мы должны итерироваться по строке и добавлять символы во множество (set), если они отсутствуют в нем.
     * Если символ уже присутствует во множестве, то мы должны удалить все символы, находящиеся перед этим повторением.
     * <p>
     * Пример:
     * s = "asdfghjd"
     * Тогда мы придем к ситуации, когда set -> [a,s,d,f,g,h,j] и символ = d
     * Следовательно нам нужно удалить все символы до 'd', те [a,s,d]
     * и как результат мы получим сет [f,g,h,j,d] с уникальными элементами
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                // удаляем все до повтора
                while (c != s.charAt(i - set.size())) {
                    set.remove(s.charAt(i - set.size()));
                }
            } else {
                set.add(c);
            }
            if (set.size() > max) max = set.size();
        }
        return max;
    }
}
