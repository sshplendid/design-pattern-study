package shawn.designpattern.command;

public class TableLamp extends Lamp {

    public TableLamp(String name) {
        super(name);
    }

    @Override
    public void controlLux(int lux) {
        throw new IllegalStateException("테이블램프는 밝기를 조절할 수 없다.");

    }
}
