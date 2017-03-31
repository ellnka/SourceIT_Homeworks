package homeworks.lecture8.callcentre;


import homeworks.lecture8.callcentre.impl.Call;
import homeworks.lecture8.callcentre.impl.CallCentre;

import java.util.Arrays;

public class CallCentreTest1 {
    public static void main(String[] args) {
        Call[] calls = new Call[10];

        for (int index = 0; index < calls.length; index++) {
            calls[index] = CallCentre.produceCall();
        }
        System.out.println(Arrays.toString(calls));
    }
}
