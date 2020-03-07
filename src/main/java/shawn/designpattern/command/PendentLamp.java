package shawn.designpattern.command;

public class PendentLamp extends Lamp {

    private int lux;

    public PendentLamp(String name) {
        super(name);
    }

    @Override
    public void controlLux(int lux) {
        if(!isLightOn)
            isLightOn = true;

        System.out.println(String.format("- 램프의 밝기를 %d만큼 조절한다.", lux));
        this.lux = lux;
    }
}
