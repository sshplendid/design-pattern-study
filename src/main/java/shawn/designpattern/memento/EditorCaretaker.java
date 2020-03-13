package shawn.designpattern.memento;

import java.util.Deque;
import java.util.LinkedList;

public class EditorCaretaker {
    private EditorOriginator editorOriginator;
    private Deque<Memento<EditorOriginator>> history;

    public EditorCaretaker() {
        editorOriginator = new EditorOriginator();
        history = new LinkedList<>();
    }

    public void addAndSaveContent(String something) {
        editorOriginator.write(something + "\n");
        this.pushHistory(editorOriginator.createMemento());
    }

    public void pushHistory(Memento<EditorOriginator> memento) {
        history.push(memento);
    }

    public Memento<EditorOriginator> undo() {
        System.out.println("-> 이전 상태로 원복");
        return history.pop();
    }

    public static void main(String[] args) {
        EditorCaretaker caretaker = new EditorCaretaker();

        caretaker.addAndSaveContent("상태 1");
        caretaker.addAndSaveContent("상태 2");
        caretaker.addAndSaveContent("상태 3");
        caretaker.editorOriginator.write("저장되지 않은 컨텐츠");
        caretaker.editorOriginator.viewContent();

        caretaker.editorOriginator.restoreFrom(caretaker.undo());
        caretaker.editorOriginator.viewContent();

    }
}
