package shawn.designpattern.command.impl;

import shawn.designpattern.command.Command;
import shawn.designpattern.command.Lamp;

public class LightOffCommand implements Command {

    private Lamp lamp;

    public LightOffCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        System.out.println(" 전등을 끈다.");
        lamp.turnOff();
    }
}
