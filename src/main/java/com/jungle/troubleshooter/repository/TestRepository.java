package com.jungle.troubleshooter.repository;

import com.jungle.troubleshooter.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
