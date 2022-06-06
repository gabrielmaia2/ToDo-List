package test.todo.gabrielmaia2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import main.todo.gabrielmaia2.*;
import main.todo.gabrielmaia2.models.TodoItem;
import main.todo.gabrielmaia2.models.TodoList;

public class TodoListTest {
    TodoList list;
    List<TodoItem> items;
    TodoItem item;

    @BeforeEach
    void setUp() {
        items = new ArrayList<>();
        items.add(new TodoItem("Do laundry", false));
        items.add(new TodoItem("Clean house", true));
        items.add(new TodoItem("Do homework", false));

        list = new TodoList("Test list", items);
        item = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetSetListName() {
        list.setName("New name");
        assertEquals("New name", list.getName());
    }

    @Test
    public void testGetDefaultListName() {
        list = new TodoList();
        assertEquals("Main list", list.getName());

        list = new TodoList(new ArrayList<>());
        assertEquals("Main list", list.getName());
    }

    @Test
    public void testGetItemEmptyList() {
        list = new TodoList();

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.getItem(0);
        });

        String res = e.getMessage();
        assertTrue(res.contains("Can't get item: List is empty."));
    }

    @Test
    public void testGetItemOutOfBounds() {
        String res = "";

        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getItem(-1);
        });

        res = e.getMessage();
        assertTrue(res.contains("out of bounds"));

        e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getItem(3);
        });

        res = e.getMessage();
        assertTrue(res.contains("out of bounds"));
    }

    @Test
    public void testGetItem() {
        TodoItem item = list.getItem(0);
        TodoItem expected = items.get(0);
        assertEquals(expected.getItem(), item.getItem());
        assertEquals(expected.isChecked(), item.isChecked());

        item = list.getItem(1);
        expected = items.get(1);
        assertEquals(expected.getItem(), item.getItem());
        assertEquals(expected.isChecked(), item.isChecked());

        item = list.getItem(2);
        expected = items.get(2);
        assertEquals(expected.getItem(), item.getItem());
        assertEquals(expected.isChecked(), item.isChecked());
    }

    @Test
    public void testGetItemsEmptyList() {
        list = new TodoList();
        assertTrue(list.getItems().isEmpty());
    }

    @Test
    public void testGetItemsNonEmptyList() {
        items = list.getItems();
        assertEquals(3, items.size());

        item = items.get(0);
        assertEquals("Do laundry", item.getItem());
        assertEquals(false, item.isChecked());

        item = items.get(1);
        assertEquals("Clean house", item.getItem());
        assertEquals(true, item.isChecked());

        item = items.get(2);
        assertEquals("Do homework", item.getItem());
        assertEquals(false, item.isChecked());
    }

    @Test
    public void testAddItem() {
        list = new TodoList();

        list.add("Do laundry");
        items = list.getItems();
        assertEquals(1, items.size());

        item = items.get(0);
        assertEquals("Do laundry", item.getItem());
        assertEquals(false, item.isChecked());

        list.add("Clean house", true);
        items = list.getItems();
        assertEquals(2, items.size());

        item = items.get(0);
        assertEquals("Do laundry", item.getItem());
        assertEquals(false, item.isChecked());

        item = items.get(1);
        assertEquals("Clean house", item.getItem());
        assertEquals(true, item.isChecked());
    }

    @Test
    public void testRemoveItemEmptyList() {
        list = new TodoList();

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.remove(0);
        });

        String res = e.getMessage();
        assertTrue(res.contains("Can't remove item: List is empty."));
    }

    @Test
    public void testRemoveItemOutOfBounds() {
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
        list.remove(0);

        items = list.getItems();
        assertEquals(2, items.size());

        item = items.get(0);
        assertEquals("Clean house", item.getItem());
        assertEquals(true, item.isChecked());

        item = items.get(1);
        assertEquals("Do homework", item.getItem());
        assertEquals(false, item.isChecked());

        list.remove(1);

        items = list.getItems();
        assertEquals(1, items.size());

        item = items.get(0);
        assertEquals("Clean house", item.getItem());
        assertEquals(true, item.isChecked());

        list.remove(0);

        items = list.getItems();
        assertTrue(items.isEmpty());
    }

    @Test
    public void testEditItemEmptyList() {
        list = new TodoList();

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.edit(0, "Do homework");
        });

        String res = e.getMessage();
        assertTrue(res.contains("Can't edit item: List is empty."));
    }

    @Test
    public void testEditItemIndexOutOfBounds() {
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
        list.edit(0, "Eat a cake");
        list.edit(1, "Be happier");

        items = list.getItems();

        item = items.get(0);
        assertEquals("Eat a cake", item.getItem());
        assertEquals(false, item.isChecked());

        item = items.get(1);
        assertEquals("Be happier", item.getItem());
        assertEquals(true, item.isChecked());

        item = items.get(2);
        assertEquals("Do homework", item.getItem());
        assertEquals(false, item.isChecked());
    }

    @Test
    public void testCheckItemEmptyList() {
        TodoList list = new TodoList();

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.check(0);
        });

        String res = e.getMessage();
        assertTrue(res.contains("Can't check item: List is empty."));
    }

    @Test
    public void testCheckItemIndexOutOfBounds() {
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
        list.check(0);
        list.check(2);

        items = list.getItems();

        item = items.get(0);
        assertEquals("Do laundry", item.getItem());
        assertEquals(true, item.isChecked());

        item = items.get(1);
        assertEquals("Clean house", item.getItem());
        assertEquals(true, item.isChecked());

        item = items.get(2);
        assertEquals("Do homework", item.getItem());
        assertEquals(true, item.isChecked());
    }

    @Test
    public void testCheckItemMultipleTimes() {
        list.check(0);
        list.check(2);
        list.check(1);
        list.check(1);
        list.check(0);

        items = list.getItems();

        item = items.get(0);
        assertEquals("Do laundry", item.getItem());
        assertEquals(false, item.isChecked());

        item = items.get(1);
        assertEquals("Clean house", item.getItem());
        assertEquals(true, item.isChecked());

        item = items.get(2);
        assertEquals("Do homework", item.getItem());
        assertEquals(true, item.isChecked());
    }

    @Test
    public void testItemsToStringEmptyList() {
        list = new TodoList("Test list");
        String str = list.itemsToString();

        assertEquals("*List is empty*", str);
    }

    @Test
    public void testItemsToString() {
        String str = list.itemsToString();

        String expectedStr = "[ ] Do laundry\n";
        expectedStr += "[X] Clean house\n";
        expectedStr += "[ ] Do homework";

        assertEquals(expectedStr, str);
    }

    @Test
    public void testToStringEmptyList() {
        list = new TodoList("Test list");
        String str = list.toString();

        String expectedStr = "*Test list*\n";
        expectedStr += Util.tabString("*List is empty*");
        expectedStr += "\n*End*";

        assertEquals(expectedStr, str);
    }

    @Test
    public void testToString() {
        String str = list.toString();

        String expectedItems = list.getItem(0).toString() + "\n";
        expectedItems += list.getItem(1).toString() + "\n";
        expectedItems += list.getItem(2).toString();
        String expectedStr = "*Test list*\n";
        expectedStr += Util.tabString(expectedItems);
        expectedStr += "\n*End*";

        assertEquals(expectedStr, str);
    }
}
