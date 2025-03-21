package tpo.task3.objects;

import tpo.task3.objects.participants.Creature;

import java.util.ArrayList;
import java.util.List;

public class Committee {
    private List<Creature> creatures = new ArrayList<>();

    public String addNewCreature(Creature creature) {
        if (creatures.contains(creature)) {
            return "Он уже в комиссии";
        }
        creatures.add(creature);
        return "Новый участник " + creature.getName() + " добавлен в группу";
    }

    public String describe() {
        if (creatures.size() == 0) {
            return "В комиссии никого нет";
        }
        String result = "Описание комиссии:\n";
        for (Creature creature : creatures) {
            result += creature.getDescription() + "\n";
        }
        return result;
    }

    public void stayAndStare() {
        List<Creature> creatures_copy = creatures.stream().toList();
        for (Creature creature : creatures_copy) {
            if (creature.stayOnSun()) {
                System.out.println(creature.getName() + " перегрелся на солнце и пошёл домой");
                creatures.remove(creature);
            }
        }
    }
}
