package LongestCommonSubsequence;

public class LCS_recurr {
	static int lcs(char[] A, char B[], int m, int n){
		if(m==0 || n==0){
			return 0;
		}
		if(A[m-1] == B[n-1]){
			return 1+lcs(A,B,m-1,n-1);
		}
		else{
			return max(lcs(A,B,m,n-1),lcs(A,B,m-1,n));
		}
	}
	
	static int max(int a, int b){
		return a>b?a:b;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "acdef";
		String B = "abcd";
		
		char C[] = A.toCharArray();
		char D[] = B.toCharArray();
		
		int m = C.length;
		int n = D.length;
		
		System.out.println("LCS is " + lcs(C,D,m,n));
	}

}
