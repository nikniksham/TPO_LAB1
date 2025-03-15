package tpo.task3.objects.participants;
import tpo.task3.objects.Suit.Clothes;
import tpo.task3.objects.Suit.Prism;

public class Huluwu extends Creature {
    protected String name = "Хулуву";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String addClothes(Clothes clothes) {
        if (!clothes.getClass().equals(Prism.class)) {
            return getName() + " не может надеть " + clothes.getName();
        }
        this.clothes = clothes;
        return getName() + " надел " + clothes.getName();
    }
}
