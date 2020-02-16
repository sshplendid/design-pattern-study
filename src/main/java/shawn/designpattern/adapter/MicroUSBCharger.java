package shawn.designpattern.adapter;

public class MicroUSBCharger {

    private MicroUSBChargable chargeTarget;

    public MicroUSBCharger(MicroUSBChargable chargeTarget) {
        this.chargeTarget = chargeTarget;
    }

    public void charge() {
        System.out.println("충전을 시작합니다.");
        chargeTarget.connect();
        System.out.println("충전중...");
        chargeTarget.charge();
        System.out.println("충전 완료");
    }
}
