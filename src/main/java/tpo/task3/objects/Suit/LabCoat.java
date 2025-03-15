package tpo.task3.objects.Suit;

public class LabCoat extends Clothes {
    protected String name = "Лабораторный халат";
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String doSomething() {
        return "Почесаться";
    }
}
