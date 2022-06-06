package test.todo.gabrielmaia2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import main.todo.gabrielmaia2.*;

public class TodoItemTest {
    TodoItem item;

    @BeforeEach
    void setUp() {
        item = new TodoItem("Do laundry", true);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetSetItem() {
        item.setItem("Do homework");
        assertEquals("Do homework", item.getItem());
    }

    @Test
    public void testIsChecked() {
        assertEquals(true, item.isChecked());
    }

    @Test
    public void testCheck() {
        item.check();
        assertEquals(false, item.isChecked());

        item.check();
        assertEquals(true, item.isChecked());

        item.check();
        assertEquals(false, item.isChecked());
    }

    @Test
    public void testToStringUnchecked() {
        item = new TodoItem("Do laundry", false);
        assertEquals("[ ] Do laundry", item.toString());
    }

    @Test
    public void testToStringChecked() {
        assertEquals("[X] Do laundry", item.toString());
    }
}
