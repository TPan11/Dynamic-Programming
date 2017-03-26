package LongestCommonSubsequence;

public class LCS_dp {
	static int S[][];
	static int lcs(char C[], char D[], int m, int n){
		int L[][] = new int[m+1][n+1];
		S = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					L[i][j] = 0;
				}
				else if(C[i-1] == D[j-1]){
					L[i][j] = 1+L[i-1][j-1];
					S[i][j] = 0;
				}
				else if(L[i-1][j] >= L[i][j-1]){
					L[i][j] = L[i-1][j];
					S[i][j] = 1;
				}
				else{
					L[i][j] = L[i][j-1];
					S[i][j] = 2;
				}
			}
		}
		return L[m][n];
	}
	
	static int max(int a, int b){
		return a>b?a:b;
	}
	
	static void printlcs(char A[], int m, int n){
		if(!(m==0 || n==0)){
			if(S[m][n] == 0){
				printlcs(A,m-1,n-1);
				System.out.print(A[m-1]);
			}
			else if(S[m][n] == 1){
				printlcs(A,m-1,n);
			}
			else{
				printlcs(A,m,n-1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "dadcac";
		String B = "dcabca";
		
		char C[] = A.toCharArray();
		char D[] = B.toCharArray();
		
		int m = C.length;
		int n = D.length;
		
		System.out.println("LCS is " + lcs(C,D,m,n));
		printlcs(C,m,n);
	}

}
