import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currList = new ArrayList<>();
		backtrack(candidates, target, 0, currList, result);
		return result;
	}

	private void backtrack(int[] candidates, int target, int start, List<Integer> currList,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(currList));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			currList.add(candidates[i]);
			backtrack(candidates, target - candidates[i], i, currList, result);
			currList.remove(currList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		CombinationSum combinationSum = new CombinationSum();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
	}
}
