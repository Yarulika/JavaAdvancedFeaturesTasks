package encapsulation;

public class Dog {
    private String name;
    private int age;
    private String gender;
    private boolean race;
    private int weight;

    public Dog(String name, int age, String gender, boolean race, int weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.weight = weight;
    }

    public Dog(String gender, boolean race) {
        this("Ibizan", 0, gender, race, 0);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if ((age >= 0) && (age < 20)) {
            this.age = age;
        } else {
            System.out.println("Age shall be >=0 and <20");
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if ((weight > 0) && (weight < 100)) {
            this.weight = weight;
        } else {
            System.out.println("Weight shall be >0 and <100");
        }
    }
}
