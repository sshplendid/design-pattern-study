package shawn.designpattern.template;

import java.io.File;
import java.util.List;

public abstract class AbstractDataMiner {
    final void mine(String path) {
        File target = new File(path);
        String rawData = extract(target);
        List<MineInfo> parseData = parseData(rawData);
        analyze(parseData);

        sendReposrt();
    }

    private void sendReposrt() {
        System.out.println("리포트 생성");
    }

    private void analyze(List<MineInfo> parseData) {
        System.out.println("분석중...");
    }

    abstract String extract(File target);
    abstract List<MineInfo> parseData(String rawData);
}

class MineInfo {
    private int id;
    private String name;

    public MineInfo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
