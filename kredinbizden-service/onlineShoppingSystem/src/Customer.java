import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Customer {

    static Set<Customer> customerList = new HashSet<>();
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phoneNumber;

    public Customer(String name, String surname, int age, String email, String phoneNumber) {

        Try:
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.email = email;
            this.phoneNumber = phoneNumber;
            customerList.add(this);
        Exception:
            System.out.println("This customer has already been created.");
    }

    public Customer(String name, String surname) {
        Try:
            this.name = name;
            this.surname = surname;
            customerList.add(this);
        Exception:
            System.out.println("This customer has already been created.");
    }

    public Customer(String name, String surname, int age) {
        Try:
        this.name = name;
        this.surname = surname;
        this.age = age;
        customerList.add(this);
        Exception:
        System.out.println("This customer has already been created.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static int totalCustomerNumber() {
        if (customerList == null) {
            return 0;
        }
        return customerList.size();
    }

}
