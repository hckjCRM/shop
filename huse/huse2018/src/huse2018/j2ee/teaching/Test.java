package huse2018.j2ee.teaching;

public class Test {
	public static void main(String[] args) {
		System.out.println(-1>>>1);
		System.out.println(Integer.MAX_VALUE);
		int a=3;
		int b = 4;
		a = a^ b;
		b = b^a;
		a = a^b;
		int[] s ={1,2,3,4,5};
		reverse(s);
		for (int i : s) {
			System.out.print(i+"\t");
		}
		System.out.println(a);
	}
	public static int[] reverse(int[] nums){		
        int i = 0;
        int j = nums.length-1;
        while(j>i){
        	nums[i] = nums[i]^nums[j];
        	nums[j] = nums[i]^nums[j];
        	nums[i] = nums[i]^nums[j];
        	i++;
        	j--;
        }
        return nums;		
	}
}
