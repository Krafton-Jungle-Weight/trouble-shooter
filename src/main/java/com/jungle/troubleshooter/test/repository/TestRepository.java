package com.jungle.troubleshooter.test.repository;

import com.jungle.troubleshooter.test.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
