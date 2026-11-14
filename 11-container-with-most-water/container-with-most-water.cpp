class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size()-1;
        int maxwater = 0;

        while(i<j){
            int h = min(height[i],height[j]);
            int w = j-i;
            int area = w*h;
            maxwater = max(area,maxwater);

            if(height[i]>height[j])j--;
            else i++;

        }
        return maxwater;
    }
};