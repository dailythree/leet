/**
 * 251. Flatten 2D Vector
 */
class Vector2D {
  Queue<Integer> queue = new LinkedList();

  public Vector2D(int[][] v) {
    for (int i = 0; i < v.length; i++) {
      for (int j = 0; j < v[i].length; j++) {
        queue.add(v[i][j]);
      }
    }
  }

  public int next() {
    return queue.poll();
  }

  public boolean hasNext() {
    return queue.size() != 0;
  }
}

/**
 * 39. Combination Sum
 */

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<Integer> currentList = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();
    traverse(candidates, target, 0, 0, list, currentList);
    return list;
  }

  private void traverse(int[] candidates, int target, int count, int index,
      List<List<Integer>> list, List<Integer> currentList) {
    if (count > target) {
      return;
    }

    if (count == target) {
      list.add(new ArrayList<>(currentList));
    }

    for (int i = index; i < candidates.length; i++) {
      currentList.add(candidates[i]);
      traverse(candidates, target, count + candidates[i], i, list, currentList);
      currentList.remove(currentList.size() - 1);
    }
  }
}

/**
 * 336. Palindrome Pairs
 */

