import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    static List<Order> orderList = new ArrayList<>();
    private BigDecimal totalAmount;
    private Invoice invoice;
    private Customer customer;
    private LocalDateTime orderDate;
    protected ArrayList productsList;
    private OrderStatus orderStatus;
    private String trackingNumber;


    public Order(Customer customer, LocalDateTime orderDate, ArrayList<Product> productsList) {

        this.customer = customer;
        this.orderDate = orderDate;
        this.productsList = productsList;
        this.orderStatus = OrderStatus.DRAFT;

        double totalPrice = 0.0;
        for (Product product : productsList) {
            totalPrice += product.getPrice() ;
        }
        this.totalAmount = BigDecimal.valueOf(totalPrice);

        orderList.add(this);

    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList productsList) {
        this.productsList = productsList;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "totalAmount=" + totalAmount +
                ", invoice=" + invoice +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", productsList=" + productsList +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public static double totalProductNumberbyName(String calledName) {
        double totalSum = 0.0;
        for (Order order : orderList) {
            if (order.customer.getName() == calledName) {
                for (Product product : order.getProductsList()) {
                    totalSum += 1; // Assuming Product has a getPrice() method
                }
            }
        }
        return totalSum;
    }

    public static BigDecimal calculateTotalAmount(String searchedName) {
        return orderList.stream()
                .filter(order -> order.customer.getName() == searchedName && order.customer.getAge() < 30 && order.customer.getAge() > 25)
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }



}
