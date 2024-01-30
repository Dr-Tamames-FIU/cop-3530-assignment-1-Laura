_[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=13502325&assignment_repo_type=AssignmentRepo)
# Assignment 1

## Question 1: (100%)

Let A be an array of integers (positive or negative). Assume that the array is of size n. The subarray A[i..j] is the part of the array that starts at index i and ends at index j, where 0 ≤ i ≤ j ≤ n-1. Let s<sub>ij</sub> equal the sum of the integers in A[i..j].

We wish to solve the following problem:

### Important: Find the maximum value for s<sub>ij</sub> over all subarrays <b>with a maximum length of 3 </b> in array A, where 0 ≤ i ≤ j ≤ n-1.

The three algorithms given below solve this problem. 
NOTE: If all of the values in the array are negative, then the maximum value for s<sub>ij</sub> is 0 by default.

Example: If the array contains the values { -1, 12, -3, 14, -4, 3 }, then the maximum sum over all subarrays is 23 (for the subarray {12, -3, 14}). If the array contains the values { 2, -3, 5, -1, 7}, then the maximum sum over all subarrays is 11 (for the subarray {5, -1, 7}).

You are to write a Java program that determines the amount of work each of these algorithms does to compute its answer for arrays of various sizes. Using this data, you are to determine the runtime complexity of each algorithm.


### ALGORITHM 1
Start with a maximum sum of 0. Compute the sum of each 1-element subarray, then compute the sum of each 2-element subarray, then compute the sum of each 3-element subarray, etc. For each sum you compute, if it is larger than the maximum sum you've seen, then it becomes the maximum sum.


public static int algorithm1(int[] A) {
   int maxSum = 0;
// Iterate through all subarrays
    for (int i = 0; i < A.length; i++) {
        int sum = 0;
        for (int j = i; j < A.length; j++) {
            // Compute sum of subarray A[i..j]
            sum += A[j];
            // Update maxSum if current sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
         }
    }
    return maxSum;
}



### ALGORITHM 2 
Same as algorithm 1 but now once you compute the sum of the subarray from A[i] to A[j], the sum of the subarray from A[i] to A[j+1] is just the previous sum you computed plus A[j+1]. Don't add up all of the previous values all over again.


public static int algorithm2(int[] A) {
    int maxSum = 0;

    // Iterate through all subarrays
    for (int i = 0; i < A.length; i++) {
        int sum = 0;
        // Start with the sum of the first element
        sum = A[i];
        // Update maxSum if current sum is greater
        if (sum > maxSum) {
            maxSum = sum;
        }
        for (int j = i + 1; j < A.length; j++) {
            // Compute sum of subarray A[i..j] using previous sum
            sum += A[j];
            // Update maxSum if current sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
    }
    return maxSum;
}


### ALGORITHM 3 (Optional)
Same as algorithm 1 but store the temporary steps in an array. 


public static int algorithm3(int[] A) {
    int maxSum = 0;
    int n = A.length;
    int[] array = new int[n]; // Array to store maximum sum of subarrays ending at each index

    // Iterate through all subarrays
    for (int i = 0; i < n-1; i++) {
        // Initialize sum for current subarray
        int sum = 0;
        // Iterate through elements from i to the end
        for (int j = i; j < n-1; j++) {
            // Compute sum of subarray A[i..j]
            sum += A[j];
            // Update array[j] to store the maximum sum of subarrays ending at index j
            array[j] = Math.max(array[j], sum);
            // Update maxSum if current sum is greater
            maxSum = Math.max(maxSum, array[j]);
        }
    }
    return maxSum;
}


## Assignment TODO

Fix the class MethodTester that contains a main method and three static helper methods, one to implement each algorithm above. Your main method should test your methods with small arrays (like the ones in the examples above) so you know they work correctly before moving on.

Once you know the algorithms work correctly, run the class named RuntimeAnalyzer that contains the methods to quantify the algorithms. 

The class measures the time that your computer spends processing the algorithm using:
```java
long startTime = System.currentTimeMillis( ); // record the starting time
 /* (run the algorithm) */
long endTime = System.currentTimeMillis( ); // record the ending time
long elapsed = endTime − startTime;
```
If your computer is too fast, use:
```java
long startTime = System.nanoTime(); // record the starting time
 /* (run the algorithm) */
long endTime = System.nanoTime(); // record the ending time
long elapsed = endTime − startTime;
```
This class will run your algorithms for randomly generated arrays of size 5, 10, 15, ..., up to 50. For each array size,it will generate 20 arrays (one at a time) and run the algorithms with each array, averaging the returned number of assignment statements executed for each algorithm separately.


public class MethodTester {
	public static void main(String[] args) {
		// Test arrays
		int[][] arrays = { {-1, 12, -3, 14, -4, 3},};

		// Test algorithms with small arrays
		for (int[] arr : arrays) {
			System.out.println("Testing array: " + java.util.Arrays.toString(arr));
			System.out.println("Maximum subarray sum (Algorithm 1): " + algorithm1(arr));
			System.out.println("Maximum subarray sum (Algorithm 2): " + algorithm2(arr));
			System.out.println();
		}
	}

	// Algorithm 1
	public static int algorithm1(int[] A) {
		int maxSum = 0;

		// Iterate through all subarrays
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				// Compute sum of subarray A[i..j]
				sum += A[j];
				// Update maxSum if current sum is greater
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}

	// Algorithm 2
	public static int algorithm2(int[] A) {
		int maxSum = 0;

		// Iterate through all subarrays
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			// Start with the sum of the first element
			sum = A[i];
			// Update maxSum if current sum is greater
			if (sum > maxSum) {
				maxSum = sum;
			}
			// Iterate through remaining elements to calculate sum of subarrays
			for (int j = i + 1; j < A.length; j++) {
				// Update sum using the sum of previous subarray
				sum += A[j];
				// Update maxSum if current sum is greater
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
}


## Fix the method GenerateArray in RuntimeAnalyzer.java

Each array should have random values between -10 and 99, inclusive, and you can have duplicates. 
To generate a random number between x and y, use the following Java expression: 
```java
(int)(Math.random()*(y-x+1) + x) 
```

public int[] GenerateArray (int size) {
    int [] array = new int[size];
    for (int i=0; i < size; i++) {
        array[i] = (int)(Math.random()*(110) - 10 ) // values between -10 and 99
    }
    return array;
}
_
