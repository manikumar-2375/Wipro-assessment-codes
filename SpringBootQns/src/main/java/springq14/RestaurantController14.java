package springq14;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController14 {

    private final RestaurantRepository14 restaurantRepo;
    private final FoodRepository14 foodRepo;

    public RestaurantController14(RestaurantRepository14 restaurantRepo, FoodRepository14 foodRepo) {
        this.restaurantRepo = restaurantRepo;
        this.foodRepo = foodRepo;
    }

    // Create restaurant
    @PostMapping
    public Restaurant14 createRestaurant(@Valid @RequestBody Restaurant14 restaurant) {
        return restaurantRepo.save(restaurant);
    }

    // Get all restaurants
    @GetMapping
    public List<Restaurant14> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Restaurant14 getRestaurantById(@PathVariable Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException14("Restaurant", id));
    }

    // Delete restaurant
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        Restaurant14 r = restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException14("Restaurant", id));
        restaurantRepo.delete(r);
    }

    // Add a food item to restaurant
    @PostMapping("/{id}/foods")
    public Food14 addFoodToRestaurant(@PathVariable Long id, @Valid @RequestBody Food14 food) {
        Restaurant14 restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException14("Restaurant", id));
        restaurant.addFood(food);
        restaurantRepo.save(restaurant); // cascade will persist food
        return food;
    }

    // Get foods of a restaurant
    @GetMapping("/{id}/foods")
    public List<Food14> getFoodsByRestaurant(@PathVariable Long id) {
        if (!restaurantRepo.existsById(id)) {
            throw new ResourceNotFoundException14("Restaurant", id);
        }
        return foodRepo.findByRestaurantId(id);
    }
}
