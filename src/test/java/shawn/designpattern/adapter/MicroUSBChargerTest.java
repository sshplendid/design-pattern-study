package shawn.designpattern.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MicroUSBChargerTest {

    @Test
    @DisplayName("안드로이드 스마트폰 충전")
    void chargeGalaxyWithMicroUSBCharger() {
        // GIVEN
        SamsungGalaxy androidPhone = new SamsungGalaxy(false, 50);
        MicroUSBCharger batteryCharger = new MicroUSBCharger(androidPhone);

        // WHEN
        batteryCharger.charge();

        // THEN
        assertTrue(androidPhone.isCableConnected());
        assertTrue(androidPhone.isFullyCharged());
    }

    @Test
    @DisplayName("아이폰 충전")
    void chargeIphoneWithMicroUSBCharger() {
        // GIVEN
        Iphone iphone = new Iphone(false, 90);
        MicroUSBCharger batteryCharger = new MicroUSBCharger(new LightningToMicroUSBAdapter(iphone));

        // WHEN
        batteryCharger.charge();

        // THEN
        assertTrue(iphone.isCableConnected());
        assertTrue(iphone.isFullyCharged());
    }
}