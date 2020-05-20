package joohoyo.leetcode.challenge.may;

// Online Stock Span
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
// 15:36 ~ 15:50 (14min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan {
    @Test
    public void test() {
        StockSpanner s = new StockSpanner();

        Assertions.assertEquals(1, s.next(100));
        Assertions.assertEquals(1, s.next(80));
        Assertions.assertEquals(1, s.next(60));
        Assertions.assertEquals(2, s.next(70));
        Assertions.assertEquals(1, s.next(60));
        Assertions.assertEquals(4, s.next(75));
        Assertions.assertEquals(6, s.next(85));
    }

    class StockSpanner {
        List<Integer> prices;

        public StockSpanner() {
            prices = new ArrayList<>();
        }

        public int next(int price) {
            prices.add(price);

            int answer = 0;
            for (int i = prices.size() - 1; i >= 0; i--) {
                if (prices.get(i) <= price) {
                    answer++;
                } else {
                    break;
                }
            }
            return answer;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
