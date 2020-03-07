package shawn.designpattern.command;

public abstract class Lamp {

    protected String name;
    protected boolean isLightOn;

    public Lamp(String name) {
        this.name = name;
        this.isLightOn = false;
    }

    public void turnOn() {
        System.out.println("- " + name + " 전등에 불이 켜졌습니다.");
        isLightOn = true;
    }

    public void turnOff() {
        System.out.println("- " + name + " 전등에 불이 꺼졌습니다.");
        isLightOn = false;
    }

    public abstract void controlLux(int lux);
}
