package shawn.designpattern.adapter;

public class Iphone extends Phone implements LightningChargable {

    public Iphone(boolean cableConnected, int batteryPercentage) {
        super(cableConnected, batteryPercentage);
    }

    @Override
    public void connect() {
        System.out.println("라이트닝 케이블을 연결한다.");
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
