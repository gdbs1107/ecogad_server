package or.ecogad.ecogad.infra.inquiry.jpa;

import or.ecogad.ecogad.domain.inquiry.entity.QuoteInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteInquiryJpaRepository extends JpaRepository<QuoteInquiry, Long> {
}
