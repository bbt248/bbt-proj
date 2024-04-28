import java.util.Arrays;

public class PersonsList {

    private Person[] people = new Person[5];
    private int size = 0;

    public void add(Person person) {
        if (person == null) {
            System.err.println("Person is not initialized");
            return;
        }

        if (size == people.length) {
            Person[] newArray = Arrays.copyOf(people, people.length + 5);
            people = newArray;
        }

        people[size] = person;
        size++;
    }

    public void remove(int index) {
        if (checkArrayBounds(index)) {
            System.err.println("Array index out of bounds exception");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            people[i] = people[i + 1];
        }

        size--;
    }

    public void setPerson(int index, Person person) {
        if (checkArrayBounds(index) || person == null) {
            System.err.println("Array index out of bounds exception or person wasn't initialized");
            return;
        }
        people[index] = person;
    }

    public Person getPerson(int index) {
        if (checkArrayBounds(index)) {
            System.err.println("Array index out of bounds exception");
            return null;
        }
        return people[index];
    }

    private boolean checkArrayBounds(int index) {
        return index >= size || index < 0;
    }

    public void printArray() {
        System.out.println(Arrays.toString(Arrays.copyOf(people, size)));
    }
}

