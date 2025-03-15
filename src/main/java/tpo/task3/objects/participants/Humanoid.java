package tpo.task3.objects.participants;

import tpo.task3.objects.Suit.Clothes;
import tpo.task3.objects.Suit.LabCoat;

public class Humanoid extends Creature {
    protected String name = "Гуманоид";
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String addClothes(Clothes clothes) {
        if (!clothes.getClass().equals(LabCoat.class)) {
            return getName() + " не может надеть " + clothes.getName();
        }
        this.clothes = clothes;
        return getName() + " надел " + clothes.getName();
    }
}
