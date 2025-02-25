import java.util.*;

class Product {
    String name;
    String category;
    double price;
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductSales {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product A", "Electronics", 199.99));
        products.add(new Product("Product B", "Electronics", 299.99));
        products.add(new Product("Product C", "Furniture", 499.99));
        products.add(new Product("Product D", "Furniture", 129.99));
        products.add(new Product("Product E", "Electronics", 89.99));
        products.add(new Product("Product F", "Clothing", 49.99));
        products.add(new Product("Product G", "Clothing", 79.99));
        products.add(new Product("Product H", "Clothing", 129.99));

        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        mostExpensiveByCategory.forEach((category, productOpt) -> {
            productOpt.ifPresent(product -> System.out.println(category + ": " + product));
        });
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
