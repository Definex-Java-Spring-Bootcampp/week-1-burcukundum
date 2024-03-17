public class Product {
    private String name;
    private Double price;
    private CategoryType category;
    private Integer stockQuantity;

    public Product(String name, Double price, CategoryType category, Integer stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", stock=" + stockQuantity +
                '}';
    }
}
