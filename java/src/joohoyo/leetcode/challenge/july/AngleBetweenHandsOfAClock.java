package joohoyo.leetcode.challenge.july;

// Angle Between Hands of a Clock
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
// 18:50 ~ 19:01 (11mins)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AngleBetweenHandsOfAClock {
    @Test
    public void test() {
        AngleBetweenHandsOfAClock.Solution s = new AngleBetweenHandsOfAClock.Solution();

        Assertions.assertEquals(165, s.angleClock(12, 30));
        Assertions.assertEquals(75, s.angleClock(3, 30));
        Assertions.assertEquals(7.5, s.angleClock(3, 15));
        Assertions.assertEquals(155, s.angleClock(4, 50));
        Assertions.assertEquals(0, s.angleClock(12, 0));
        Assertions.assertEquals(76.5, s.angleClock(1, 57));
    }

    class Solution {
        public double angleClock(int hour, int minutes) {
            if (hour == 12) {
                hour = 0;
            }

            double mAngle = (double) minutes / 60 * 360;
            double hAngle = ((double) hour / 12 * 360) + ((double) minutes / 60 * (360 / 12));

            double answer = hAngle > mAngle ? hAngle - mAngle : mAngle - hAngle;
            return Math.min(answer, 360 - answer);
        }
    }
}
