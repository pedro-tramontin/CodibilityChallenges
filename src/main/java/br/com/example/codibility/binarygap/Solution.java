package br.com.example.codibility.binarygap;

/**
 * @author ptramontin
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 9/4/17 5:36 PM
 */
class Solution {
    int init = -1;
    int max = 0;

    public int solution(int N) {
        String binaryForm = Integer.toBinaryString(N);

        int init = findFirstOne(binaryForm);
        if (init != -1) {
            for (int i = init + 1; i < binaryForm.length(); i++) {
                char ch = binaryForm.charAt(i);
                if (ch == '1') {
                    int end = i;

                    int gapSize = calculateGapSize(init, end);
                    if (gapSize > max) {
                        max = gapSize;
                    }

                    init = end;
                }
            }
        }

        return max;
    }

    private int calculateGapSize(int init, int end) {
        return end - init - 1;
    }

    private int findFirstOne(String binaryString) {
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1041));
    }
}