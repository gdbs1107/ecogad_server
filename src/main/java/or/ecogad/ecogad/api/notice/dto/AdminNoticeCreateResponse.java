package or.ecogad.ecogad.api.notice.dto;

import or.ecogad.ecogad.domain.notice.entity.Notice;

import java.time.LocalDateTime;

public record AdminNoticeCreateResponse(
        Long id,
        String title,
        String content,
        boolean published,
        LocalDateTime publishedAt,
        LocalDateTime createdAt
) {
    public static AdminNoticeCreateResponse from(Notice notice) {
        return new AdminNoticeCreateResponse(
                notice.getId(),
                notice.getTitle(),
                notice.getContent(),
                notice.isPublished(),
                notice.getPublishedAt(),
                notice.getCreatedAt()
        );
    }
}
