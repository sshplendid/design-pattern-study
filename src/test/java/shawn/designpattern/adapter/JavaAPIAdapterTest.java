package shawn.designpattern.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class JavaAPIAdapterTest {

    @Test
    @DisplayName("정수형 데이터를 리스트 객체로 생성한는 Arrays.asList")
    void asListTest() {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        assertThat(integers).hasSize(3);
    }

    @Test
    @DisplayName("File 객체를 받아 Reader 객체를 반환하는 BufferedReader")
    void bufferedReaderTest() {
        // GIVEN
        final String projectPath = System.getProperty("user.dir");
        final String relativePath = "/build/resources/test/hello.txt";

        final File hello = new File(projectPath + relativePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hello))) {

            // WHEN
            String contents = bufferedReader.lines().collect(joining("\n"));

            // THEN
            assertThat(contents).isNotNull();
            assertThat(contents).isEqualTo("Hello, World!");
            System.out.println(contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void inputStreamTest() {
        // GIVEN
        final String projectPath = System.getProperty("user.dir");
        final String relativePath = "/build/resources/test/hello.txt";
        final File file = new File(projectPath + relativePath);

        // WHEN
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[fileInputStream.available()];
            int i = 0;

            while(fileInputStream.available() > 0) {
                bytes[i++] = (byte) fileInputStream.read();
            }

            String string = new String(bytes);
            System.out.println(string);
            for (byte b : bytes) System.out.print(b + ", ");
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // THEN
    }
}
