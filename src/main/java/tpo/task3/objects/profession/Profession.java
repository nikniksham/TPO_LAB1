package tpo.task3.objects.profession;

import java.util.Objects;

abstract public class Profession {
    protected String name = "Базовая профессия";
    public String getName() {
        return name;
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Profession that = (Profession) obj;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
