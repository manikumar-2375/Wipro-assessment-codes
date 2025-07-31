package jdbc;

public class Customer {
    private Long id;
    private String name;
    private int tier;

    public Customer(Long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getTier() { return tier; }

    public String toString() {
        return name + " (Tier " + tier + ")";
    }
}
