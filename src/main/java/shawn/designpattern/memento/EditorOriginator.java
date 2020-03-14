package shawn.designpattern.memento;

import java.time.LocalDateTime;

public class EditorOriginator {
    private LocalDateTime savedDateTime;
    private String content;

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
    public EditorMemento createMemento() {
        System.out.println("create a snapshot.");
        return new EditorMemento(LocalDateTime.now(), this.content);
    }

    /**
     * 메멘토(스냅샷)을 인자로 받아 이전 상태로 복구한다.
     * @param memento 복구하려는 메멘토 객체
     */
    public void restoreFrom(EditorMemento memento) {
        this.savedDateTime = memento.getState().savedDateTime;
        this.content = memento.getState().content;

        System.out.println("Restore state from " + savedDateTime);
    }

    public void write(String newContent) {
        this.content = newContent;
    }

    public void viewContent() {
        System.out.println("===content: START===");
        System.out.println(this.content);
        System.out.println("===content: END===");
    }

    class EditorMemento {

        private LocalDateTime savedDateTime;
        private String content;

        private EditorMemento(LocalDateTime savedDateTime, String content) {
            this.savedDateTime = savedDateTime;
            this.content = content;
        }

        // 메멘토가 가진 상태는 아우터 클래스에서만 접근 가능하다.
        private EditorOriginator getState() {
            return new EditorOriginator(this.savedDateTime, this.content);
        }
    }
}
