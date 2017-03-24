package homeworks.lecture4.Visitors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class MaxVisitorInOffice {
    public static void main(String[] args) {
        Visitor[] visitors = Visitor.createVisitors();
        Arrays.sort(visitors, new Comparator<Visitor>() {
            @Override
            public int compare(Visitor o1, Visitor o2) {
                return o1.getComeTime() > o2.getComeTime() ? 1 : -1;
            }
        });

        for (int i = 0; i < visitors.length; i++) {
            System.out.print(" Come " + new Date(visitors[i].getComeTime()));
            System.out.print(" | Leave " + new Date(visitors[i].getLeaveTime()));
            System.out.println(" | Visitors " + countVisitorsAtTheMoment(visitors, i));
        }
        int maxVisitorAtOnce = 0;

        /* Solution: */

        for (int i = 0; i < visitors.length; i++) {
            int countOfVisitorsAtTheMoment = countVisitorsAtTheMoment(visitors, i);
            maxVisitorAtOnce = Math.max(countOfVisitorsAtTheMoment,  maxVisitorAtOnce);
        }
        System.out.println("Max visitors was " + maxVisitorAtOnce);

        /* Solution#2: */
        long[] times = new long[visitors.length];
        long min = Long.MAX_VALUE;
        int maxCount = 0;
        for (int i = 0; i < visitors.length; i++) {
            times[i] = -1 * visitors[i].getLeaveTime() + visitors[i].getComeTime();
            min = Math.max(min, times[i]);
        }
        for (int i = 0; i < visitors.length; i++) {
            if(times[i] <= min ) {
                maxCount++;
            }
        }

       // System.out.println(Arrays.toString(times));
        System.out.println("Max visitors was " + maxCount);
    }


    public static int countVisitorsAtTheMoment(Visitor[] visitors, int positionAtTheMoment) {
        int countOfVisitors = 1;
        for (int j = 0; j < positionAtTheMoment; j++) {
            if (visitors[positionAtTheMoment].getComeTime() <= visitors[j].getLeaveTime()
                    && visitors[positionAtTheMoment].getLeaveTime() >= visitors[j].getComeTime()) {
                countOfVisitors++;
            }
        }
        return countOfVisitors;
    }
}
