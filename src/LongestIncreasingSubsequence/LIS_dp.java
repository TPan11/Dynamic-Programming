package LongestIncreasingSubsequence;

public class LIS_dp {
	
	static int lis(int A[], int m){
		int lis[] = new int[m];
		int max=0;
		for(int i=0;i<m;i++){
			lis[i] =1;
		}
		
		for(int i=1;i<m;i++){
			for(int j=0;j<i;j++){
				if(A[i]>=A[j] && lis[i]<lis[j]+1){
					lis[i] = lis[j]+1;
				}
			}
		}
		
		for(int i=0;i<m;i++){
			if(lis[i]>max){
				max = lis[i];
			}
		}
		int x[] =new int[max];
		
		int count =max;
		for(int i=m-1; i>=0; i--){
			if(lis[i]==count){
				count--;
				x[count] = A[i];
			}
		}
		
		for(int i=0;i<max;i++){
			System.out.println(x[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {3,45,23,9,3,99,108,76,12,16,18,4};
		
		System.out.println("LIS is " + lis(A,A.length));
	}

}
