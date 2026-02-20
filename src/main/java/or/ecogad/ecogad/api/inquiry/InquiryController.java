package or.ecogad.ecogad.api.inquiry;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.api.inquiry.dto.InquiryCreateRequest;
import or.ecogad.ecogad.api.inquiry.dto.InquiryCreateResponse;
import or.ecogad.ecogad.core.api.ApiResponse;
import or.ecogad.ecogad.domain.inquiry.entity.QuoteInquiry;
import or.ecogad.ecogad.domain.inquiry.service.InquiryService;
import or.ecogad.ecogad.domain.inquiry.service.command.InquiryCreateCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inquiries")
public class InquiryController {

    private final InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<ApiResponse<InquiryCreateResponse>> createInquiry(
            @Valid @RequestBody InquiryCreateRequest request
    ) {
        InquiryCreateCommand command = new InquiryCreateCommand(
                request.name(),
                request.companyName(),
                request.phone(),
                request.email(),
                request.message(),
                request.privacyAgreed()
        );

        QuoteInquiry created = inquiryService.createInquiry(command);
        InquiryCreateResponse response = InquiryCreateResponse.from(created);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }
}
