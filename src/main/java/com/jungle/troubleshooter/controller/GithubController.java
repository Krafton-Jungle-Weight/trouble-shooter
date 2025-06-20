package com.jungle.troubleshooter.controller;

import com.jungle.troubleshooter.service.GithubCommitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubCommitService githubCommitService;

    public GithubController(GithubCommitService githubCommitService) {
        this.githubCommitService = githubCommitService;
    }

    /**
     * Ex) http://domain/api/github/commits?owner=owner&repo=repo
     * @param owner : 사용자 이름
     * @param repo : 레포지토리 이름
     * @return JSON의 순수 문자열
     */
    @GetMapping("/commits")
    public Mono<String> getCommits(
            @RequestParam String owner,
            @RequestParam String repo
    ) {
        return githubCommitService.getCommits(owner, repo);
    }
}