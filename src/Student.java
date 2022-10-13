final public class Student {
    final private String name;
    final private String surname;
    final private int birthYear;

    public Student(String name, String surname, int birthYear)
    {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public int birthYear() {
        return birthYear;
    }
}
