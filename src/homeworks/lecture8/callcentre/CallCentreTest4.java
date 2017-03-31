package homeworks.lecture8.callcentre;

import homeworks.lecture8.callcentre.impl.Call;
import homeworks.lecture8.callcentre.impl.CallCentre;

import java.util.*;

/***
 * Solution uses ArrayList of Integers which consists of two elements:
 * the first is a duration and the second is a count of calls per each operator
 *
 */

public class CallCentreTest4 {
    private static final int TOTAL_CALLS = 10;
    private static final String OPERATOR = "Operator";

    public static void main(String[] args) {
        List<Call> calls = new LinkedList<>();

        for (int i = 0; i < TOTAL_CALLS; i++) {
            calls.add(CallCentre.produceCall());
        }

        System.out.println(Arrays.toString(calls.toArray()));

        Map<String, ArrayList<Integer>> callDurations = new TreeMap<>(new Comparator<String>() {
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
                callDurations.put(call.getOperator(), new ArrayList<>(Arrays.asList(call.getDuration(), 1)));
            } else {
                callDurations.put(call.getOperator(), new ArrayList<>(
                        Arrays.asList(callDurations.get(call.getOperator()).get(0) + call.getDuration(),
                                callDurations.get(call.getOperator()).get(1) + 1)));
            }
        }


        for (Map.Entry<String, ArrayList<Integer>> entry : callDurations.entrySet()) {
            System.out.println("Operator " + entry.getKey() + "  made " + entry.getValue().get(1) + " call(s)"
                    + " and talked for " + entry.getValue().get(0) + " minutes");
        }

    }
}
