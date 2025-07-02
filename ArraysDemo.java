package Automation.Demo;

public class ArraysDemo {
	
	public static void main(String[] args) {
		
	
	int arr[] = new int[5];
	arr[0] = 5;
	arr[1] = 4;
	arr[2] = 3;
	arr[3] = 2;
	System.out.println("Size of array is :-"+arr.length);
	for (int i=0; i<arr.length;i++) {
		System.out.println(arr[i]);
	}
	
	int arr2[] = {1,2,3,4,5,6,7,8,9,10,11};
	
	System.out.println("Size of array is :-"+arr2.length);
	for (int i:arr2) {
		System.out.println(i);
	}
	
	for(int i:arr2) {
		if(i%2==0) {
			System.out.println(i+" is even number from the array");
		}
		else {
			System.out.println(i);
		}
	}
	
	 int[] numbers = {1,2,3,4,5};
        System.out.println("The first element of the array is :- "+numbers[0]);
        System.out.println("The last element of the array is :- "+numbers[numbers.length-1]);
        
        int count=0;
        for(int i=numbers.length-1;i>=0;i--){
            System.out.println(numbers[i]);
            count = count+numbers[i];
        }
        System.out.println("The ount of all array elements is :- "+count);
	
}

}
