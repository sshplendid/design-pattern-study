package shawn.designpattern.command.example;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("요청한 작업을 수행한다.");
        });

        // Do something

        // 원할 때 쓰레드를 실행한다.
        t.start();
    }
}
