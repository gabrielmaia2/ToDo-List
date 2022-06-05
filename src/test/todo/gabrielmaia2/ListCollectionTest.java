package test.todo.gabrielmaia2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import main.todo.gabrielmaia2.*;

import org.junit.Test;

public class ListCollectionTest {
    @Test
    public void testGetListEmptyCollection() {
        ListCollection list = new ListCollection();

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.getList(0);
        });

        String res = e.getMessage();

        String expectedStr = "Can't get list: Collection is empty.";

        assertTrue(res.contains(expectedStr));
    }

    @Test
    public void testGetListOutOfBounds() {
        ArrayList<TodoList> arrList = new ArrayList<>();
        arrList.add(new TodoList());
        arrList.add(new TodoList());
        arrList.add(new TodoList());
        ListCollection list = new ListCollection(arrList);

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
        TodoList expectedList = new TodoList("List 2");
        ArrayList<TodoList> arrList = new ArrayList<>();
        arrList.add(new TodoList("List 1"));
        arrList.add(expectedList);
        arrList.add(new TodoList("List 3"));
        ListCollection list = new ListCollection(arrList);

        TodoList str = list.getList(1);

        assertEquals(expectedList, str);
    }

    @Test
    public void testGetListsEmptyCollection() {
        ListCollection list = new ListCollection();

        String expectedStr = "*There are no lists*";

        String str = list.getLists();

        assertEquals(expectedStr, str);
    }

    @Test
    public void testGetLists() {
        ArrayList<TodoList> arrList = new ArrayList<>();
        arrList.add(new TodoList("List 1"));
        arrList.add(new TodoList("List 2"));
        arrList.add(new TodoList("List 3"));
        ListCollection list = new ListCollection(arrList);

        String expectedStr = "List 1\n";
        expectedStr += "List 2\n";
        expectedStr += "List 3";

        String str = list.getLists();

        assertEquals(expectedStr, str);
    }

    @Test
    public void testToShortStringEmptyCollection() {
        ListCollection list = new ListCollection();

        String res = "*There are no lists*";
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        String str = list.toShortString();

        assertEquals(expectedStr, str);
    }

    @Test
    public void testToShortString() {
        ArrayList<TodoList> arrList = new ArrayList<>();
        arrList.add(new TodoList("List 1"));
        arrList.add(new TodoList("List 2"));
        ListCollection list = new ListCollection(arrList);

        String res = "List 1\n";
        res += "List 2";
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        String str = list.toShortString();

        assertEquals(expectedStr, str);
    }

    @Test
    public void testToStringEmptyCollection() {
        ListCollection list = new ListCollection();

        String res = "*There are no lists*";
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        String str = list.toString();

        assertEquals(expectedStr, str);
    }

    @Test
    public void testToString() {
        TodoList list1 = new TodoList("List 1");
        TodoList list2 = new TodoList("List 2");
        ArrayList<TodoList> arrList = new ArrayList<>();
        arrList.add(list1);
        arrList.add(list2);
        ListCollection list = new ListCollection(arrList);

        String res = list1.toString() + "\n";
        res += list2.toString();
        String expectedStr = "*Lists*\n";
        expectedStr += Util.tabString(res);
        expectedStr += "\n*End*";

        String str = list.toString();

        assertEquals(expectedStr, str);
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

        String res = "";

        Exception e = assertThrows(IllegalStateException.class, () -> {
            list.removeList(0);
        });

        res = e.getMessage();

        String expectedStr = "Can't remove list: Collection is empty.";

        assertTrue(res.contains(expectedStr));
    }

    @Test
    public void testRemoveListOutOfBounds() {
        ArrayList<TodoList> arrList = new ArrayList<>();
        arrList.add(new TodoList("List 1"));
        arrList.add(new TodoList("List 2"));
        arrList.add(new TodoList("List 3"));
        ListCollection list = new ListCollection(arrList);

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
