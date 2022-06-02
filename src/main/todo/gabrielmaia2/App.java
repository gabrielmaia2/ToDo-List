package main.todo.gabrielmaia2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    BufferedReader reader;
    String command;
    TodoList list;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    void run() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        command = "";

        list = new TodoList();

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
        System.out.println("list: List items");
        System.out.println("add: Add item");
        System.out.println("remove: Remove item");
        System.out.println("edit: Edit item");
        System.out.println("check: Toggle item checked state");

        command = reader.readLine();

        switch (command) {
            case "list":
                list();
                break;
            case "add":
                add();
                break;
            case "remove":
                remove();
                break;
            case "edit":
                edit();
                break;
            case "check":
                check();
                break;
            default:
                defa();
                break;
        }
    }

    void list() {
        System.out.println("*Items*");
        System.out.println(list.getItems());
        System.out.println("*End*");
    }

    void add() throws IOException {
        System.out.println("Insert item to add:");
        String item = reader.readLine();
        list.add(item);
        System.out.println("Item added!");
    }

    void remove() throws NumberFormatException, IOException {
        System.out.println("Insert item position to remove:");
        int index = Integer.parseInt(reader.readLine());
        list.remove(index);
        System.out.println("Item removed!");
    }

    void edit() throws NumberFormatException, IOException {
        System.out.println("Insert item position to edit:");
        int index = Integer.parseInt(reader.readLine());
        System.out.println("Now insert new item value:");
        String item = reader.readLine();
        list.edit(index, item);
        System.out.println("Item edited!");
    }

    void check() throws NumberFormatException, IOException {
        System.out.println("Insert item position to check:");
        int index = Integer.parseInt(reader.readLine());
        list.check(index);
        System.out.println("Item checked!");
    }

    void defa() {
        if (!(command.equals("quit") || command.equals("exit")))
            System.out.println("Unknown comamnd: \"" + command + "\", please try again.");
    }
}
