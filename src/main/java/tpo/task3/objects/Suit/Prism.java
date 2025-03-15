package tpo.task3.objects.Suit;

public class Prism extends Clothes {
    protected String name = "Свободно стоящая призма";
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String doSomething() {
        return "Приломиться";
    }
}
