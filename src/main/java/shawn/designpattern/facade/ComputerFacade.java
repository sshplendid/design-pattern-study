package shawn.designpattern.facade;

public class ComputerFacade {
    private static final long BOOT_ADDRESS = 0L;
    private static final long BOOT_SECTOR = 0L;
    private static final int SECTOR_SIZE = 10;
    
    private final CPU processor;
    private final Memory ram;
    private final SolidStateDrive ssd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.ssd = new SolidStateDrive();
    }
    
    public void boot() {
        processor.freeze();
        ram.load(BOOT_ADDRESS, ssd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }

    public void execProgram(String program) {
        long programAddress = ssd.searchProgram(program);
        byte[] programData = ssd.read(programAddress, 15);
        ram.load(programAddress, programData);
        processor.jump(programAddress);
        processor.execute();
    }
}

class CPU {
    public void freeze() {
        System.out.println("CPU freeze");
    }

    public void jump(long position) {
        System.out.println("jump to " + position);
    }

    public void execute() {
        System.out.println("CPU execute.");
    }
}

class SolidStateDrive {
    private byte[] data;

    public byte[] read(long startAt, int size) {
        System.out.println("Read data from " + startAt + " with size " + size);
        return data;
    }

    public long searchProgram(String program) {
        System.out.println("Searching program '" + program + "' at SSD...");
        return 1;
    }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Load data to memory.");
    }
}
