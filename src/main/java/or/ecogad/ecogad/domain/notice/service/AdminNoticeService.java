package or.ecogad.ecogad.domain.notice.service;

import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.core.exception.CustomException;
import or.ecogad.ecogad.core.exception.ErrorCode;
import or.ecogad.ecogad.domain.notice.entity.Notice;
import or.ecogad.ecogad.domain.notice.repository.NoticeRepository;
import or.ecogad.ecogad.domain.notice.service.command.NoticeCreateCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminNoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public Notice createNotice(NoticeCreateCommand command) {
        if (noticeRepository.existsByTitle(command.title())) {
            throw new CustomException(ErrorCode.DUPLICATE_NOTICE);
        }

        Notice notice = Notice.create(command.title(), command.content(), command.published());
        return noticeRepository.save(notice);
    }
}
