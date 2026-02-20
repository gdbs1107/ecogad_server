package or.ecogad.ecogad.domain.notice.repository;

import or.ecogad.ecogad.domain.notice.entity.Notice;

public interface NoticeRepository {
    Notice save(Notice notice);

    boolean existsByTitle(String title);
}
