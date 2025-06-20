package com.jungle.troubleshooter.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommitResponse {
    private String sha;
    private Commit commit;
    private Author author;

    @Getter
    @Setter
    public static class Commit {
        private CommitAuthor author;
        private String message;
    }

    @Getter
    @Setter
    public static class CommitAuthor {
        private String name;
        private String email;
        private String date;
    }

    @Getter
    @Setter
    public static class Author {
        private String login;
        private String avatar_url;
    }
}
