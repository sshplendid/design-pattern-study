package shawn.designpattern.adapter;

public class LightningToMicroUSBAdapter implements MicroUSBChargable {

    private LightningChargable lightningChargable;

    public LightningToMicroUSBAdapter(LightningChargable lightningChargable) {
        this.lightningChargable = lightningChargable;
    }

    @Override
    public void connect() {
        System.out.println("마이크로 USB 어댑터를 연결한다.");
        this.lightningChargable.connect();
    }

    @Override
    public void charge() {
        this.lightningChargable.charge();
    }
}
