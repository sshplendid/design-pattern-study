package shawn.designpattern.command;

import java.util.HashMap;
import java.util.Map;

public class LampRemoteController {
    Map<String, Command> commands;

    public LampRemoteController() {
        this.commands = new HashMap<>();
    }

    public LampRemoteController(Command lightOn, Command lightOff) {
        this();
        commands.put("default.on", lightOn);
        commands.put("default.off", lightOn);
    }

    public void clickOnButton(String lampName) {
        logName();
        this.commands.get(lampName + ".on").execute();
    }

    public void clickOffButton(String lampName) {
        logName();
        this.commands.get(lampName + ".off").execute();
    }

    public void controlLux(String lampName, String level) {
        logName();
        this.commands.get(lampName + "." + level + "Lux").execute();
    }

    private void logName() {
        System.out.println("리모컨으로 ");
    }

    public void addLampControl(String lampName, Command lightOn, Command lightOff) {
        commands.put(lampName + ".on", lightOn);
        commands.put(lampName + ".off", lightOff);
    }

    public void addLampControl(Map<String, Command> lampCommands) {
        commands.putAll(lampCommands);
    }
}
