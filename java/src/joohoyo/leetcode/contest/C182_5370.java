package joohoyo.leetcode.contest;

// 5370. Design Underground System
// https://leetcode.com/contest/weekly-contest-182/problems/design-underground-system/
// 11:56 ~ 12:18 (22min)

import java.util.HashMap;
import java.util.Map;

public class C182_5370 {

    public static void main(String[] args) {
        new C182_5370().test();
    }

    public void test() {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.0
    }


    class UndergroundSystem {
        Map<String, double[]> averageTimes;
        Map<Integer, Travel> checkIns;

        public UndergroundSystem() {
            this.averageTimes = new HashMap<>();
            this.checkIns = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkIns.put(id, new Travel(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Travel travel = checkIns.get(id);
            String travelName = getTravelKey(travel.getStationName(), stationName);
            int time = t - travel.getT();
            if (averageTimes.containsKey(travelName)) {
                double averageTime = averageTimes.get(travelName)[0];
                int count = (int) averageTimes.get(travelName)[1];
                double modifiedTime = (averageTime * count + time) / (count + 1);
                averageTimes.put(travelName, new double[]{modifiedTime, count + 1});
            } else {
                averageTimes.put(travelName, new double[]{time, 1});
            }
            checkIns.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            System.out.println(averageTimes.get(getTravelKey(startStation, endStation))[0]);
            return averageTimes.get(getTravelKey(startStation, endStation))[0];
        }

        private String getTravelKey(String startStation, String endStation) {
            return startStation + "-" + endStation;
        }

        class Travel {
            String stationName;
            int t;

            public Travel(String stationName, int t) {
                this.stationName = stationName;
                this.t = t;
            }

            public String getStationName() {
                return this.stationName;
            }

            public int getT() {
                return this.t;
            }
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
