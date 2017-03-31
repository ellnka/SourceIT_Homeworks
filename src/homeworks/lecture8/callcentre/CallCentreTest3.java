package homeworks.lecture8.callcentre;

import homeworks.lecture8.callcentre.impl.Call;
import homeworks.lecture8.callcentre.impl.CallCentre;

import java.util.*;

/***
 * Solution uses array of Integers which consists of two elements
 * and contains both duration and count of calls per each operator
 *
 */

public class CallCentreTest3 {
    private static final int TOTAL_CALLS = 10;
    private static final String OPERATOR = "Operator";

    public static void main(String[] args) {
        List<Call> calls = new LinkedList<>();

        for (int i = 0; i < TOTAL_CALLS; i++) {
            calls.add(CallCentre.produceCall());
        }

        System.out.println(Arrays.toString(calls.toArray()));

        Map<String, Integer[]> callDurations = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1Number = o1.substring(OPERATOR.length());
                int o1IntNumber = Integer.parseInt(o1Number) - 1;
                String o2Number = o2.substring(OPERATOR.length());
                int o2IntNumber = Integer.parseInt(o2Number) - 1;
                return o1IntNumber - o2IntNumber;
            }
        });

        for (Call call : calls) {
            if (callDurations.get(call.getOperator()) == null) {
                callDurations.put(call.getOperator(), new Integer[2]);
            }

            Integer[] currentOperatorCall = callDurations.get(call.getOperator());
            Integer[] operatorCalls = new Integer[2];
            operatorCalls[0] =  (currentOperatorCall[0] == null ? 0 : currentOperatorCall[0]) + call.getDuration();
            operatorCalls[1] = (currentOperatorCall[1] == null ? 0 : currentOperatorCall[1])  + 1;

            callDurations.put(call.getOperator(), operatorCalls);
        }


        for (Map.Entry<String, Integer[]> entry : callDurations.entrySet()) {
            System.out.println("Operator " + entry.getKey() + "  made " + entry.getValue()[1] + " call(s)"
                    + " and talked for " + entry.getValue()[0] + " minutes");
        }

    }
}
