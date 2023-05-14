package SerializationWithFile;

import java.io.Serializable;

public class MarketDataWithFile implements Serializable {

    private String securityId;
    private long time;
    private double low;
    private double open;
    private double high;
    private double close;
    private double last;
    private boolean isLevelOne;

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(final String securityId) {
        this.securityId = securityId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(final long time) {
        this.time = time;
    }

    public double getLow() {
        return low;
    }

    public void setLow(final double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(final double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(final double high) {
        this.high = high;
    }

    public double getClose() {
        return close;
    }

    public void setClose(final double close) {
        this.close = close;
    }

    public double getLast() {
        return last;
    }

    public void setLast(final double last) {
        this.last = last;
    }

    public boolean getIsLevelOne() {
        return isLevelOne;
    }

    public void setIsLevelOne(final boolean isLevelOne) {
        this.isLevelOne = isLevelOne;
    }

    @Override
    public String toString() {
        return "MarketDataWithFile{" +
                "securityId='" + securityId + '\'' +
                ", time=" + time +
                ", low=" + low +
                ", open=" + open +
                ", high=" + high +
                ", close=" + close +
                ", last=" + last +
                ", isLevelOne=" + isLevelOne +
                '}';
    }
}
