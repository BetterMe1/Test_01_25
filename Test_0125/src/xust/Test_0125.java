package xust;

/*
1. Excel������� 
����һ��Excel����е������ƣ���������Ӧ������š�

���磬
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
    
ʾ�� 1:
����: "A"
���: 1

ʾ�� 2:
����: "AB"
���: 28

ʾ�� 3:
����: "ZY"
���: 701
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
2.�׳˺����
����һ������ n������ n! ���β�������������

ʾ�� 1:
����: 3
���: 0
����: 3! = 6, β����û���㡣

ʾ�� 2:
����: 5
���: 1
����: 5! = 120, β������ 1 ����.
˵��: ���㷨��ʱ�临�Ӷ�ӦΪ O(log n) ��
 */

/*
 * �㷨˼�룺
 * Ҫ����׳˺�����ĩβ�м���0����ֻ��2����5��2����5�ı���ʱĩβ����0����һ��2*5��ʹ��ĩβ����һ��0�����ڼ���׳˵Ĺ����У�
 * �ֽ���2�϶�Ҫ����5�����ֻ��Ҫ��5�ĸ�������
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
3. ��ת����
����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����

ʾ�� 1:

����: [1,2,3,4,5,6,7] �� k = 3
���: [5,6,7,1,2,3,4]
����:
������ת 1 ��: [7,1,2,3,4,5,6]
������ת 2 ��: [6,7,1,2,3,4,5]
������ת 3 ��: [5,6,7,1,2,3,4]
ʾ�� 2:

����: [-1,-100,3,99] �� k = 2
���: [3,99,-1,-100]
����: 
������ת 1 ��: [99,-1,-100,3]
������ת 2 ��: [3,99,-1,-100]
˵��:

�������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣
Ҫ��ʹ�ÿռ临�Ӷ�Ϊ O(1) ��ԭ���㷨
 */
public class Test_0125 {
	public static void main(String[] args) {
		Solution1 So1 = new Solution1();
		int[] nums1={1,2,3,4,5,6,7};
		int k1=3;
		So1.rotate(nums1, k1);
		//��ӡ����
		for(int i=0; i<nums1.length; i++){
			System.out.print(nums1[i]+" ");
		}
		System.out.println();
		Solution2 So2 = new Solution2();
		int[] nums2={-1,-100,3,99};
		int k2=2;
		So2.rotate(nums2, k2);
		//��ӡ����
		for(int i=0; i<nums2.length; i++){
			System.out.print(nums2[i]+" ");
		}
		System.out.println();
		Solution3 So3 = new Solution3();
		int[] nums3={1,2,3,4,5,6,7};
		int k3=3;
		So3.rotate(nums3, k3);
		//��ӡ����
		for(int i=0; i<nums3.length; i++){
			System.out.print(nums3[i]+" ");
		}
	}
}
/*
 * �㷨˼�룺ÿ�β���������Ԫ��������ת 1 ����ѭ��k%nums.length�Σ��൱��Ԫ��������ת k ��.
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
 * �㷨˼�룺
 * ��ת��:
 * �Ƚ�����Ԫ��ȫ�������ٽ�ǰk%nums.length��Ԫ�������ٽ���nums.length-k%nums.length��Ԫ�����򡣽���൱��ԭʼ����Ԫ��������תk����
 */
class Solution2 {
    public void rotate(int[] nums, int k) {
    	reverse(nums, 0, nums.length-1);//����ȫ����ת
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
 * ������:
 * ��һ�ν�����Χ���������飬len =nums.length,��ǰkλԪ�������kλ���ֽ��н�������һ�ν�����Ϻ�ǰ k λ����λ����ȷ���� n-k λ��������� k λ����˳����󣬼���������
 * �ڶ��ν�����Χ���±�Ϊk��Ԫ�ص�����ĩβ��Ԫ�أ�len=len-k,ͬ���������Χ��ǰkλԪ�������kλ���ֽ��н���
 * �Դ����ƣ�ֱ���������Ϊֹ��
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