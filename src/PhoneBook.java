import java.util.*;
public class PhoneBook {
    public static void main(String[] args) {

//        Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что в во входной структуре будут повторяющиеся
//        имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Jason Stathem", "+7 913 031 58 44");
        phoneBook.addContact("Jason Stathem", "+7 913 031 58 23");
        phoneBook.addContact("Some Foo", "+7 913 128 58 78");
        phoneBook.addContact("Jimi Hendryx", "+7 913 012 64 89");
        phoneBook.addContact("Jason Stathem", "+7 913 031 58 47");
        phoneBook.addContact("Justin Bluebear", "+7 913 123 45 68");
        phoneBook.addContact("Justin Bluebear", "+7 913 123 45 67");
        phoneBook.printSortedContacts();
    }

    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        if (contacts.containsKey(name)) {
            List<String> phones = contacts.get(name);
            if (!phones.contains(phone)) {
                phones.add(phone);
            }
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            contacts.put(name, phones);
        }
    }

    public void printSortedContacts() {
        contacts.entrySet().stream()
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEachOrdered(System.out::println);
    }
}