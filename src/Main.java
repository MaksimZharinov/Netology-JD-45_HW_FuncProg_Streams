import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> doThis = new ArrayList<>(intList);
        for (Iterator<Integer> it = doThis.iterator(); it.hasNext(); ) {
            int tmp = it.next();
            if (tmp <= 0 || tmp % 2 != 0) {
                it.remove();
            }
        }
        Collections.sort(doThis);
        System.out.println(doThis);

        StreamMain task1v2 = new StreamMain();
        task1v2.main();

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        int countYong = (int) persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + countYong);

        List<String> goArmy = persons.stream()
                .filter(person -> person.getSex().toString() == "MAN")
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() <= 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println("Подлежат призыву: " + goArmy);

        List<Person> goWork = persons.stream()
                .filter(person -> {
                    if (person.getSex().toString() == "MAN") {
                        return person.getAge() <= 65 && person.getAge() >= 18;
                    } else return person.getAge() <= 60 && person.getAge() >= 18;
                })
                .filter(person -> person.getEducation().toString() == "HIGHER")
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .collect(Collectors.toList());
        System.out.println("Работоспособное население: " + goWork);
    }
}
