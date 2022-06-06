package test.todo.gabrielmaia2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import main.todo.gabrielmaia2.*;
import main.todo.gabrielmaia2.models.ListCollection;
import main.todo.gabrielmaia2.models.TodoList;

import java.util.ArrayList;
import java.util.List;

public class ListCollectionTest {
    ListCollection list;
    List<TodoList> tlists;

    @BeforeEach
    void setUp() {
        tlists = new ArrayList<>();
        tlists.add(new TodoList("List 1"));
        tlists.add(new TodoList("List 2"));
        tlists.add(new TodoList("List 3"));
        list = new ListCollection(tlists);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetListEmptyCollection() {
        list = new ListCollection();

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.getList(0);
        });

        String res = e.getMessage();
        assertTrue(res.contains("Can't get list: Collection is empty."));
    }

    @Test
    public void testGetListOutOfBounds() {
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getList(-1);
        });

        String res = e.getMessage();
        assertTrue(res.contains("out of bounds"));

        e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getList(3);
        });

        res = e.getMessage();
        assertTrue(res.contains("out of bounds"));
    }

    @Test
    public void testGetList() {
        TodoList tlist = list.getList(0);
        assertEquals(tlists.get(0), tlist);

        tlist = list.getList(1);
        assertEquals(tlists.get(1), tlist);

        tlist = list.getList(2);
        assertEquals(tlists.get(2), tlist);
    }

    @Test
    public void testListNamesToStringEmptyCollection() {
        ListCollection list = new ListCollection();
        assertEquals("*There are no lists*", list.listNamesToString());
    }

    @Test
    public void testListNamesToString() {
        String expectedStr = "List 1\n";
        expectedStr += "List 2\n";
        expectedStr += "List 3";

        assertEquals(expectedStr, list.listNamesToString());
    }

    @Test
    public void testToShortStringEmptyCollection() {
        ListCollection list = new ListCollection();

        String res = "*There are no lists*";
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        assertEquals(expectedStr, list.toShortString());
    }

    @Test
    public void testToShortString() {
        String res = "List 1\n";
        res += "List 2\n";
        res += "List 3";
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        assertEquals(expectedStr, list.toShortString());
    }

    @Test
    public void testToStringEmptyCollection() {
        ListCollection list = new ListCollection();

        String res = "*There are no lists*";
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        assertEquals(expectedStr, list.toString());
    }

    @Test
    public void testToString() {
        String res = tlists.get(0).toString() + "\n";
        res += tlists.get(1).toString() + "\n";
        res += tlists.get(2).toString();
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        assertEquals(expectedStr, list.toString());
    }

    @Test
    public void testAddList() {
        ListCollection list = new ListCollection();

        TodoList tlist = new TodoList("List 1");
        list.addList(tlist);

        TodoList addedList = list.getList(0);
        assertEquals(tlist, addedList);

        tlist = new TodoList("List 2");
        list.addList(tlist);

        addedList = list.getList(1);
        assertEquals(tlist, addedList);
    }

    @Test
    public void testRemoveListEmptyCollection() {
        ListCollection list = new ListCollection();

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.removeList(0);
        });

        String res = e.getMessage();
        assertTrue(res.contains("Can't remove list: Collection is empty."));
    }

    @Test
    public void testRemoveListOutOfBounds() {
        String res = "";

        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeList(-1);
        });

        res = e.getMessage();
        assertTrue(res.contains("out of bounds"));

        e = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeList(3);
        });

        res = e.getMessage();
        assertTrue(res.contains("out of bounds"));
    }
}
