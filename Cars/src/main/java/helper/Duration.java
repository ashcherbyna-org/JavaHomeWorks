package helper;

public class Duration {
    private long time;
    private String name;

    public Duration(long time, String name) {
        this.time = time;
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
