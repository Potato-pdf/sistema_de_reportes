package com.quarksoft.reportes.repository;

import com.quarksoft.reportes.entity.TemplateEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateEmailRepository extends JpaRepository<TemplateEmail, Integer> {
}
