import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private BigDecimal totalAmount;
    private Invoice invoice;
    private Customer customer;
    private LocalDateTime orderDate;
    protected ArrayList productsList;
    private OrderStatus orderStatus;
    private String trackingNumber;


    public Order(BigDecimal totalAmount, Invoice invoice, Customer customer, LocalDateTime orderDate, ArrayList productsList, OrderStatus orderStatus) {
        this.totalAmount = totalAmount;
        this.invoice = invoice;
        this.customer = customer;
        this.orderDate = orderDate;
        this.productsList = productsList;
        this.orderStatus = orderStatus;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
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




}
