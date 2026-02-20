package or.ecogad.ecogad.api.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.api.product.dto.AdminProductCreateRequest;
import or.ecogad.ecogad.api.product.dto.AdminProductCreateResponse;
import or.ecogad.ecogad.core.api.ApiResponse;
import or.ecogad.ecogad.domain.product.entity.Product;
import or.ecogad.ecogad.domain.product.entity.ProductCategory;
import or.ecogad.ecogad.domain.product.service.AdminProductService;
import or.ecogad.ecogad.domain.product.service.command.ProductCreateCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/products")
public class AdminProductController {

    private final AdminProductService adminProductService;

    @PostMapping
    public ResponseEntity<ApiResponse<AdminProductCreateResponse>> createProduct(
            @Valid @RequestBody AdminProductCreateRequest request
    ) {
        ProductCreateCommand command = new ProductCreateCommand(
                ProductCategory.from(request.category()),
                request.name(),
                request.summary(),
                request.description(),
                request.thumbnailUrl(),
                request.published()
        );

        Product created = adminProductService.createProduct(command);
        AdminProductCreateResponse response = AdminProductCreateResponse.from(created);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }
}
