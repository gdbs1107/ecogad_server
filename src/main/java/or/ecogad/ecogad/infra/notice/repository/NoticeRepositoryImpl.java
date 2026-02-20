package or.ecogad.ecogad.infra.notice.repository;

import lombok.RequiredArgsConstructor;
import or.ecogad.ecogad.domain.notice.entity.Notice;
import or.ecogad.ecogad.domain.notice.repository.NoticeRepository;
import or.ecogad.ecogad.infra.notice.jpa.NoticeJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NoticeRepositoryImpl implements NoticeRepository {

    private final NoticeJpaRepository noticeJpaRepository;

    @Override
    public Notice save(Notice notice) {
        return noticeJpaRepository.save(notice);
    }

    @Override
    public boolean existsByTitle(String title) {
        return noticeJpaRepository.existsByTitle(title);
    }
}
