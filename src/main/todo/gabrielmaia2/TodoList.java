package main.todo.gabrielmaia2;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<TodoItem> items;

    public TodoList() {
        items = new ArrayList<>();
    }

    public TodoList(List<TodoItem> items) {
        this.items = items;
    }

    public String getItems() {
        if (items.isEmpty())
            return "*List is empty*";

        String res = items.get(0).toString();
        for (TodoItem item : items.subList(1, items.size())) {
            res += "\n" + item.toString();
        }

        return res;
    }

    public void add(String item, boolean checked) {
        items.add(new TodoItem(item, checked));
    }

    public void add(String item) {
        add(item, false);
    }

    public void remove(int index) {
        if (items.isEmpty())
            throw new IllegalStateException("Can't remove item: List is empty.");

        items.remove(index);
    }

    public void edit(int index, String newItem) {
        if (items.isEmpty())
            throw new IllegalStateException("Can't edit item: List is empty.");

        items.get(index).setItem(newItem);
    }

    public void check(int i) {
        if (items.isEmpty())
            throw new IllegalStateException("Can't check item: List is empty.");

        items.get(i).check();
    }
}
