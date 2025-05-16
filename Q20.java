public class Q20 {

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        
        int result = 10; 
        int currentCount = 9;
        int availableDigits = 9;
        
        for (int i = 2; i <= n; i++) {
            currentCount *= availableDigits;
            result += currentCount;
            availableDigits--;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Count of numbers with unique digits for " + n + " digits: " + countNumbersWithUniqueDigits(n));
    }
}
