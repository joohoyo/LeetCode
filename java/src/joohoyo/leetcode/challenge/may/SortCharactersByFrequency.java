package joohoyo.leetcode.challenge.may;

// Sort Characters By Frequency
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
// 22:57 ~ 23:14 (17min)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class SortCharactersByFrequency {
    @Test
    public void test() {
        SortCharactersByFrequency.Solution s = new SortCharactersByFrequency.Solution();

        assertThat(
                s.frequencySort(""),
                is("")
        );

        assertThat(
                s.frequencySort("tree"),
                anyOf(is("eert"), is("eetr"))
        );

        assertThat(
                s.frequencySort("cccaaa"),
                anyOf(is("cccaaa"), is("aaaccc"))
        );

        assertThat(
                s.frequencySort("Aabb"),
                anyOf(is("bbAa"), is("bbaA"))
        );
    }

    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            PriorityQueue<WeightCharacter> pq = new PriorityQueue<>();
            for (Character key : map.keySet()) {
                pq.add(new WeightCharacter(key, map.get(key)));
            }

            String answer = "";
            while (pq.size() > 0) {
                WeightCharacter wc = pq.poll();
                answer += String.valueOf(wc.getC()).repeat(wc.getCount());
            }
            return answer;
        }

        class WeightCharacter implements Comparable<WeightCharacter> {
            Character c;
            int count;

            WeightCharacter(Character c, int count) {
                super();
                this.c = c;
                this.count = count;
            }

            Character getC() {
                return c;
            }

            int getCount() {
                return count;
            }


            @Override
            public int compareTo(WeightCharacter o) {
                return this.count > o.count ? -1 : this.count < o.count ? 1 : 0;
            }
        }
    }
}
