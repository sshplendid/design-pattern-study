package shawn.designpattern.template;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayQueueTest {
    @Test
    void addAll() {
        // GIVEN
        List<String> arrayQueue = new ArrayQueue<>(10);
        arrayQueue.add("apple");
        arrayQueue.add("banana");

        List<String> dairy = Arrays.asList("milk", "cheese");

        // WHEN
        arrayQueue.addAll(dairy);

        // THEN
        System.out.println(arrayQueue);
    }
}
