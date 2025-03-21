import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tpo.MyHashTable;

import java.util.List;

public class HashTableTest {
    private MyHashTable table;

    @BeforeEach
    public void createTable() {
        table = new MyHashTable();
    }

    @Test
    @DisplayName("Проверка вставки элемента")
    public void check_add_elem() {
        Integer elem = 123;
        table.addElem(elem);
        Assertions.assertEquals(1, table.getCountOfElems(), "Длина после вставки должна быть равна 1");
        Assertions.assertTrue(table.findElem(elem), "Таблица не содержит вставленного элемента");
    }

    @Test
    @DisplayName("Проверка нахождения количества элементов")
    public void check_table_size() {
        Integer[] elems = {1, 4, 2, 4, 5, 1, 241, 612, 123, 123, 1, 61, 23, 163, 162, 6, 12, 61, 16, 162, 126, 61, 27, 325, 123, 2};
        for (Integer elem : elems) {
            table.addElem(elem);
        }
        Assertions.assertEquals(elems.length, table.getCountOfElems(), "Длина таблицы не соответсвует количеству добавленных элементов");
    }

    @Test
    @DisplayName("Проверка поиска элемента")
    public void check_find_elem() {
        Integer[] elems = {1, 4, 2, 4, 5, 1, 241, 612, 123, 123, 1, 61, 23, 163, 162, 6, 12, 61, 16, 162, 126, 61, 27, 325, 123, 2};
        for (Integer elem : elems) {
            table.addElem(elem);
        }

        Assertions.assertTrue(table.findElem(2), "Таблица не может найти добавленный в неё элемент");
        Assertions.assertFalse(table.findElem(3), "В таблице найден несуществующий элемент");
    }

    @Test
    @DisplayName("Проверка удаления элемента")
    public void check_delete_elem() {
        Integer elem = 123;
        table.addElem(elem);
        table.deleteElem(elem);
        Assertions.assertEquals(0, table.getCountOfElems(), "Элемент не удалился");
    }

    @Test
    @DisplayName("Проверка содержимого корзин")
    public void check_basket_content() {
        Integer[] elems = {1, 4, 2, 4, 5, 1, 241, 612, 123, 123, 1, 61, 23, 163, 162, 6, 12, 61, 16, 162, 126, 61, 27, 325, 123, 2};
        for (Integer elem : elems) {
            table.addElem(elem);
        }
        for (int i = 0; i < 13; i++) {
            List<Integer> basket = table.getBasketContent(i);
            for (Integer elem : elems) {
                if (elem % 13 == i) {
                    Assertions.assertTrue(basket.remove(elem), "Неправильное содержание корзин под индексом: " + i);
                }
            }
            Assertions.assertEquals(basket.size(), 0, "Количество элементов в корзине неправильное!");
        }
    }
}
