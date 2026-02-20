package or.ecogad.ecogad.domain.notice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import or.ecogad.ecogad.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "notices")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean published;

    private LocalDateTime publishedAt;

    private Notice(String title, String content, boolean published) {
        this.title = title;
        this.content = content;
        this.published = published;
        this.publishedAt = published ? LocalDateTime.now() : null;
    }

    public static Notice create(String title, String content, boolean published) {
        return new Notice(title, content, published);
    }
}
