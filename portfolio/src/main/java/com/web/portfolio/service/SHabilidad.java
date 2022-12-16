package com.web.portfolio.service;

import com.web.portfolio.model.Habilidad;
import com.web.portfolio.repository.RHabilidad;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SHabilidad {

    @Autowired
    RHabilidad rHabilidad;

    public List<Habilidad> list() {
        return rHabilidad.findAll();
    }

    public Optional<Habilidad> getOne(Long id) {
        return rHabilidad.findById(id);
    }

    public Optional<Habilidad> getByHabilidad(String habilidad) {
        return rHabilidad.findByHabilidad(habilidad);
    }

    public void Save(Habilidad habi) {
        rHabilidad.save(habi);
    }

    public void Delete(Long id) {
        rHabilidad.deleteById(id);
    }

    public boolean existById(Long id) {
        return rHabilidad.existsById(id);
    }

    public boolean existByHabilidad(String habilidad) {
        return rHabilidad.existsByHabilidad(habilidad);
    }

}
