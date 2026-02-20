package or.ecogad.ecogad.domain.product.service.command;

import or.ecogad.ecogad.domain.product.entity.ProductCategory;

public record ProductCreateCommand(
        ProductCategory category,
        String name,
        String summary,
        String description,
        String thumbnailUrl,
        boolean published
) {
}
