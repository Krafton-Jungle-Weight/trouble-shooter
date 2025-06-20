package com.jungle.troubleshooter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GithubCommitService {

    private final WebClient githubWebClient;

    public GithubCommitService(WebClient githubWebClient) {
        this.githubWebClient = githubWebClient;
    }

    /**
     * 연결할 객체를 가져와 uri에 대한 내용을 지정해준다. 기본적으로 uri는 config에서 초기화
     * https://api.github.com + repos/{owner}/{repo}/commits
     * 으로 json형태의 데이터를 반환 받는다.
     * @param owner
     * @param repo
     * @return
     */

    public Mono<String> getCommits(String owner, String repo) {
    return githubWebClient.get()
            .uri(uriBuilder -> uriBuilder
                    .path("/repos/{owner}/{repo}/commits")
                    .build(owner, repo))
            .retrieve()
            .bodyToMono(String.class); // 또는 CommitDTO[]로 파싱 가능
    }
}
