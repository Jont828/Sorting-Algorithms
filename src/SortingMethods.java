import java.util.Arrays;

public class SortingMethods {
	
	public static void selectionSort(int arr[]) {
		int minIndex;
		int temp;
		
		for(int i=0; i<arr.length-1; i++) {
			minIndex = i; // Reset minIndex to i so if there is no smaller value, nothing happens
			
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[i]) { // If arr[j] and arr[i] are in the wrong order
					minIndex = j;
				}
			}
			
			if(i != minIndex) {
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}

		}

	}
	
	public static void insertionSort(int arr[]) {
		int count, element;
		
		for(int i=1; i<arr.length; i++) {
			element = arr[i];
			count = i;
			
			while(count > 0 && arr[count-1] > element) { // While not at the start of the array and while arr[count] and arr[i] are out of order
				// Must use "element" in the while statement because changing arr[count] would change arr[i]
				arr[count] = arr[count-1]; // Shift arr[count] right one element
				count--;
			}
			
			arr[count] = element;
		}
		
	}
	
	public static int[] mergeSort(int arr[]) {
		if(arr.length == 1) {
			return arr;
		}
		
	    int result[] = new int[arr.length];
	    
	    int left[] = new int[arr.length/2];
	    int i;
	    for(i=0; i<left.length; i++) {
	        left[i] = arr[i];
	    }

	    
	    int right[] = new int[arr.length-i];
	    for(int j=0; j<right.length; j++) {
	        right[j] = arr[i];
	        i++;
	    }
	    
//	    System.out.println("Left = " + Arrays.toString(left));
//	    System.out.println("Right = " + Arrays.toString(right));
	    
        left = mergeSort(left);
        right = mergeSort(right);
        
        int lcount, rcount, count; //count = index for array result[]
        lcount = rcount = count = 0;
        
        while(lcount < left.length && rcount < right.length) {
        	result[count] = (left[lcount] < right[rcount]) ? left[lcount++] : right[rcount++];
        	count++;
        }
        
        while(lcount < left.length) {
        	result[count] = left[lcount++];
        	count++;
        }
        
        while(rcount < right.length) {
        	result[count] = right[rcount++];
        	count++;
        }
        
        return result;
	}
	
	public static int[] quickSort(int a[]) {
		if(a.length == 1) {
			return a;
		}
		
		int arr[] = a.clone();
		
		int down = 0;
		int up = arr.length -1;
		int pivot = (int) Math.random() * (arr.length);
		int temp;
		
		while( down != up ) {
			while( arr[pivot] < arr[up] && up != pivot) {
				up--;
			}
			
			while( arr[pivot] > arr[down] && down != pivot) {
				down--;
			}
			
			temp = arr[up];
			arr[up] = arr[down];
			arr[down] = temp;
		}

		temp = arr[0];
		arr[0] = arr[pivot];
		arr[pivot] = temp;
		
		int result[] = new int[arr.length];
	    
		
		
	    int left[] = new int[pivot+1];
	    int i;
	    for(i=0; i<left.length; i++) {
	        left[i] = arr[i];
	    }

	    
	    int right[] = new int[arr.length-pivot-1];
	    for(int j=0; j<right.length; j++) {
	        right[j] = arr[i];
	        i++;
	    }
	    
	    left = quickSort(left);
	    right = quickSort(right);
		
	    for(i=0; i<left.length; i++) {
	        result[i] = left[i];
	    }
	    
	    for(int j=0; j<right.length; j++) {
	        result[i] = right[j];
	        i++;
	    }
		
		
		return result;
	}
	
	
}
