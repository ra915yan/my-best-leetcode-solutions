class Solution {
    public int maxOperations(int[] nums, int k) {
        
        // return bruteForce(nums, k);
        // return hashAlgorithm(nums, k);
        return twoPointers(nums, k);
        
    }

    public int twoPointers(int[] nums, int k){
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length -1;
        int count = 0;
        while(left < right){
            int target = nums[left] + nums[right];

            if(target < k){
                left++;
            }
            else if(target > k){
                right--;
            }
            else{
                count++;
                left++;
                right--;
            }

        }
        return count;
    }

    public int hashAlgorithm(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for(int num : nums){

            int target = k - num;

            if(map.getOrDefault(target, 0) > 0){
                pairs++;
                map.put(target, map.get(target) - 1);
            }
            else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        } 

        return pairs;
    }





    public int bruteForce(int[] nums, int k){
        int count = 0;
        boolean[] used = new boolean[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]) continue;
            for(int j = i + 1 ; j < nums.length; j++){
                if(used[j]) continue;
                if(nums[i] + nums[j] == k){
                    System.out.println(String.format("i:%d, j:%d", i,j));
                    used[i] = true;
                    used[j] = true;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}