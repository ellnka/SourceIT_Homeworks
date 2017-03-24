package homeworks.lecture4.Visitors;

public class VisitorTimes {

    private boolean isCome = true;
    private long time = 0;

    public VisitorTimes(boolean isCome, long time) {
        this.isCome = isCome;
        this.time = time;
    }

    public boolean isCome() {
        return isCome;
    }

    public long getTime() {
        return time;
    }

    public static VisitorTimes[] createArrayOfTimes(Visitor[] visitors) {
        long countOfTimes = visitors.length * 2;
        if (countOfTimes > Integer.MAX_VALUE) {
            System.out.println("It's impossible to count. Too many visitors");
            return  null;
        }

        VisitorTimes[] visitorTimes = new VisitorTimes[(int)countOfTimes];
        int counter = 0;
        for (Visitor visitor: visitors) {
            visitorTimes[counter++] = new VisitorTimes(true, visitor.getComeTime());
            visitorTimes[counter++] = new VisitorTimes(false, visitor.getLeaveTime());
        }

        return visitorTimes;
    }

}
