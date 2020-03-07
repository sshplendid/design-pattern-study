package shawn.designpattern.command;

import shawn.designpattern.command.impl.LightOffCommand;
import shawn.designpattern.command.impl.LightOnCommand;
import shawn.designpattern.command.impl.LuxCommand;

import java.util.HashMap;
import java.util.Map;

public class BedRoom {
    public static void main(String[] args) {

        // Receiver
        Lamp tableLamp = new TableLamp("테이블램프");

        // Commands
        Command tableLampOn = new LightOnCommand(tableLamp);
        Command tableLampOff = new LightOffCommand(tableLamp);

        // Invoker
        LampSwitch tableLampSwitch = new LampSwitch(tableLampOn, tableLampOff);
        LampRemoteController remoteController = new LampRemoteController();
        remoteController.addLampControl("tableLamp", tableLampOn, tableLampOff);

        // 테이블 램프를 켠다.
        tableLampSwitch.toggle();

        // 테이블 램프를 끈다.
        remoteController.clickOffButton("tableLamp");

        // Receiver
        Lamp pendentLamp = new PendentLamp("펜던트램프");

        // Commands
        LightOnCommand pendentLampOn = new LightOnCommand(pendentLamp);
        LightOffCommand pendentLampOff = new LightOffCommand(pendentLamp);

        Map<String, Command> pendentCommands = new HashMap<>();
        pendentCommands.put("pendent.on", pendentLampOn);
        pendentCommands.put("pendent.off", pendentLampOff);
        pendentCommands.put("pendent.lowLux", new LuxCommand(30, pendentLamp));
        pendentCommands.put("pendent.midLux", new LuxCommand(60, pendentLamp));
        pendentCommands.put("pendent.highLux", new LuxCommand(100, pendentLamp));

        // Invoker
        LampSwitch pendentLampSwitch = new LampSwitch(pendentLampOn,pendentLampOff);
        remoteController.addLampControl(pendentCommands);

        // 펜던트 램프를켠다.
        remoteController.clickOnButton("pendent");

        // 밝기를 조절한다.
        remoteController.controlLux("pendent", "mid");
    }
}
