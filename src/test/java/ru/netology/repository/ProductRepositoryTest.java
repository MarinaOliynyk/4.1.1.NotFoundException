package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Product first = new Book(1, "Java. Полное руководство", 2670, "Шилдт Герберт", 1488, 2019);
  private Product second = new Book(2, "Программирование на Java для начинающих", 596, "Васильев Алексей Николаевич", 704, 2020);
  private Product third = new Book(3, "Java. Руководство для начинающих", 1800, "Шилдт Герберт", 816, 2018);
  private Product fourth = new TShirt(4, "Рубашка приталенная", 3800, "blue", "L");


  @BeforeEach
  void setUp() {
    repository.save(first);
    repository.save(second);
    repository.save(third);
    repository.save(fourth);
  }

  @Test
  public void removeById() {
    repository.removeById(2);

    Product[] actual = repository.findAll();
    Product[] expected = new Product[]{first, third, fourth};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void removeByIdNonExistent() {
    assertThrows(NotFoundException.class, ()->repository.removeById(5));
  }
}
