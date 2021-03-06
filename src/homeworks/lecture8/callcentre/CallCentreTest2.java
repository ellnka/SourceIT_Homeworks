package homeworks.lecture8.callcentre;

import homeworks.lecture8.callcentre.impl.Call;
import homeworks.lecture8.callcentre.impl.Pair;
import homeworks.lecture8.callcentre.impl.CallCentre;

import java.util.*;

/***
 * Solution uses the additional class Pairs which contains both
 * duration and count of calls per each operator
 */

public class CallCentreTest2 {
    private static final int TOTAL_CALLS = 10;
    private static final String OPERATOR = "Operator";

    public static void main(String[] args) {
        List<Call> calls = new ArrayList<>(TOTAL_CALLS);

        for (int i = 0; i < TOTAL_CALLS; i++) {
            calls.add(CallCentre.produceCall());
        }
        System.out.println(Arrays.toString(calls.toArray()));

        Pair[] pairs = new Pair[10];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(0, 0);
        }
        List<Pair> durationAndCount = Arrays.asList(pairs);
        Set<String> operators = new TreeSet <> (new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1Number = o1.substring(OPERATOR.length());
                int o1IntNumber = Integer.parseInt(o1Number);
                String o2Number = o2.substring(OPERATOR.length());
                int o2IntNumber = Integer.parseInt(o2Number);
                return o1IntNumber - o2IntNumber;
            }
        });

        for (Call call : calls) {
            int current = call.getDuration();
            String operator = call.getOperator();
            operators.add(operator);

            String operatorNumber = operator.substring(OPERATOR.length());
            int index = Integer.parseInt(operatorNumber) - 1;

            Pair currentOperatorCalls = durationAndCount.get(index);
            currentOperatorCalls.duration += current;
            currentOperatorCalls.count++;

            durationAndCount.set(index, currentOperatorCalls);
        }
        for (String operator : operators) {
            String operatorNumber = operator.substring(OPERATOR.length());
            int durationIndex = Integer.parseInt(operatorNumber) - 1;
            System.out.println("Operator " + operator + "  made " + durationAndCount.get(durationIndex).count + " call(s)"
                   + " and talked for " + durationAndCount.get(durationIndex).duration + " minutes");
        }
    }



}
