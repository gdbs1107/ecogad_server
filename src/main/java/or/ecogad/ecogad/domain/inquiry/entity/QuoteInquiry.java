package or.ecogad.ecogad.domain.inquiry.entity;

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
@Table(name = "quote_inquiries")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuoteInquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 120)
    private String companyName;

    @Column(nullable = false, length = 30)
    private String phone;

    @Column(nullable = false, length = 120)
    private String email;

    @Lob
    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private boolean privacyAgreed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private InquiryStatus status;

    private QuoteInquiry(
            String name,
            String companyName,
            String phone,
            String email,
            String message,
            boolean privacyAgreed
    ) {
        this.name = name;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.message = message;
        this.privacyAgreed = privacyAgreed;
        this.status = InquiryStatus.RECEIVED;
    }

    public static QuoteInquiry create(
            String name,
            String companyName,
            String phone,
            String email,
            String message,
            boolean privacyAgreed
    ) {
        return new QuoteInquiry(name, companyName, phone, email, message, privacyAgreed);
    }
}
