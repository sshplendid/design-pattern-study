package shawn.designpattern.memento;

import java.time.LocalDateTime;

public class EditorOriginator {
    private LocalDateTime savedDateTime;
    private String content = "";

    public EditorOriginator() {
    }

    public EditorOriginator(LocalDateTime savedDateTime, String content) {
        this.savedDateTime = savedDateTime;
        this.content = content;
    }

    /**
     * 메멘토(스냅샷)을 생성한다.
     * @return 현재 상태의 메멘토 객체
     */
    public Memento createMemento() {
        System.out.println("create a snapshot.");
        return new EditorMemento(LocalDateTime.now(), this.content);
    }

    /**
     * 메멘토(스냅샷)을 인자로 받아 이전 상태로 복구한다.
     * @param memento 복구하려는 메멘토 객체
     */
    public void restoreFrom(Memento memento) {
        this.savedDateTime = memento.getState().savedDateTime;
        this.content = memento.getState().content;

        System.out.println("Restore state from " + savedDateTime);
    }

    public void write(String newContent) {
        this.content += newContent;
    }

    public void viewContent() {
        System.out.println("===content: START===");
        System.out.println(this.content);
        System.out.println("===content: END===");
    }

    private class EditorMemento implements Memento {

        private LocalDateTime savedDateTime;
        private String content;

        private EditorMemento(LocalDateTime savedDateTime, String content) {
            this.savedDateTime = savedDateTime;
            this.content = content;
        }

        public EditorOriginator getState() {
            return new EditorOriginator(this.savedDateTime, this.content);
        }
    }
}
