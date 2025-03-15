package task3.suit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tpo.task3.objects.Suit.LabCoat;
import tpo.task3.objects.Suit.Prism;

public class SuitTest {
    LabCoat labCoat;
    Prism prism;
    @BeforeEach
    public void before() {
        prism = new Prism();
        labCoat = new LabCoat();
    }

    @Test
    @DisplayName("Проверяем имя одежды")
    public void test_name() {
        Assertions.assertEquals(prism.getName(), "Свободно стоящая призма", "Имя призмы неправильное");
        Assertions.assertEquals(labCoat.getName(), "Лабораторный халат", "Имя халата неправильное");
    }

    @Test
    @DisplayName("Проверяем действие")
    public void test_doSomething() {
        Assertions.assertEquals(prism.doSomething(), "Приломиться", "Действие призмы неправильное");
        Assertions.assertEquals(labCoat.doSomething(), "Почесаться", "Действие халата неправильное");
    }
}
