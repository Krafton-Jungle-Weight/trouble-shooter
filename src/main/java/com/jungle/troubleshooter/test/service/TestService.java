package com.jungle.troubleshooter.test.service;

import com.jungle.troubleshooter.test.domain.TestEntity;
import com.jungle.troubleshooter.test.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public String getMessageById(Long id) {
        Optional<TestEntity> test = testRepository.findById(id);
        return test.map(TestEntity::getMessage)
                .orElse("데이터 없음");
    }
}
