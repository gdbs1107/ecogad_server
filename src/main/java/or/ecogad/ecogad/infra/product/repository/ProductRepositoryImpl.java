package or.ecogad.ecogad.infra.product.repository;

import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.domain.product.entity.Product;
import or.ecogad.ecogad.domain.product.entity.ProductCategory;
import or.ecogad.ecogad.domain.product.repository.ProductRepository;
import or.ecogad.ecogad.infra.product.jpa.ProductJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public boolean existsByCategoryAndName(ProductCategory category, String name) {
        return productJpaRepository.existsByCategoryAndName(category, name);
    }
}
