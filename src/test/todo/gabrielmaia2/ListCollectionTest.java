package test.todo.gabrielmaia2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import main.todo.gabrielmaia2.*;

import org.junit.Test;

public class ListCollectionTest {
    @Test
    public void testGetItemsEmptyList() {
        TodoList list = new TodoList();
        String items = list.getItems();

        String expectedStr = "*List is empty*";

        assertEquals(expectedStr, items);
    }
}
