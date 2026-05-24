package Practice;

public class ReservePreserveSpaces {
	
	public static String reverse(String str) {
		if(str == null || str.length() <= 1 ) return str;
		
		char[] arr = str.toCharArray();
		
		int left = 0;
		int right = str.length() - 1;
		
		while(left<right) {
			if(arr[left] == ' ') {
				left++;}
			else if(arr[right] == ' ') {
				right--;
			}else {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				
				left++;
				right--;
			}
			
		}
		return new String(arr);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "java is good";
		
		System.out.println(reverse(s1));
		

	}

}
