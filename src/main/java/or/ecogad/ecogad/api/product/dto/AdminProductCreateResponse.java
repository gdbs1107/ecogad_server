package or.ecogad.ecogad.api.product.dto;

import or.ecogad.ecogad.domain.product.entity.Product;

import java.time.LocalDateTime;

public record AdminProductCreateResponse(
        Long id,
        String category,
        String name,
        String summary,
        String description,
        String thumbnailUrl,
        boolean published,
        LocalDateTime createdAt
) {
    public static AdminProductCreateResponse from(Product product) {
        return new AdminProductCreateResponse(
                product.getId(),
                product.getCategory().name(),
                product.getName(),
                product.getSummary(),
                product.getDescription(),
                product.getThumbnailUrl(),
                product.isPublished(),
                product.getCreatedAt()
        );
    }
}
