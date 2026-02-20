package or.ecogad.ecogad.domain.product.service;

import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.core.exception.CustomException;
import or.ecogad.ecogad.core.exception.ErrorCode;
import or.ecogad.ecogad.domain.product.entity.Product;
import or.ecogad.ecogad.domain.product.repository.ProductRepository;
import or.ecogad.ecogad.domain.product.service.command.ProductCreateCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product createProduct(ProductCreateCommand command) {
        boolean isDuplicate = productRepository.existsByCategoryAndName(command.category(), command.name());
        if (isDuplicate) {
            throw new CustomException(ErrorCode.DUPLICATE_PRODUCT);
        }

        Product product = Product.create(
                command.category(),
                command.name(),
                command.summary(),
                command.description(),
                command.thumbnailUrl(),
                command.published()
        );

        return productRepository.save(product);
    }
}
