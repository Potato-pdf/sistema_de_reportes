package com.quarksoft.reportes.service.impl;

import com.quarksoft.reportes.entity.TemplateEmail;
import com.quarksoft.reportes.repository.TemplateEmailRepository;
import com.quarksoft.reportes.service.TemplateEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateEmailServiceImpl implements TemplateEmailService {
    private final TemplateEmailRepository repository;

    @Override
    public List<TemplateEmail> findAll() {
        return repository.findAll();
    }

    @Override
    public TemplateEmail findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TemplateEmail create(TemplateEmail template) {
        return repository.save(template);
    }

    @Override
    @Transactional
    public TemplateEmail update(Integer id, TemplateEmail template) {
        TemplateEmail entity = repository.findById(id).orElseThrow();
        template.setId(id);
        return repository.save(template);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
