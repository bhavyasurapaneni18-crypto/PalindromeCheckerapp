import java.util.Scanner;

class main{

    // Approach 1: Reverse String Method
    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Approach 2: Two-Pointer Method
    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // Approach 3: Recursive Method
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right)
            return true;
        if (str.charAt(left) != str.charAt(right))
            return false;
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Palindrome Checker Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Remove spaces & convert to lowercase for fair comparison
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Reverse Method Timing
        long start1 = System.nanoTime();
        boolean result1 = isPalindromeReverse(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Two Pointer Timing
        long start2 = System.nanoTime();
        boolean result2 = isPalindromeTwoPointer(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Recursive Timing
        long start3 = System.nanoTime();
        boolean result3 = isPalindromeRecursive(input, 0, input.length() - 1);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // Display Results
        System.out.println("\n=== Results ===");
        System.out.println("Reverse Method: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Two-Pointer Method: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Recursive Method: " + result3 + " | Time: " + time3 + " ns");

        sc.close();
    }
}