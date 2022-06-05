package test.todo.gabrielmaia2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import main.todo.gabrielmaia2.*;

import org.junit.Test;

public class TodoListTest {
    @Test
    public void testGetDefaultListName() {
        TodoList list = new TodoList();
        String name = list.getName();

        String expectedStr = "Main list";

        assertEquals(expectedStr, name);

        list = new TodoList(new ArrayList<>());
        name = list.getName();

        assertEquals(expectedStr, name);
    }

    @Test
    public void testGetListName() {
        TodoList list = new TodoList("Test list");
        String name = list.getName();

        String expectedStr = "Test list";

        assertEquals(expectedStr, name);
    }

    @Test
    public void testEditListName() {
        TodoList list = new TodoList("Test list");
        list.setName("New name");

        String name = list.getName();

        String expectedStr = "New name";

        assertEquals(expectedStr, name);
    }

    @Test
    public void testGetItemsEmptyList() {
        TodoList list = new TodoList();
        String items = list.getItems();

        String expectedStr = "*List is empty*";

        assertEquals(expectedStr, items);
    }

    @Test
    public void testGetItemsNonEmptyList() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));

        TodoList list = new TodoList(items);
        String itemsStr = list.getItems();

        String expectedStr = "[ ] Do laundry\n";
        expectedStr += "[X] Clean house";

        assertEquals(expectedStr, itemsStr);
    }

    @Test
    public void testAddItemEmptyList() {
        TodoList list = new TodoList();

        list.add("Do laundry");
        String items = list.getItems();

        String expectedStr = "[ ] Do laundry";

        assertEquals(expectedStr, items);

        list.add("Clean house", true);
        items = list.getItems();

        expectedStr = "[ ] Do laundry\n";
        expectedStr += "[X] Clean house";

        assertEquals(expectedStr, items);
    }

    @Test
    public void testRemoveItemEmptyList() {
        TodoList list = new TodoList();

        String res = "";

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.remove(0);
        });

        res = e.getMessage();

        String expectedStr = "Can't remove item: List is empty.";

        assertTrue(res.contains(expectedStr));
    }

    @Test
    public void testRemoveItemOutOfBounds() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));
        items.add(new TodoItem("Do homework", false));

        TodoList list = new TodoList(items);

        String res = "";

        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });

        res = e.getMessage();

        assertTrue(res.contains("out of bounds"));

        e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(3);
        });

        res = e.getMessage();

        assertTrue(res.contains("out of bounds"));
    }

    @Test
    public void testRemoveItems() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));
        items.add(new TodoItem("Do homework", false));

        TodoList list = new TodoList(items);

        list.remove(0);

        String itemsStr = list.getItems();

        String expectedStr = "[X] Clean house\n";
        expectedStr += "[ ] Do homework";

        assertEquals(expectedStr, itemsStr);

        list.remove(1);

        itemsStr = list.getItems();

        expectedStr = "[X] Clean house";

        assertEquals(expectedStr, itemsStr);

        list.remove(0);

        itemsStr = list.getItems();

        expectedStr = "*List is empty*";

        assertEquals(expectedStr, itemsStr);
    }

    @Test
    public void testEditItemEmptyList() {
        TodoList list = new TodoList();

        String res = "";

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.edit(0, "Do homework");
        });

        res = e.getMessage();

        String expectedStr = "Can't edit item: List is empty.";

        assertTrue(res.contains(expectedStr));
    }

    @Test
    public void testEditItemIndexOutOfBounds() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));
        items.add(new TodoItem("Do homework", false));

        TodoList list = new TodoList(items);

        String res = "";

        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.edit(-1, "Eat a cake");
        });

        res = e.getMessage();

        assertTrue(res.contains("out of bounds"));

        e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.edit(3, "Eat a cake");
        });

        res = e.getMessage();

        assertTrue(res.contains("out of bounds"));
    }

    @Test
    public void testEditItem() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));
        items.add(new TodoItem("Do homework", true));

        TodoList list = new TodoList(items);

        list.edit(0, "Eat a cake");
        list.edit(2, "Be happier");

        String itemsStr = list.getItems();

        String expectedStr = "[ ] Eat a cake\n";
        expectedStr += "[X] Clean house\n";
        expectedStr += "[X] Be happier";

        assertEquals(expectedStr, itemsStr);
    }

    @Test
    public void testCheckItemEmptyList() {
        TodoList list = new TodoList();

        String res = "";

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.check(0);
        });

        res = e.getMessage();

        String expectedStr = "Can't check item: List is empty.";

        assertTrue(res.contains(expectedStr));
    }

    @Test
    public void testCheckItemIndexOutOfBounds() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));
        items.add(new TodoItem("Do homework", false));

        TodoList list = new TodoList(items);

        String res = "";

        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.check(-1);
        });

        res = e.getMessage();

        assertTrue(res.contains("out of bounds"));

        e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.check(3);
        });

        res = e.getMessage();

        assertTrue(res.contains("out of bounds"));
    }

    @Test
    public void testCheckItem() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", false));
        items.add(new TodoItem("Do homework", false));

        TodoList list = new TodoList(items);

        list.check(0);
        list.check(2);

        String itemsStr = list.getItems();

        String expectedStr = "[X] Do laundry\n";
        expectedStr += "[ ] Clean house\n";
        expectedStr += "[X] Do homework";

        assertEquals(expectedStr, itemsStr);
    }

    @Test
    public void testCheckItemMultipleTimes() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));
        items.add(new TodoItem("Do homework", false));

        TodoList list = new TodoList(items);

        list.check(0);
        list.check(2);
        list.check(1);
        list.check(1);
        list.check(0);

        String itemsStr = list.getItems();

        String expectedStr = "[ ] Do laundry\n";
        expectedStr += "[X] Clean house\n";
        expectedStr += "[X] Do homework";

        assertEquals(expectedStr, itemsStr);
    }

    @Test
    public void testEditCheckedItem() {
        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));

        TodoList list = new TodoList(items);

        list.edit(1, "Eat a cake");

        String itemsStr = list.getItems();

        String expectedStr = "[ ] Do laundry\n";
        expectedStr += "[X] Eat a cake";

        assertEquals(expectedStr, itemsStr);
    }

    @Test
    public void testToString() {
        TodoList list = new TodoList("Test list");
        String str = list.toString();

        String expectedItems = Util.tabString("*List is empty*");
        String expectedStr = "*Test list*\n";
        expectedStr += expectedItems;
        expectedStr += "\n*End*";

        assertEquals(expectedStr, str);

        ArrayList<TodoItem> items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));

        list = new TodoList("Test list", items);
        str = list.toString();

        expectedItems = "[ ] Do laundry\n";
        expectedItems += "[X] Clean house";
        expectedItems = Util.tabString(expectedItems);
        expectedStr = "*Test list*\n";
        expectedStr += expectedItems;
        expectedStr += "\n*End*";

        assertEquals(expectedStr, str);
    }
}
