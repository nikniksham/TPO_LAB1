package task3.participants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tpo.task3.objects.Suit.LabCoat;
import tpo.task3.objects.Suit.Prism;
import tpo.task3.objects.participants.*;
import tpo.task3.objects.profession.Engineer;
import tpo.task3.objects.profession.Scientist;

public class ParticipantsTest {
    Huluwu huluwu;
    Humanoid humanoid;
    Maximegalactic maximegalactic;
    Octopoid octopoid;
    Reptiloid reptiloid;
    Engineer engineer;
    Scientist scientist;
    LabCoat labCoat;
    Prism prism;

    @BeforeEach
    public void createCom() {
        huluwu = new Huluwu();
        humanoid = new Humanoid();
        maximegalactic = new Maximegalactic();
        octopoid = new Octopoid();
        reptiloid = new Reptiloid();
        engineer = new Engineer();
        scientist = new Scientist();
        labCoat = new LabCoat();
        prism = new Prism();
    }

    @Test
    @DisplayName("Проверяем надеваемость ненадеваемого")
    public void test_wrong_dressCode() {
        Assertions.assertEquals(huluwu.addClothes(labCoat), "Хулуву не может надеть Лабораторный халат");
        Assertions.assertEquals(reptiloid.addClothes(prism), "Рептилоид не может надеть Свободно стоящая призма");
    }

    @Test
    @DisplayName("Проверяем корректный дресскод")
    public void test_correct_dressCode() {
        Assertions.assertEquals(huluwu.addClothes(prism), "Хулуву надел Свободно стоящая призма");
        Assertions.assertEquals(reptiloid.addClothes(labCoat), "Рептилоид надел Лабораторный халат");
    }

    @Test
    @DisplayName("Проверяем добавление профессий")
    public void test_add_profession() {
        Assertions.assertEquals(huluwu.getDescription(), "Хулуву, без одежды, безработный");
        Assertions.assertEquals(huluwu.addProfession(engineer), "Хулуву получил новую профессию Инженер");
        Assertions.assertEquals(huluwu.addProfession(scientist), "Хулуву получил новую профессию Учёный");
        Assertions.assertEquals(huluwu.getDescription(), "Хулуву, без одежды, имеет следующие профессии: Инженер, Учёный, ");
    }

    @Test
    @DisplayName("Проверяем добавление одинаковых профессий")
    public void test_add_same_profession() {
        Assertions.assertEquals(huluwu.getDescription(), "Хулуву, без одежды, безработный");
        Assertions.assertEquals(huluwu.addProfession(engineer), "Хулуву получил новую профессию Инженер");
        Assertions.assertEquals(huluwu.addProfession(engineer), "Хулуву уже имеет профессию Инженер");
        Assertions.assertEquals(huluwu.getDescription(), "Хулуву, без одежды, имеет следующие профессии: Инженер, ");
    }

    @Test
    @DisplayName("Проверяем метод описания")
    public void test_description() {
        maximegalactic.addProfession(scientist);
        maximegalactic.addClothes(labCoat);
        maximegalactic.addProfession(engineer);
        Assertions.assertEquals(maximegalactic.getDescription(), "Максимегалактик, одет в Лабораторный халат, имеет следующие профессии: Учёный, Инженер, ");
    }

    @Test
    @DisplayName("Проверяем метод action")
    public void test_action() {
        Assertions.assertEquals("Голышом ничего не выйдет", maximegalactic.action());
        maximegalactic.addClothes(labCoat);
        Assertions.assertEquals("Максимегалактик Почесаться в Лабораторный халат", maximegalactic.action());
        Assertions.assertEquals(huluwu.action(), "Голышом ничего не выйдет");
        huluwu.addClothes(prism);
        Assertions.assertEquals(huluwu.action(), "Хулуву Приломиться в Свободно стоящая призма");
    }
}
