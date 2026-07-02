class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int tar=0;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=n-1;
            int sum=0;
            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum==tar){
                    List<Integer>temp=Arrays.asList(nums[i],nums[left],nums[right]);
                    ans.add(temp);
                    left++;
                    right--;
                
                while(left<right && nums[left]==nums[left-1]){
                    left++;
                }
                while( left<right && nums[right]==nums[right+1]){
                    right--;
                }

                }
                else if(sum>tar){
                    right--;
                }
                else {
                    left++;
                }
                
            }
        }
        return ans;
        
    }
}