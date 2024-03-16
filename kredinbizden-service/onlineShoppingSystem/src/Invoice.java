import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Invoice {
    private BigDecimal amount;
    private LocalDateTime invoiceDate;

    public Invoice(BigDecimal amount, Order order, LocalDateTime invoiceDate) {
        this.amount = amount;
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "amount=" + amount +
                ", invoiceDate=" + invoiceDate +
                '}';
    }


}
