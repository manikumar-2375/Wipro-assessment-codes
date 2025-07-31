package jdbc;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamDemo {
    public static void main(String[] args) {
        // Sample Products
        Product p1 = new Product(1L, "Java Book", "Books", 150.0);
        Product p2 = new Product(2L, "Baby Shampoo", "Baby", 80.0);
        Product p3 = new Product(3L, "Toy Car", "Toys", 200.0);
        Product p4 = new Product(4L, "Notebook", "Books", 50.0);
        Product p5 = new Product(5L, "Teddy Bear", "Toys", 300.0);

        // Sample Customers
        Customer c1 = new Customer(1L, "Anil", 1);
        Customer c2 = new Customer(2L, "Bharath", 2);

        // Sample Orders
        List<Order> orders = Arrays.asList(
            new Order(101L, "Delivered", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), Arrays.asList(p1, p2), c2),
            new Order(102L, "Shipped", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 10), Arrays.asList(p3), c2),
            new Order(103L, "Delivered", LocalDate.of(2021, 1, 25), LocalDate.of(2021, 1, 30), Arrays.asList(p4, p5), c1),
            new Order(104L, "Delivered", LocalDate.of(2021, 2, 28), LocalDate.of(2021, 3, 3), Arrays.asList(p1, p5), c2)
        );

        // 1. Products in category "Books" with price > 100
        System.out.println("1. Books > 100:");
        orders.stream()
            .flatMap(o -> o.getProducts().stream())
            .filter(p -> p.getCategory().equalsIgnoreCase("Books") && p.getPrice() > 100)
            .distinct()
            .forEach(System.out::println);

        // 2. Orders with products in "Baby" category
        System.out.println("\n2. Orders with Baby products:");
        orders.stream()
            .filter(o -> o.getProducts().stream()
                         .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
            .forEach(System.out::println);

        // 3. Products in "Toys" category with 10% discount
        System.out.println("\n3. Toys with 10% discount:");
        orders.stream()
            .flatMap(o -> o.getProducts().stream())
            .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
            .map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9))
            .distinct()
            .forEach(System.out::println);

        // 4. Products ordered by tier 2 customers between 01-Feb-2021 and 01-Apr-2021
        System.out.println("\n4. Tier 2 customer products between Feb and Apr:");
        orders.stream()
            .filter(o -> o.getCustomer().getTier() == 2)
            .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)) &&
                         o.getOrderDate().isBefore(LocalDate.of(2021, 4, 2)))
            .flatMap(o -> o.getProducts().stream())
            .distinct()
            .forEach(System.out::println);

        // 5. Cheapest product in "Books" category
        System.out.println("\n5. Cheapest Book:");
        orders.stream()
            .flatMap(o -> o.getProducts().stream())
            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
            .sorted(Comparator.comparing(Product::getPrice))
            .findFirst()
            .ifPresent(System.out::println);

        // 6. 3 Most recent orders
        System.out.println("\n6. 3 Most Recent Orders:");
        orders.stream()
            .sorted(Comparator.comparing(Order::getOrderDate).reversed())
            .limit(3)
            .forEach(System.out::println);

        // 7. Total sum of orders placed in Feb 2021
        System.out.println("\n7. Total order sum in Feb 2021:");
        Double febTotal = orders.stream()
            .filter(o -> o.getOrderDate().getMonthValue() == 2 && o.getOrderDate().getYear() == 2021)
            .flatMap(o -> o.getProducts().stream())
            .mapToDouble(Product::getPrice)
            .sum();
        System.out.println("Total: ₹" + febTotal);

        // 8. Statistics for Books category
        System.out.println("\n8. Book Category Statistics:");
        DoubleSummaryStatistics stats = orders.stream()
            .flatMap(o -> o.getProducts().stream())
            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
            .mapToDouble(Product::getPrice)
            .summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: ₹" + stats.getSum());
        System.out.println("Min: ₹" + stats.getMin());
        System.out.println("Max: ₹" + stats.getMax());
        System.out.println("Avg: ₹" + stats.getAverage());

        // 9. Most expensive product by category
        System.out.println("\n9. Most expensive product by category:");
        orders.stream()
            .flatMap(o -> o.getProducts().stream())
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                    Optional::get)))
            .forEach((cat, prod) -> System.out.println(cat + " => " + prod));
    }
}
