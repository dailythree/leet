39. Combination Sum
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }
    
    public void backtracking(int[] candidates, int cur, List<Integer> list, List<List<Integer>> res, int index) {
        if (cur < 0) {
            return;
        }
        if (cur == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, cur - candidates[i], list, res, i);
            list.remove(list.size() - 1);
        }
    }
}

251. Flatten 2D Vector
class Vector2D {
    List<Integer> list;
    int index;
    public Vector2D(int[][] v) {
        list = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                list.add(v[i][j]);
            }
        }
        index = 0;
    }
    
    public int next() {
        // System.out.println(index);
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
