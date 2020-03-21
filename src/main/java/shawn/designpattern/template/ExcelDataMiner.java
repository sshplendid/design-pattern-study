package shawn.designpattern.template;

import java.io.File;
import java.util.List;

public class ExcelDataMiner extends AbstractDataMiner {

    @Override
    String extract(File target) {
        if(!target.getName().endsWith(".xlsx") || !target.getName().endsWith(".xls"))
            throw new RuntimeException("Illegal format.");

        // Do something

        return null;
    }

    @Override
    List<MineInfo> parseData(String rawData) {

        // Do Something

        return null;
    }
}
