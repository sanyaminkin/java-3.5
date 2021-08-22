package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerNonEmptyTest {
    private ProductManager manager = new ProductManager();
    private Book item1 = new Book(1, 1111, "Дюна", "Френк Герберт");
    private Book item2 = new Book(2, 2222, "Мессия Дюны", "Френк Герберт");
    private Book item3 = new Book(3, 3333, "Дети Дюны", "Френк Герберт");
    private Book item4 = new Book(4, 4444, "Ожерелье планет Эйкумены", "Урсула Ле Гуин");
    private Smartphone item5 = new Smartphone(5, 5555, "Galaxy S20", "Samsung");
    private Smartphone item6 = new Smartphone(6, 6666, "Galaxy S21", "Samsung");
    private Smartphone item7 = new Smartphone(7, 7777, "12 PRO", "iPhone");
    private Product item8 = new Product (8, 8888, "New Product");

    @BeforeEach
    public void setUp() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);
        manager.save(item7);
        manager.save(item8);
    }

    @Test
    public void shouldFindBookByName() {
        Product[] actual = manager.searchBy("Дюна");
        Product[] expected = new Product[]{item1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByAuthor() {
        Product[] actual = manager.searchBy("Урсула Ле Гуин");
        Product[] expected = new Product[]{item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        Product[] actual = manager.searchBy("12 PRO");
        Product[] expected = new Product[]{item7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByManufacturer() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{item5, item6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProductByName() {
        Product[] actual = manager.searchBy("New Product");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

}