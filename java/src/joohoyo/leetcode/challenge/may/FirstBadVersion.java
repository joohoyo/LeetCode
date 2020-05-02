package joohoyo.leetcode.challenge.may;

// First Bad Version
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
// 18:03 ~ 18:23 (20min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstBadVersion {
    @Test
    public void test() {

        FirstBadVersion.Solution s = new FirstBadVersion.Solution();

//        assertEquals(4, s.firstBadVersion(5));
//        assertEquals(1, s.firstBadVersion(1));
        assertEquals(1702766719, s.firstBadVersion(2126753390));
    }

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class VersionControl {
        int v;

        VersionControl() {
//            this.v = 4;
//            this.v = 1;
            this.v = 1702766719;
        }

        boolean isBadVersion(int version) {
            return version >= this.v;
        }
    }

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            int min = Integer.MAX_VALUE;
            while (left <= right) {
//                int mid = (int) (((long) left + (long) right) / 2);
                int mid = left + (right - left) / 2;
                boolean badVersion = isBadVersion(mid);
                if (badVersion == true) {
                    right = mid - 1;
                    min = Math.min(min, mid);
                } else {
                    left = mid + 1;
                }
            }
            return min;
        }
    }
}
