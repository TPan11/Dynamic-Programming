package editDistance;

public class EditDistance_recur {
	static int min(int a, int b, int c){
		if(a<b && a<c){
			return a;
		}
		else if(b<a && b<c){
			return b;
		}
		return c;
	}
	
	static int edit_distance(String str1, String str2, int m, int n){
		if(m==0){
			return n;
		}
		if(n==0){
			return m;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)){
			return edit_distance(str1,str2,m-1,n-1);
		}
		
		return 1+min(edit_distance(str1,str2,m,n-1),edit_distance(str1,str2,m-1,n),edit_distance(str1,str2,m-1,n-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Saturday";
		String str2 = "Sunday";
		int m = str1.length();
		int n = str2.length();
		
		System.out.println("number of edits " + edit_distance(str1,str2,m,n));
	}

}
