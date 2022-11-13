import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    @Test
    public void testNotFoundException() {
        Book book1 = new Book(3, "The Lake", 200, "Edward");
        Book book2 = new Book(89, "Sunny", 170, "Anna Evans");
        Book book3 = new Book(34, "The Mirror House", 300, "Ludwig");

        Repository repo = new Repository();
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.removeById(6);
        });
    }

    @Test
    public void testRemoveById() {
        Book book1 = new Book(3, "The Lake", 200, "Edward");
        Book book2 = new Book(89, "Sunny", 170, "Anna Evans");
        Book book3 = new Book(34, "The Mirror House", 300, "Ludwig");

        Repository repo = new Repository();
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        repo.removeById(book2.getId());
        Product[] expected = {book1, book3};
        Product[] actual = repo.findAll();
    }
}