package main.todo.gabrielmaia2;

import main.todo.gabrielmaia2.models.ListCollection;
import main.todo.gabrielmaia2.views.ListCollectionView;

public class App {
    public static void main(String[] args) {
        ListCollection collection = new ListCollection();
        ListCollectionView view = new ListCollectionView(collection);
        view.run();
    }
}
