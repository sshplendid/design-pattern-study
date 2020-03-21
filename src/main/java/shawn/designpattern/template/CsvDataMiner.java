package shawn.designpattern.template;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvDataMiner extends AbstractDataMiner {
    private static final String COMMA = ",";

    @Override
    String extract(File target) {
        if(!target.getName().endsWith(".csv"))
            throw new RuntimeException("Illegal format.");

        try (BufferedReader br = new BufferedReader(new FileReader(target))) {
            return br.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    List<MineInfo> parseData(String rawData) {
        return Stream.of(rawData.split("\n"))
                .map(s -> {
                    String[] csv = s.split(COMMA);
                    return new MineInfo(Integer.parseInt(csv[0]), csv[1]);
                })
                .collect(Collectors.toList());
    }
}
