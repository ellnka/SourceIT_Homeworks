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

        /* Solution#1: */
        for (int i = 0; i < visitors.length; i++) {
            int countOfVisitorsAtTheMoment = countVisitorsAtTheMoment(visitors, i);
            maxVisitorAtOnce = Math.max(countOfVisitorsAtTheMoment,  maxVisitorAtOnce);
        }
        System.out.println("#1. Max visitors was " + maxVisitorAtOnce);

        /* Solution#2: */
        maxVisitorAtOnce = countMaxVisitorsAtOnce(visitors);
        System.out.println("#2. Max visitors was " + maxVisitorAtOnce );
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


    public static int countMaxVisitorsAtOnce(Visitor[] visitors) {

        VisitorTimes[] visitorTimes = VisitorTimes.createArrayOfTimes(visitors);
        Arrays.sort(visitorTimes, new Comparator<VisitorTimes>() {
            @Override
            public int compare(VisitorTimes o1, VisitorTimes o2) {
                return o1.getTime() > o2.getTime() ? 1 : -1;
            }
        });

        int maxVisitorAtOnce = 0;
        int countOfVisitors = 0;
        for (VisitorTimes time: visitorTimes) {
            countOfVisitors += time.isCome() ? 1 : -1;
            maxVisitorAtOnce = Math.max(countOfVisitors, maxVisitorAtOnce);
        }
        return maxVisitorAtOnce;
    }


}
