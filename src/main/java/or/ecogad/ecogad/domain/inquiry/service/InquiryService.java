package or.ecogad.ecogad.domain.inquiry.service;

import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.core.exception.CustomException;
import or.ecogad.ecogad.core.exception.ErrorCode;
import or.ecogad.ecogad.domain.inquiry.entity.QuoteInquiry;
import or.ecogad.ecogad.domain.inquiry.port.InquiryNotificationSender;
import or.ecogad.ecogad.domain.inquiry.repository.QuoteInquiryRepository;
import or.ecogad.ecogad.domain.inquiry.service.command.InquiryCreateCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final QuoteInquiryRepository quoteInquiryRepository;
    private final InquiryNotificationSender inquiryNotificationSender;

    @Transactional
    public QuoteInquiry createInquiry(InquiryCreateCommand command) {
        QuoteInquiry inquiry = QuoteInquiry.create(
                command.name(),
                command.companyName(),
                command.phone(),
                command.email(),
                command.message(),
                command.privacyAgreed()
        );

        QuoteInquiry saved = quoteInquiryRepository.save(inquiry);

        try {
            inquiryNotificationSender.send(saved);
        } catch (RuntimeException exception) {
            throw new CustomException(ErrorCode.INQUIRY_NOTIFICATION_FAILED);
        }

        return saved;
    }
}
