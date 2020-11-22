package pl.fixit.starogardo.host.food;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fixit.starogardo.host.product.FoodProduct;

public interface FoodProductRepository extends JpaRepository<FoodProduct, Long> {
}
