package or.ecogad.ecogad.infra.notice.jpa;

import or.ecogad.ecogad.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeJpaRepository extends JpaRepository<Notice, Long> {
    boolean existsByTitle(String title);
}
