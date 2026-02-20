package or.ecogad.ecogad.api.notice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.api.notice.dto.AdminNoticeCreateRequest;
import or.ecogad.ecogad.api.notice.dto.AdminNoticeCreateResponse;
import or.ecogad.ecogad.core.api.ApiResponse;
import or.ecogad.ecogad.domain.notice.entity.Notice;
import or.ecogad.ecogad.domain.notice.service.AdminNoticeService;
import or.ecogad.ecogad.domain.notice.service.command.NoticeCreateCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/notices")
public class AdminNoticeController {

    private final AdminNoticeService adminNoticeService;

    @PostMapping
    public ResponseEntity<ApiResponse<AdminNoticeCreateResponse>> createNotice(
            @Valid @RequestBody AdminNoticeCreateRequest request
    ) {
        NoticeCreateCommand command = new NoticeCreateCommand(
                request.title(),
                request.content(),
                request.published()
        );

        Notice created = adminNoticeService.createNotice(command);
        AdminNoticeCreateResponse response = AdminNoticeCreateResponse.from(created);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }
}
