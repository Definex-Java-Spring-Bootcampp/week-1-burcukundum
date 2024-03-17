import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Zeki","Müren");
        System.out.println(customer1);

        Product product1 = new Product("Microphone", 15000.0, CategoryType.ELECTRONICS, 15);
        Product product2 = new Product("Television", 20000.0, CategoryType.ELECTRONICS, 15);

        ArrayList<Product> orderProductList = new ArrayList<>();
        orderProductList.add(product1);
        orderProductList.add(product2);
        Order order1 = new Order(customer1, LocalDateTime.now(), orderProductList);
        System.out.println(order1);

        Invoice invoice1 = new Invoice(order1, LocalDateTime.now());
        System.out.println(invoice1);

        // Methods Testleri

        // Bir müşteri birden fazla sipraiş verebilir
        System.out.println(" ");
        System.out.println("Bir müşteri birden fazla sipraiş verebilir");
        ArrayList<Product> orderProductList2 = new ArrayList<>();
        orderProductList2.add(product1);
        Order order2 = new Order(customer1, LocalDateTime.now(), orderProductList2);
        System.out.println(order2);

        // Bir sipariş içinde birden fazla ürün olabilir
        System.out.println(" ");
        System.out.println("Bir siparis icinde birden fazla urun olabilir");
        System.out.println(order1);

        // Ürünün kategorisi ismi ve stok bilgisi vardır.
        System.out.println(" ");
        System.out.println("Urunun kategorisi ismi ve stok bilgisi vardir.");
        System.out.println(product2);

        // Bir siparişin bir faturası vardır.
        System.out.println(" ");
        System.out.println("Bir siparisin bir faturasi vardir.");
        Invoice invoice2 = new Invoice(order1, LocalDateTime.now());

        // İstenilen Fonksiyonlar
        // Sistemdeki bütün müşteri sayısısı bulan method
        System.out.println(" ");
        System.out.println("Sistemdeki bütün müşteri sayısısı bulan method.");
        System.out.println(Customer.totalCustomerNumber());

        // Spesifik isimli müşterilerin aldıkları ürün sayısı
        System.out.println(" ");
        System.out.println("Spesifik  isimli musterilerin aldiklari urun sayisi");
        System.out.println(Order.totalProductNumberbyName("Zeki"));

        // Spesifik isimli 30 yaşından küçük 25'den büyük müşterilerin toplam alışveriş tutarı
        System.out.println(" ");
        System.out.println("Spesifik isimli 30 yasindan kucuk 25'den buyuk musterilerin toplam alisveris tutari");

        Customer customer2 = new Customer("Bülent","Ersoy" ,26);
        Order order3 = new Order(customer2, LocalDateTime.now(), orderProductList);
        System.out.println(Order.calculateTotalAmount("Bülent"));

        // Sistemdeki 1500 tl üzeri faturalrı listeleyin.
        System.out.println(" ");
        System.out.println("Sistemdeki 1500 tl uzeri faturalri listeleyin");

        System.out.println(Invoice.getHighValueInvoices(BigDecimal.valueOf(1500)));
    }
}