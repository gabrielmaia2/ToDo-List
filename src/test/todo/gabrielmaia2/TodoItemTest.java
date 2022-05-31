package test.todo.gabrielmaia2;

import static org.junit.Assert.assertEquals;

import main.todo.gabrielmaia2.*;

import org.junit.Test;

public class TodoItemTest {
    @Test
    public void testCheckToString() {
        TodoItem item = new TodoItem("Do laundry", false);

        String res = item.toString();
        String expectedStr = "[ ] Do laundry";

        assertEquals(expectedStr, res);

        item = new TodoItem("Do homework", true);

        res = item.toString();
        expectedStr = "[X] Do homework";

        assertEquals(expectedStr, res);
    }

    @Test
    public void testCheckGetters() {
        TodoItem item = new TodoItem("Do laundry", true);

        assertEquals("Do laundry", item.getItem());
        assertEquals(true, item.getChecked());
    }

    @Test
    public void testCheckSetItem() {
        TodoItem item = new TodoItem("Do laundry", true);

        assertEquals("[X] Do laundry", item.toString());

        item.setItem("Do homework");

        assertEquals("[X] Do homework", item.toString());

    }

    @Test
    public void testCheckCheck() {
        TodoItem item = new TodoItem("Do laundry", false);

        assertEquals("[ ] Do laundry", item.toString());

        item.check();

        assertEquals("[X] Do laundry", item.toString());

        item.check();
        item.check();
        item.check();

        assertEquals("[ ] Do laundry", item.toString());
    }

    @Test
    public void testCheckCheckMultipleTimes() {
        TodoItem item = new TodoItem("Do laundry", true);

        assertEquals("[X] Do laundry", item.toString());

        item.check();
        assertEquals("[ ] Do laundry", item.toString());

        item.check();
        assertEquals("[X] Do laundry", item.toString());

        item.check();
        assertEquals("[ ] Do laundry", item.toString());
    }
}
