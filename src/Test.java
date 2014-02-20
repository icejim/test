import java.util.ArrayList;
import java.util.Arrays;


public class Test {

	public static void main(String[] args){
		int[] digits = {1,2,3, 0,4,5,6,7, 0};
//		minSum(digits);
//		uniqueString("abca");
		long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("Heap Size = " + heapSize);
	}
	
	private static void uniqueString(String s){
		StringBuilder sb = new StringBuilder(s);
		int length = sb.length();
		for(int i=0; i<length; i++){
			char temp = sb.charAt(i);
			for(int j=i+1; j<length; j++){
				if(temp == sb.charAt(j)){
					System.out.println("got it:" + temp);
					break;
				}
			}
			System.out.println("screen..." + temp);
		}
	}
	
	private static void minSum(int[] digits){
		Arrays.sort(digits);
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		for(int i=0; i < digits.length; i++){
			if(digits[i] == 0){
				zeros.add(0);
				continue;
			}
			if(i%2 == 0)
				a.add(digits[i]);
			else
				b.add(digits[i]);
		}
		
		ArrayList<Integer> big;
		ArrayList<Integer> small;
		if(a.size() > b.size()){
			big = a;
			small = b;
		}else{
			big = b;
			small = a;
		}
		
		for(int i=0; i<zeros.size(); i++){
			if(i%2 == 0){
				big.add(1,0);
			}else{
				small.add(1,0);
			}
		}
		
		System.out.println(big);
		System.out.println(small);
		
	}
}
