class Solution {
    public int maxArea(int[] height) {
        int i =0;
        int j = height.length-1;
        int maxArea=0;
        while(i<j){
            int h = Math.min(height[i],height[j]);
            int w = j-i;
            int area = h*w;

            maxArea=Math.max(area,maxArea);

            if(height[i]>height[j]) j--;
            else i++;
        }
        return maxArea;
    }
}