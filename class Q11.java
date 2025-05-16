public class Q11 {
    

        public static int[] findPairWithSum(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;
    
            while (left < right) {
                int currentSum = arr[left] + arr[right];
    
                if (currentSum == target) {
                    return new int[]{arr[left], arr[right]};
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
    
            return null; // No pair found
        }
    
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 6, 8, 9};
            int target = 10;
    
            int[] result = findPairWithSum(arr, target);
    
            if (result != null) {
                System.out.println("Pair found: " + result[0] + " and " + result[1]);
            } else {
                System.out.println("No pair found.");
            }
        }
    }
    
    