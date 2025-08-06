package springq14;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository14 extends JpaRepository<Food14, Long> {
    List<Food14> findByRestaurantId(Long restaurantId);
}
