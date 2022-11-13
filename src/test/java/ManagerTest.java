import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testForTwo() {
        Book book1 = new Book(3, "The Lake", 200, "Edward");
        Book book2 = new Book(89, "Sunny", 170, "Anna Evans");
        Book book3 = new Book(34, "The Mirror House", 300, "Ludwig");

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("The");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testForOne() {
        Book book1 = new Book(3, "The Lake", 200, "Edward");
        Book book2 = new Book(89, "Sunny", 170, "Anna Evans");
        Book book3 = new Book(34, "The Mirror House", 300, "Ludwig");

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Sunny");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testForNull() {
        Book book1 = new Book(3, "The Lake", 200, "Edward");
        Book book2 = new Book(89, "Sunny", 170, "Anna Evans");
        Book book3 = new Book(34, "The Mirror House", 300, "Ludwig");

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Product[] actual = manager.searchBy("Sunny");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}