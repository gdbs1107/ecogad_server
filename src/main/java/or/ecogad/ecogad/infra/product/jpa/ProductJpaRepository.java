package or.ecogad.ecogad.infra.product.jpa;

import or.ecogad.ecogad.domain.product.entity.Product;
import or.ecogad.ecogad.domain.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    boolean existsByCategoryAndName(ProductCategory category, String name);
}
