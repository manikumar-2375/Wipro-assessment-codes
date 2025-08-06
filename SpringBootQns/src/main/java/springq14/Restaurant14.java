package springq14;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant14 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Restaurant name must not be blank")
    private String name;

    @NotBlank(message = "Location must not be blank")
    private String location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Food14> foods = new ArrayList<>();

    public Restaurant14() {}

    public Restaurant14(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // getters / setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Food14> getFoods() { return foods; }
    public void setFoods(List<Food14> foods) { this.foods = foods; }

    public void addFood(Food14 food) {
        foods.add(food);
        food.setRestaurant(this);
    }

    public void removeFood(Food14 food) {
        foods.remove(food);
        food.setRestaurant(null);
    }
}
