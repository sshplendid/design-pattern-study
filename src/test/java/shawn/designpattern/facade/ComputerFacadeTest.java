package shawn.designpattern.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerFacadeTest {

    @Test
    void execProgramWithFacade() {
        // GIVEN
        ComputerFacade myMacbook = new ComputerFacade();

        // WHEN
        myMacbook.boot();
        myMacbook.execProgram("VS Code");
    }

    @Test
    void execProgramWithoutFacade() {
        CPU cpu = new CPU();
        Memory ram = new Memory();
        SolidStateDrive ssd = new SolidStateDrive();

        // BOOT
        cpu.freeze();
        ram.load(0L, ssd.read(0L, 10));
        cpu.jump(0L);
        cpu.execute();

        // EXECUTE VS Code
        cpu.freeze();
        long programAddress = ssd.searchProgram("VS Code");
        byte[] programData = ssd.read(programAddress, 15);
        ram.load(programAddress, programData);
        cpu.jump(programAddress);
        cpu.execute();
    }
}