package joohoyo.leetcode.challenge.june;

// Validate IP Address
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/
// 11:26 ~ 12:03 (37mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateIPAddress {
    @Test
    public void test() {
        ValidateIPAddress.Solution s = new ValidateIPAddress.Solution();

        assertEquals("Neither", s.validIPAddress("0.0.0.-0"));
        assertEquals("Neither", s.validIPAddress("00.0.0.0"));
        assertEquals("IPv4", s.validIPAddress("172.16.254.1"));
        assertEquals("Neither", s.validIPAddress("172.16.254.01"));
        assertEquals("Neither", s.validIPAddress("256.256.256.256"));
        assertEquals("Neither", s.validIPAddress("172.16.254.01."));
        assertEquals("Neither", s.validIPAddress(".172.16.254.01"));
        assertEquals("Neither", s.validIPAddress("172.16.254."));

        assertEquals("IPv6", s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        assertEquals("IPv6", s.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
        assertEquals("Neither", s.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
        assertEquals("Neither", s.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        assertEquals("Neither", s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        assertEquals("Neither", s.validIPAddress(":2001:0db8:85a3:0:0:8A2E:0370:7334"));
        assertEquals("Neither", s.validIPAddress(":2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        assertEquals("Neither", s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:"));
        assertEquals("Neither", s.validIPAddress("1081:db8:85a3:01:-0:8A2E:0370:7334"));
    }

    class Solution {
        static final String IPv4 = "IPv4";
        static final String IPv6 = "IPv6";
        static final String Neither = "Neither";

        private int count(String source, char target) {
            int n = 0;
            for (char c : source.toCharArray()) {
                if (c == target) {
                    n++;
                }
            }
            return n;
        }

        public String validIPAddress(String IP) {
            try {
                if (count(IP, '.') == 3) {
                    String[] ips = IP.split("\\."); // IP.split("\\.",-1); 을 이용하면 count 안해도 됨..
                    if (ips.length != 4) {
                        return Neither;
                    }

                    for (String ip : ips) {
                        if (ip.length() == 0) {
                            return Neither;
                        }
                        if (ip.length() != 1 && ip.startsWith("0")) {
                            return Neither;
                        }
                        if (ip.contains("-")) {
                            return Neither;
                        }

                        int n = Integer.parseInt(ip);
                        if (n < 0 || n > 255) {
                            return Neither;
                        }
                    }
                    return IPv4;
                }

                if (count(IP, ':') == 7) {
                    String[] ips = IP.split(":");
                    if (ips.length != 8) {
                        return Neither;
                    }
                    for (String ip : ips) {
                        if (ip.length() > 4 || ip.length() == 0) {
                            return Neither;
                        }
                        if (ip.contains("-")) {
                            return Neither;
                        }

                        int n = Integer.parseInt(ip, 16);
                    }
                    return IPv6;
                }
            } catch (Exception e) {
                return Neither;
            }

            return Neither;
        }
    }
}
