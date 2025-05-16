public class Q16 {

    public static int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

       
        if (count > nums.length / 2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element");
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Element: " + majorityElement(nums));
    }
}
