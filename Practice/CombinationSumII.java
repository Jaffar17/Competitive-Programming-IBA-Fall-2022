class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> out = new ArrayList<List<Integer>>();
        ArrayList<Integer> ds = new ArrayList<Integer>();
        Arrays.sort(candidates);
        recCombinations(0, target, candidates, out, ds);
        return out;
    }
    void recCombinations(int index, int target, int[] arr, ArrayList<List<Integer>> out, ArrayList<Integer> ds){
        if(target == 0){
            out.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<arr.length; i++){
            if(i > index && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            ds.add(arr[i]);
            recCombinations(i+1, target - arr[i], arr, out, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
