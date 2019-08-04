import encapsulation.Dog;

public class Main {

    public static void main(String[] args) {
        Dog labrador = new Dog("Elvis", 4, "mail", false, 28);
        Dog puppy = new Dog("femail", false);

        System.out.println(labrador.getAge());
        System.out.println(labrador.getWeight());
        System.out.println(puppy.getAge());
        System.out.println(puppy.getWeight());
    }
}
