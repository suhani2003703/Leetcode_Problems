public class Q18 {

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxXor = 0;

        // Build the trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        // Find the maximum XOR
        for (int num : nums) {
            TrieNode node = root;
            int currXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - bit;

                if (node.children[oppositeBit] != null) {
                    currXor |= (1 << i);
                    node = node.children[oppositeBit];
                } else {
                    node = node.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR of two numbers: " + findMaximumXOR(nums));
    }
}
