package main.todo.gabrielmaia2;

public class TodoItem {
    private String item;
    private boolean checked;

    public TodoItem(String item, boolean checked) {
        this.item = item;
        this.checked = checked;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String newItem) {
        item = newItem;
    }

    public boolean getChecked() {
        return checked;
    }

    public void check() {
        checked = !checked;
    }

    @Override
    public String toString() {
        String res = checked ? "[X] " : "[ ] ";
        res += item;
        return res;
    }
}
