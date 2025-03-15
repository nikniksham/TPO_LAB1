package tpo.task3.objects.participants;

import tpo.task3.objects.Suit.Clothes;
import tpo.task3.objects.Suit.Prism;
import tpo.task3.objects.profession.Profession;

import java.util.ArrayList;
import java.util.List;

abstract public class Creature {
    protected String name = "Существо";
    protected List<Profession> professions = new ArrayList<>();
    protected Clothes clothes = null;

    public String getName() {
        return name;
    }

    public String addClothes(Clothes clothes) {
        this.clothes = clothes;
        return getName() + " надел " + clothes.getName();
    }

    public String getDescription() {
        String result = getName();
        if (clothes == null) {
            result += ", без одежды";
        } else {
            result += ", одет в " + clothes.getName();
        }
        if (professions.size() == 0) {
            result += ", безработный";
        } else {
            result += ", имеет следующие профессии: ";
            for (Profession prof : professions) {
                result += prof.getName() + ", ";
            }
        }
        return result;
    }

    public String addProfession(Profession profession) {
        if (professions.contains(profession)) {
            return getName() + " уже имеет профессию " + profession.getName();
        }
        professions.add(profession);
        return getName() + " получил новую профессию " + profession.getName();
    }

    public String action() {
        if (clothes != null) {
            return getName() + " " + clothes.doSomething() + " в " + clothes.getName();
        }
        return "Голышом ничего не выйдет";
    }
}
