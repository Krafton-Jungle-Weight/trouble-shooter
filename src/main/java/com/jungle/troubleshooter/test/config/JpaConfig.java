package com.jungle.troubleshooter.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  // @CreatedDate, @LastModifiedDate 같은 필드 자동 처리
public class JpaConfig {
    // 필요한 설정 확장 가능 (예: basePackages, entityManager 등)
}