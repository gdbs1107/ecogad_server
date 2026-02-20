package or.ecogad.ecogad.domain.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import or.ecogad.ecogad.domain.common.BaseEntity;

@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private ProductCategory category;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 255)
    private String summary;

    @Lob
    private String description;

    @Column(length = 500)
    private String thumbnailUrl;

    @Column(nullable = false)
    private boolean published;

    private Product(
            ProductCategory category,
            String name,
            String summary,
            String description,
            String thumbnailUrl,
            boolean published
    ) {
        this.category = category;
        this.name = name;
        this.summary = summary;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.published = published;
    }

    public static Product create(
            ProductCategory category,
            String name,
            String summary,
            String description,
            String thumbnailUrl,
            boolean published
    ) {
        return new Product(category, name, summary, description, thumbnailUrl, published);
    }
}
