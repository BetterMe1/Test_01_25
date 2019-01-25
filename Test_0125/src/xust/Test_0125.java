package xust;

/*
1. Excel表列序号 
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
    
示例 1:
输入: "A"
输出: 1

示例 2:
输入: "AB"
输出: 28

示例 3:
输入: "ZY"
输出: 701
 */
//public class Test_0125 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String s = "ZY";
//		System.out.println(So.titleToNumber(s));
//	}
//}
//
//class Solution {
//    public int titleToNumber(String s) {
//        int ret = 0;
//        int i = 0;
//        while(i!=s.length()){
//        	ret = ret *26+ (s.charAt(i)-'A'+1);
//        	i++;
//        }
//        return ret;
//    }
//}

/*
2.阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
说明: 你算法的时间复杂度应为 O(log n) 。
 */

/*
 * 算法思想：
 * 要计算阶乘后整数末尾有几个0，而只有2乘以5或2乘以5的倍数时末尾才有0，而一组2*5会使得末尾出现一个0，而在计算阶乘的过程中，
 * 分解后的2肯定要多于5，因此只需要数5的个数即可
 */
//public class Test_0125 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int n = 10;
//		System.out.println(So.trailingZeroes(n));
//	}
//}
//class Solution {
//    public int trailingZeroes(int n) {
//    	int count = 0;
//        while(n!=0){
//        	n=n/5;
//        	count += n;
//        }
//        return count;
//    }
//}

/*
3. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的原地算法
 */
public class Test_0125 {
	public static void main(String[] args) {
		Solution1 So1 = new Solution1();
		int[] nums1={1,2,3,4,5,6,7};
		int k1=3;
		So1.rotate(nums1, k1);
		//打印数组
		for(int i=0; i<nums1.length; i++){
			System.out.print(nums1[i]+" ");
		}
		System.out.println();
		Solution2 So2 = new Solution2();
		int[] nums2={-1,-100,3,99};
		int k2=2;
		So2.rotate(nums2, k2);
		//打印数组
		for(int i=0; i<nums2.length; i++){
			System.out.print(nums2[i]+" ");
		}
		System.out.println();
		Solution3 So3 = new Solution3();
		int[] nums3={1,2,3,4,5,6,7};
		int k3=3;
		So3.rotate(nums3, k3);
		//打印数组
		for(int i=0; i<nums3.length; i++){
			System.out.print(nums3[i]+" ");
		}
	}
}
/*
 * 算法思想：每次操作将数组元素向右旋转 1 步，循环k%nums.length次，相当于元素向右旋转 k 步.
 */
class Solution1 {
    public void rotate(int[] nums, int k) {
        for(int i=0; i<k%nums.length; i++){
        	int temp = nums [nums.length-1];
        	for(int j=nums.length-2; j>=0; j--){
        		nums[j+1] = nums [j];
        	}
        	nums[0]=temp;
        }
    }
}
/*
 * 算法思想：
 * 翻转法:
 * 先将数组元素全部逆序，再将前k%nums.length个元素逆序，再将后nums.length-k%nums.length个元素逆序。结果相当于原始数组元素向右旋转k步。
 */
class Solution2 {
    public void rotate(int[] nums, int k) {
    	reverse(nums, 0, nums.length-1);//数组全部翻转
    	reverse(nums, 0, k%nums.length-1);
    	reverse(nums, k%nums.length, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end){
    	while(start<end){
    		int temp =nums[start];
    		nums[start] =nums[end];
    		nums[end] =temp;
    		start++;
    		end--;
    	}
    }
}
/*
 * 交换法:
 * 第一次交换范围是整个数组，len =nums.length,将前k位元素与最后k位数字进行交换，第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换，
 * 第二次交换范围是下标为k的元素到数组末尾的元素，len=len-k,同样将这个范围内前k位元素与最后k位数字进行交换
 * 以此类推，直到交换完毕为止。
 */
class Solution3 {
    public void rotate(int[] nums, int k) {
    	 int len = nums.length;
         k %= len;
         for (int i = 0; i < nums.length && k != 0; len -= k, i += k, k %= len) {
             for (int j = 0; j < k; j++) {
                 swap(nums, i + j, nums.length - k + j);
             }
         }
    	
    }
    private void swap(int[] nums,int i,int j ){
    	int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
}