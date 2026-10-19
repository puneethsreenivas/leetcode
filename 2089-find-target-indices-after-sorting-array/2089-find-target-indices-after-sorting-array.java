class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        int small=0;
        int equal=0;
        for(int i=0;i<n;i++){
            if(nums[i]<target){
                small++;
            }
            else if(nums[i]==target){
                equal++;
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=small;i<equal+small;i++){
            list.add(i);
        }
        return list;
    }
}