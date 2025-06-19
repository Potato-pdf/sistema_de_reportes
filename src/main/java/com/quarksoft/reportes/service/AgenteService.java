package com.quarksoft.reportes.service;

import com.quarksoft.reportes.dto.AgenteDTO;
import java.util.List;

public interface AgenteService {
    List<AgenteDTO> findAll();
    AgenteDTO findById(Integer id);
    AgenteDTO create(AgenteDTO agenteDTO);
    AgenteDTO update(Integer id, AgenteDTO agenteDTO);
    void delete(Integer id);
}
