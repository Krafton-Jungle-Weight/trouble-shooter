package com.jungle.troubleshooter.controller;

import com.jungle.troubleshooter.dto.CommitResponse;
import com.jungle.troubleshooter.service.GithubCommitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubCommitService githubCommitService;

    public GithubController(GithubCommitService githubCommitService) {
        this.githubCommitService = githubCommitService;
    }
    @GetMapping("/commits")
    public Mono<String> getCommits(
            @RequestParam String owner,
            @RequestParam String repo
    ) {
        return githubCommitService.getCommits(owner, repo);
    }
}