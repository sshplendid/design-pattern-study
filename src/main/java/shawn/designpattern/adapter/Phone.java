package shawn.designpattern.adapter;

public abstract class Phone {

    private boolean cableConnected;
    private int batteryPercentage;

    public Phone(boolean cableConnected, int batteryPercentage) {
        this.cableConnected = cableConnected;
        this.batteryPercentage = batteryPercentage;
    }

    public boolean isCableConnected() {
        return cableConnected;
    }

    public void connectCable() {
        this.cableConnected = true;
    }

    public void disconnectCable() {
        this.cableConnected = false;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public boolean isFullyCharged() {
        return getBatteryPercentage() == 100;
    }
}
