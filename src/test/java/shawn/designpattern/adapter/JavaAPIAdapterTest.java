package shawn.designpattern.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaAPIAdapterTest {

    @Test
    @DisplayName("정수형 데이터를 리스트 객체로 생성한는 Arrays.asList")
    void asListTest() {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        assertThat(integers).hasSize(3);
    }

    @Test
    @DisplayName("InputStream 객체를 받아 Reader 객체를 반환하는 InputStreamReader")
    void inputStreamReaderTest() {
        // GIVEN
        final String projectPath = System.getProperty("user.dir");
        final String relativePath = "/build/resources/test/hello.txt";

        final File hello = new File(projectPath + relativePath);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(hello)))) {

            // WHEN
            String contents = bufferedReader.lines().collect(Collectors.joining("\n"));

            // THEN
            assertThat(contents).isNotNull();
            assertThat(contents).isEqualTo("Hello, World!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
