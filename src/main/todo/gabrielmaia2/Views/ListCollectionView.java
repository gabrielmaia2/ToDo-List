package main.todo.gabrielmaia2.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.todo.gabrielmaia2.models.ListCollection;
import main.todo.gabrielmaia2.models.TodoList;

public class ListCollectionView {
    ListCollection collection;

    BufferedReader reader;
    String command;

    public ListCollectionView(ListCollection collection) {
        this.collection = collection;
    }

    public void run() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        command = "";

        while (!(command.equals("quit") || command.equals("exit"))) {
            try {
                loop();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void loop() throws IOException {
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("list: View names of all lists");
        System.out.println("view all: View all lists (names and items)");
        System.out.println("add: Add new list");
        System.out.println("remove: Remove list");
        System.out.println("select: Select list to use");
        System.out.println("exit, quit: Go back");

        command = reader.readLine();

        switch (command) {
            case "list":
                list();
                break;
            case "view all":
                viewAll();
                break;
            case "add":
                add();
                break;
            case "remove":
                remove();
                break;
            case "select":
                select();
                break;
            default:
                defa();
                break;
        }
    }

    void list() {
        System.out.println(collection.toShortString());
    }

    void viewAll() {
        System.out.println(collection);
    }

    void add() throws IOException {
        System.out.println("Insert list name to add:");
        String name = reader.readLine();
        collection.addList(new TodoList(name));
        System.out.println("List added!");
    }

    void remove() throws NumberFormatException, IOException {
        System.out.println("Insert list index to remove:");
        int index = Integer.parseInt(reader.readLine());
        collection.removeList(index);
        System.out.println("List removed!");
    }

    void select() throws NumberFormatException, IOException {
        System.out.println("Insert item index to select:");
        int index = Integer.parseInt(reader.readLine());

        TodoList list = collection.getList(index);
        TodoListView listView = new TodoListView(list);
        listView.run();
    }

    void defa() {
        if (!(command.equals("quit") || command.equals("exit")))
            System.out.println("Unknown comamnd: \"" + command + "\", please try again.");
    }
}
