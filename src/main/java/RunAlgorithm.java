public class MethodTester
{
    public static void main(String[] args) 
    {
        int[] nums = {-1, 5, -1, 3, -1, 17};
        //int[] nums = {-5, -3, -1, 4, 6, 8};
        //int[] nums = { -1, 12, -3, 14, -4, 3 };
        //int[] nums = { 2, -3, 5, -1, 0, 7};
        int result = algorithm1(nums);

        System.out.println("Max sum: " + result);
    }

    public static int algorithm1(int[] nums) 
    {
        int maxSum = 0;
       
        //TODO
    // Iterate through all subarrays
    for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
            // Compute sum of subarray A[i..j]
            sum += nums[j];
            // Update maxSum if current sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
         }
    }
        return maxSum;
    }


    public static int algorithm2(int[] nums) 
    {
        int maxSum = 0;
        
        //TODO
// Iterate through all subarrays
    for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        // Start with the sum of the first element
        sum = nums[i];
        // Update maxSum if current sum is greater
        if (sum > maxSum) {
            maxSum = sum;
        }
        for (int j = i + 1; j < nums.length; j++) {
            // Compute sum of subarray nums[i..j] using previous sum
            sum += nums[j];
            // Update maxSum if current sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
    }
        return maxSum;
    }


    // Optional
    public static int algorithm3(int[] nums)
    {
        int maxSum = 0;
       
        //TODO
    int n = nums.length;
    
    // Array to store sums
    int[] newArray = new int[n];
    
    // Compute sums for all subarrays
    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum += nums[j];
            newArray[j] = sum;
            // Update maxSum if current sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
         }
    }
        return maxSum;
    }
}
