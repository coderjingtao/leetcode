package solutions;

/**
 * NO.11 Container With Most Water
 * Keywords:   Array, two pointer
 * Difficulty: Medium
 * Company:    Bloomberg
 */
public class _011ContainerWithMostWater {
    /**
     * 思路1：遍历：把所有面积计算一遍，得到最大面积
     * 算法复杂度：O(n^2)
     */
    public int maxArea(int[] height){
        int maxArea = 0;
        for(int i=0;i<height.length-1;i++){
            for(int j=1;j<height.length;j++){
                int area=getArea(height,i,j);
                if(area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }
    /**
     * 思路2：对撞指针
     * 默认认为距离最远的两边形成的面积最大，然后依次向内缩进左右两个边，并比较面积，具体缩进规则是：
     * 1.如果缩进较高的边，则面积一定缩小，所以是需要缩进较低的边
     * 2.较低的边需要缩进到哪个位置呢？一定是缩进到下一个比较低边要高的位置才可能形成更大的面积
     * 算法复杂度：O(n)
     */
    public int maxArea2(int[] height) {
        int left=0;
        int right = height.length-1;
        int maxArea = getArea(height,left,right);
        while( left < right){
            if( height[left] < height[right] ) //向右移动 -->
            {
                left = toRightHigher(left,height);
                int area = getArea(height,left,right);
                if(area > maxArea)
                    maxArea = area;
            }
            else //height[left] >= height[right] 向左移动 <--
            {
                right = toLeftHigher(right,height);
                int area = getArea(height,left,right);
                if(area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }

    private int toRightHigher(int left,int[] height){
        for(int i = left+1; i < height.length; i++){
            if(height[i]>height[left])
                return i;
        }
        return height.length-1;
    }

    private int toLeftHigher(int right,int[] height){
        for(int i = right-1; i >=0 ; i--){
            if(height[i]>height[right])
                return i;
        }
        return 0;
    }

    private int getMin(int a, int b){
        return a<b?a:b;
    }

    private int getArea(int[] height, int left, int right){
        return (right-left) * getMin(height[right],height[left]);
    }

    /**
     * 思路3：针对maxArea2的简化版本
     */
    public int maxArea3(int[] height) {
        int l=0, r=height.length-1;
        int max = 0;
        int h = 0;
        while(l<r){
            h = Math.min(height[l], height[r]);
            max = Math.max(max, (r-l)*h );
            while(height[l]<=h && l<r)
                l++;
            while(height[r]<=h && l<r)
                r--;
        }
        return max;
    }

    public static void main(String[] args) {
        _011ContainerWithMostWater c = new _011ContainerWithMostWater();
        int[] height = {2,3,10,5,7,8,9};
        System.out.println(c.maxArea3(height));
    }
}
