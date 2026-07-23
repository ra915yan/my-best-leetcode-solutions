class Solution {
    public int[] twoSum(int[] nums, int target) {

        /*
        x + y = target
        where x and y in nums
        store y = target - x using map
        if y on the map return it with x 
        */

        HashMap<Integer,Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            Integer result = map.get(nums[i]);
            if(result != null){
                return new int[]{i,result};
            }
            else{
                map.put(target - nums[i], i);
            }
        }
        return null;

    }
}