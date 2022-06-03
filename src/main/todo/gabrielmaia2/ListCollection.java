package main.todo.gabrielmaia2;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {
    private List<TodoList> lists;

    public ListCollection(List<TodoList> lists) {
        this.lists = lists;
    }

    public ListCollection() {
        this(new ArrayList<>());
    }
}
