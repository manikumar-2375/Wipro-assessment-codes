package springq14;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants/foods")
public class FoodController14 {

    private final FoodRepository14 foodRepo;

    public FoodController14(FoodRepository14 foodRepo) {
        this.foodRepo = foodRepo;
    }

    // Delete a food item
    @DeleteMapping("/{foodId}")
    public void deleteFood(@PathVariable Long foodId) {
        Food14 f = foodRepo.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException14("Food", foodId));
        foodRepo.delete(f);
    }
}
