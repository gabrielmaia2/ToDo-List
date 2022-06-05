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

    public TodoList getList(int index) {
        if (lists.isEmpty())
            throw new IllegalStateException("Can't get list: Collection is empty.");

        return lists.get(index);
    }

    public String getLists() {
        if (lists.isEmpty())
            return "*There are no lists*";

        String res = lists.get(0).getName();
        for (TodoList todoList : lists.subList(1, lists.size())) {
            res += "\n" + todoList.getName();
        }

        return res;
    }

    public void addList(TodoList list) {
        lists.add(list);
    }

    public void removeList(int index) {
        if (lists.isEmpty())
            throw new IllegalStateException("Can't remove list: Collection is empty.");

        lists.remove(index);
    }

    public String toShortString() {
        String res = "*Lists*\n";
        res += Util.tabString(getLists());
        res += "\n*End*";

        return res;
    }

    @Override
    public String toString() {
        String listsStr = "*There are no lists*";

        if (!lists.isEmpty()) {
            listsStr = lists.get(0).toString();
            for (TodoList todoList : lists.subList(1, lists.size())) {
                listsStr += "\n" + todoList.toString();
            }
        }

        String res = "*Lists*\n";
        res += Util.tabString(listsStr);
        res += "\n*End*";

        return res;
    }
}
