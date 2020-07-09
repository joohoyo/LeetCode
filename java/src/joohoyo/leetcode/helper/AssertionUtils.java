package joohoyo.leetcode.helper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionUtils {
    public static <T> void assertDoubleListEquals(List<List<T>> expected, List<List<T>> actual) {
        assertEquals(expected.size(), actual.size());

        expected.stream().forEach(e -> {
            assertTrue(actual.stream().anyMatch(item -> item.equals(e)));
        });
    }
}
