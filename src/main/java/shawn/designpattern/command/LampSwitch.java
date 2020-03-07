package shawn.designpattern.command;

public class LampSwitch {

    private Command lightOn;
    private Command lightOff;
    private boolean clicked;

    public LampSwitch(Command lightOn, Command lightOff) {
        this.lightOn = lightOn;
        this.lightOff = lightOff;
        this.clicked = false;
    }

    public void toggle() {
        logName();
        (clicked ? lightOff : lightOn).execute();
        clicked = !clicked;
    }

    private void logName() {
        System.out.print("램프 스위치로 ");
    }
}
