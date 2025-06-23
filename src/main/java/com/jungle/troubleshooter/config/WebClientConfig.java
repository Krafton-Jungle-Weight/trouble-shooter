package com.jungle.troubleshooter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // WebClient: Spring에서 HTTP 요청 보내는 비동기 클라이언트이다.

    /**
     *
     * @param token : application.properties에서 정의하고, 개인의 계정에서 가지는 키값을 사용한다.
     * @return
     *
     * GitHub API의 주소를 URL로 설정 -> "https://api.github.com"
     * Http에서 인증 헤더를 "Bearer Token" 값 설정, 위에서 application.properties에서 받아온 값이고,
     * 매개변수로 받아오는 방식은 @Value("${github.token}") 로 전달
     * GitHub에서 권장하는 MIME 타입은 "application/vnd.github+json"이기에 이걸로 설정해줌
     */
    @Bean
    public WebClient githubWebClient(@Value("${github.token}") String token) {
        return WebClient.builder()
                .baseUrl("https://api.github.com")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .defaultHeader(HttpHeaders.ACCEPT, "application/vnd.github+json")
                .build();
    }
}

