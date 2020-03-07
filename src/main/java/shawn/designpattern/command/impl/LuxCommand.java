package shawn.designpattern.command.impl;

import shawn.designpattern.command.Command;
import shawn.designpattern.command.Lamp;

public class LuxCommand implements Command {

    private int lux;
    private Lamp lamp;

    public LuxCommand(int lux, Lamp lamp) {
        this.lux = lux;
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        System.out.println(" 밝기를 조절한다.");
        this.lamp.controlLux(lux);
    }
}
