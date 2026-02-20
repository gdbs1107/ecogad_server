package or.ecogad.ecogad.domain.product.repository;

import or.ecogad.ecogad.domain.product.entity.Product;
import or.ecogad.ecogad.domain.product.entity.ProductCategory;

public interface ProductRepository {
    Product save(Product product);

    boolean existsByCategoryAndName(ProductCategory category, String name);
}
