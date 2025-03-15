package task3.profession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tpo.task3.objects.profession.Engineer;
import tpo.task3.objects.profession.Scientist;

public class ProfessionTest {
    Engineer engineer;
    Scientist scientist;
    @BeforeEach
    public void before() {
        engineer = new Engineer();
        scientist = new Scientist();
    }

    @Test
    @DisplayName("Проверяем название профессии")
    public void test_name() {
        Assertions.assertEquals(engineer.getName(), "Инженер", "Название инженера слетело");
        Assertions.assertEquals(scientist.getName(), "Учёный", "Название учёного слетело");
    }

    @Test
    @DisplayName("Проверяем одинаковость разных объектов")
    public void test_doSomething() {
        Assertions.assertEquals(engineer, new Engineer());
        Assertions.assertEquals(new Scientist(), new Scientist());
        Assertions.assertFalse(engineer.equals(scientist));
        Assertions.assertEquals(scientist, scientist);
    }
}
