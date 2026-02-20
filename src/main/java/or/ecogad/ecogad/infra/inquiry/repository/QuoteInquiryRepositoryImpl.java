package or.ecogad.ecogad.infra.inquiry.repository;

import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.domain.inquiry.entity.QuoteInquiry;
import or.ecogad.ecogad.domain.inquiry.repository.QuoteInquiryRepository;
import or.ecogad.ecogad.infra.inquiry.jpa.QuoteInquiryJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuoteInquiryRepositoryImpl implements QuoteInquiryRepository {

    private final QuoteInquiryJpaRepository quoteInquiryJpaRepository;

    @Override
    public QuoteInquiry save(QuoteInquiry quoteInquiry) {
        return quoteInquiryJpaRepository.save(quoteInquiry);
    }
}
