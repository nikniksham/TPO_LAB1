package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tpo.task3.objects.Committee;
import tpo.task3.objects.Suit.LabCoat;
import tpo.task3.objects.Suit.Prism;
import tpo.task3.objects.participants.*;
import tpo.task3.objects.profession.Engineer;
import tpo.task3.objects.profession.Scientist;

public class CommitteeTest {
    Huluwu huluwu;
    Humanoid humanoid;
    Maximegalactic maximegalactic;
    Octopoid octopoid;
    Reptiloid reptiloid;
    Engineer engineer;
    Scientist scientist;
    LabCoat labCoat;
    Prism prism;
    Committee committee;

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
        committee = new Committee();
    }
    @Test
    @DisplayName("Проверяем добавление сущностей в комитет")
    public void test_add_creature() {
        Assertions.assertEquals(committee.addNewCreature(octopoid), "Новый участник Октопоид добавлен в группу", "Участник не добавился");
        Assertions.assertEquals(committee.addNewCreature(huluwu), "Новый участник Хулуву добавлен в группу", "Участник не добавился");
    }

    @Test
    @DisplayName("Проверяем недоступность добавления одного участника в комиссию дважды")
    public void test_cant_add_same_creature() {
        committee.addNewCreature(humanoid);
        Assertions.assertEquals(committee.addNewCreature(humanoid), "Он уже в комиссии", "Один и тот же участник дважды попал в комиссию");
    }

    @Test
    @DisplayName("Проверяем описание пустой комиссии")
    public void test_empty_describe() {
        Assertions.assertEquals(committee.describe(), "В комиссии никого нет", "Описание не соответсвует действительности");
    }

    @Test
    @DisplayName("Проверяем метод description")
    public void test_fill_description() {
        humanoid.addClothes(labCoat);
        humanoid.addProfession(engineer);
        maximegalactic.addProfession(scientist);
        reptiloid.addClothes(labCoat);
        reptiloid.addProfession(scientist);
        reptiloid.addProfession(engineer);

        committee.addNewCreature(humanoid);
        committee.addNewCreature(maximegalactic);
        committee.addNewCreature(reptiloid);

        Assertions.assertEquals("Описание комиссии:\n" +
                "Гуманоид, одет в Лабораторный халат, имеет следующие профессии: Инженер, \n" +
                "Максимегалактик, без одежды, имеет следующие профессии: Учёный, \n" +
                "Рептилоид, одет в Лабораторный халат, имеет следующие профессии: Учёный, Инженер, \n", committee.describe(), "Описание комиссии работает неправильно!");
    }
}
