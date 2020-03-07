package shawn.designpattern.command.impl;

import shawn.designpattern.command.Command;
import shawn.designpattern.command.Lamp;

public class LightOnCommand implements Command {

    private Lamp lamp;

    public LightOnCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        System.out.println(" 전등을 켠다.");
        lamp.turnOn();
    }
}
