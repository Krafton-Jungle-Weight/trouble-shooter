package com.jungle.troubleshooter.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     *
     * @param owner : 계정 소유자
     * @param repo : 레포지토리
     * @param title : pr name
     * @param branch : pr 브랜치
     * @param baseBranch : pr 대상 브랜치
     * @param prMessage : pr 메세지
     * @return
     * 헤더정보를 새로 설정해주는데, DTO를 만들지 않았기에 Map으로 임시 구현
     * GithubResponseDTO, GithubRequestDTO를 만들어서 추후 코드 수정 필요
     * Todo: 추후 수정 필요(return 을 Dto 객체로 만들어서 반환해야 함)
     */
    public Mono<String> createPullRequest(String owner, String repo,
                                          String title, String branch,
                                          String baseBranch, String prMessage) {
        Map<String, Object> requestBody = Map.of(
                "title", title,
                "head", branch,  // <- PR의 출발 브랜치
                "base", baseBranch,                 // <- PR의 대상 브랜치
                "body", prMessage
        );

        return githubWebClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/repos/{owner}/{repo}/pulls")
                        .build(owner, repo))
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }
}
