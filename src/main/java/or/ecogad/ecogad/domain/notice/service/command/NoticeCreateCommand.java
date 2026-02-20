package or.ecogad.ecogad.domain.notice.service.command;

public record NoticeCreateCommand(
        String title,
        String content,
        boolean published
) {
}
