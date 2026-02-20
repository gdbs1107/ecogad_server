package or.ecogad.ecogad.api.inquiry.dto;

import or.ecogad.ecogad.domain.inquiry.entity.QuoteInquiry;

import java.time.LocalDateTime;

public record InquiryCreateResponse(
        Long id,
        String status,
        LocalDateTime createdAt
) {
    public static InquiryCreateResponse from(QuoteInquiry inquiry) {
        return new InquiryCreateResponse(
                inquiry.getId(),
                inquiry.getStatus().name(),
                inquiry.getCreatedAt()
        );
    }
}
