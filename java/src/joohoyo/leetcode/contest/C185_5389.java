package joohoyo.leetcode.contest;

// 5389. Display Table of Food Orders in a Restaurant
// https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/
// medium
// 12:04 ~ 12:25 (21min)

import org.junit.jupiter.api.Test;

import java.util.*;

public class C185_5389 {
    @Test
    public void test() {
        Solution s = new Solution();

        List<List<String>> orders = new ArrayList<>();
        orders.add(getOrder(new String[]{"David", "3", "Ceviche"}));
        orders.add(getOrder(new String[]{"Corina", "10", "Beef Burrito"}));

        // [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
        s.displayTable(orders); // pass
    }

    private List<String> getOrder(String[] data) {
        List<String> order = new ArrayList<>();
        order.add(data[0]);
        order.add(data[1]);
        order.add(data[2]);
        return order;
    }

    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            TreeSet<String> menus = new TreeSet<>();
            TreeMap<Integer, Map<String, Integer>> tables = new TreeMap<>();

            for (List<String> order : orders) {
                int tableNumber = Integer.parseInt(order.get(1));
                String foodItem = order.get(2);

                menus.add(foodItem);

                tables.putIfAbsent(tableNumber, new HashMap<>());
                Map<String, Integer> foods = tables.get(tableNumber);
                foods.put(foodItem, foods.getOrDefault(foodItem, 0) + 1);
            }

            List<List<String>> answer = new ArrayList<>();
            answer.add(getMenuList(menus));
            for (Integer tableNumber : tables.keySet()) {
                Map<String, Integer> table = tables.get(tableNumber);

                List<String> tableRow = new ArrayList<>();
                tableRow.add(String.valueOf(tableNumber));
                for (int i = 1; i < answer.get(0).size(); i++) {
                    String foodItem = answer.get(0).get(i);
                    int count = table.getOrDefault(foodItem, 0);
                    tableRow.add(String.valueOf(count));
                }
                answer.add(tableRow);
            }

            return answer;
        }

        private List<String> getMenuList(TreeSet<String> menus) {
            List<String> menuList = new ArrayList<>();
            menuList.add("Table");
            for (String menu : menus) {
                menuList.add(menu);
            }
            return menuList;
        }
    }
}
