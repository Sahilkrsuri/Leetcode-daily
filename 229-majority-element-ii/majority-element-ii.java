class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);  
        }
        for(Integer e : map.keySet()){
            if(map.get(e) > nums.length/3){
                list.add(e);
            }
        }
        return list;
    }
}