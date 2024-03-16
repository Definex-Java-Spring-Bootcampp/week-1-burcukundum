import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    private String name;
    private String surname;
    private List<Order> orderList;
    private int age;
    private String email;
    private String phoneNumber;

    public Customer(String name, String surname, List<Order> orderList, int age, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.orderList = orderList;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String surname, List<Order> orderList) {
        this.name = name;
        this.surname = surname;
        this.orderList = orderList;
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", orderList=" + orderList +
                '}';
    }

    public static int totalCustomerNumber(List<Customer> customerList) {
        if (customerList == null) {
            return 0;
        }
        return customerList.size();
    }

    public void addOrder(Order order){
        orderList.add(order);
    }

    public static long totalProductNumberbyName(List<Customer> customerList, String calledName) {
        return customerList.stream()
                .filter(customer -> customer.name.equals(calledName))
                .flatMap(customer -> customer.orderList.stream())
                .mapToLong(order -> order.productsList.size())
                .sum();
    }

    public static BigDecimal calculateTotalAmount(List<Customer> customerList, String searchedName) {
        return customerList.stream()
                .filter(customer -> customer.name.equals(searchedName) && customer.age < 30 && customer.age > 25)
                .flatMap(customer -> customer.orderList.stream())
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Invoice> getHighValueInvoices(BigDecimal thresholdAmount) {
        return orderList.stream()
                .filter(order -> order.getInvoice().getAmount().compareTo(thresholdAmount) > 0)
                .map(order -> order.getInvoice())
                .collect(Collectors.toList());
    }


}
