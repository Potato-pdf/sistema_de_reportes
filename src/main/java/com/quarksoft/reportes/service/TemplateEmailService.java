package com.quarksoft.reportes.service;

import com.quarksoft.reportes.entity.TemplateEmail;
import java.util.List;

public interface TemplateEmailService {
    List<TemplateEmail> findAll();
    TemplateEmail findById(Integer id);
    TemplateEmail create(TemplateEmail template);
    TemplateEmail update(Integer id, TemplateEmail template);
    void delete(Integer id);
}
