341. Flatten Nested List Iterator
public class NestedIterator implements Iterator<Integer> {
    
    Stack<Iterator<NestedInteger>> stack;
    NestedInteger cur;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return cur.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
                continue;
            }
            cur = stack.peek().next();
            if (cur.isInteger()) {
                return true;
            }
            stack.push(cur.getList().iterator());
        }
        return false;
    }
}

336. Palindrome Pairs
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        //HashMap to store the string with index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        //split the string into two substrings, and check which part is palindrome
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String str1 = word.substring(0, i);
                String str2 = word.substring(i);
                int index = map.get(word);
                if (isPalindrome(str1)) {
                    String rvsStr = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(rvsStr) && map.get(rvsStr) != index && str1.length() != 0) {
                        res.add(new ArrayList<>(Arrays.asList(map.get(rvsStr), index)));
                    }
                }
                if (isPalindrome(str2)) {
                    String rvsStr = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(rvsStr) && map.get(rvsStr) != index) {
                        res.add(new ArrayList<>(Arrays.asList(index, map.get(rvsStr))));
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }
}


