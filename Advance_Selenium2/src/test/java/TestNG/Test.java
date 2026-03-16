package TestNG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(List.of(10,20,30,40,50,60).stream().filter(e->e>40).collect(Collectors.toList()));
		
		
		int[] a = new int[] {0,1,0,1,1};
		//0,0,1,1,1
		
		int temp=0;
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length-1;j++) {
				if(a[j]<=a[i]) {
					temp = a[i+1];
					a[i+1]=a[j];
					a[j] =temp;
				}
					
			}
		}
		System.out.println(Arrays.toString(a));
		
		// arr with mixed numbers 
		// minX = value (value)
		int minX = 0;
		//minX+=arr[i];
		//-10
		int [] arr = new int[] {5,10};
		
	}
	
	
	
	
}
