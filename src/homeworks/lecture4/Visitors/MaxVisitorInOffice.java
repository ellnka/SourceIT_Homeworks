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
        for (Visitor visitor : visitors) {
            System.out.println("Come " + new Date(visitor.getComeTime()));
            System.out.println("Leave " + new Date(visitor.getLeaveTime()));
        }
        int maxVisitorAtOnce = 0;

        /* Solution:
        * I know it could be better...But it seems it works
        * */
        
        for (int i = 0; i < visitors.length; i++) {
            int countOfVisitors = 1;
            for (int j = 0; j < i; j++) {
                if (visitors[i].getComeTime() <= visitors[j].getLeaveTime()
                        && visitors[i].getLeaveTime() >= visitors[j].getComeTime()) {
                    countOfVisitors++;
                }
            }
            maxVisitorAtOnce = (countOfVisitors > maxVisitorAtOnce) ? countOfVisitors : maxVisitorAtOnce;
        }
        System.out.println("Max visitors was " + maxVisitorAtOnce);
    }
}
