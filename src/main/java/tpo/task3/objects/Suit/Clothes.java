package tpo.task3.objects.Suit;

abstract public class Clothes {
    protected String name = "Базовая одёжа";
    public String getName() {
        return name;
    };
    public String doSomething() {
        return "Высморкался";
    };
}
