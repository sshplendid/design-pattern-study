package shawn.designpattern.adapter;

public class SamsungGalaxy extends Phone implements MicroUSBChargable {

    public SamsungGalaxy(boolean cableConnected, int batteryPercentage) {
        super(cableConnected, batteryPercentage);
    }

    @Override
    public void connect() {
        System.out.println("Micro USB 케이블을 연결한다.");
        this.connectCable();
    }

    @Override
    public boolean isFullyCharged() {
        return this.getBatteryPercentage() == 100;
    }

    @Override
    public void charge() {
        this.setBatteryPercentage(100);
    }
}
