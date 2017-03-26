package editDistance;

public class EditDistance_dp {
	public static void main(String args[]){
		String str1 = "Sunday";
		String str2 = "Sunday";
		int m = str1.length();
		int n = str2.length();
		
		System.out.println("number of edits " + edit_distance(str1,str2,m,n));
	}
	
	static int edit_distance(String str1, String str2, int m, int n){
		int dist[][] = new int[m+1][n+1];
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				if(i==0){
					dist[i][j] = j;
				}
				else if(j==0){
					dist[i][j] = i;
				}
				
				else if(str1.charAt(i-1) == str2.charAt(j-1)){
					dist[i][j] = dist[i-1][j-1];
				}
				
				else{
					dist[i][j] = 1 + min(dist[i][j-1],dist[i-1][j], dist[i-1][j-1]);
				}
			}
		}
		return dist[m][n];
	}
	
	static int min(int a, int b, int c){
		if(a<b && a<c){
			return a;
		}
		else if(b<a && b<c){
			return b;
		}
		else{
			return c;
		}
	}
}
