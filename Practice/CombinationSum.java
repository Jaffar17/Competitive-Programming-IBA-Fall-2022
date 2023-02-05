class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> out = new ArrayList<List<Integer>>();
        ArrayList<Integer> ds = new ArrayList<Integer>();
        recCombinations(0, target, candidates, out, ds);
        return out;
    }
    void recCombinations(int index, int target, int[] arr, ArrayList<List<Integer>> out, ArrayList<Integer> ds){
        if(index == arr.length){
            if(target == 0){
                out.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[index] <= target){
            ds.add(arr[index]);
            recCombinations(index, target - arr[index], arr, out, ds);
            // ds.remove(arr[index]); this may remove very first instance so avoid
            ds.remove(ds.size()-1); // removing very last instance
        }
        recCombinations(index + 1, target, arr, out, ds);
    }
}
