package com.web.portfolio.service;

import com.web.portfolio.model.Educacion;
import com.web.portfolio.repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SEducacion {

    @Autowired
    REducacion rEducacion;

    public List<Educacion> list() {
        return rEducacion.findAll();
    }

    public Optional<Educacion> getOne(Long id) {
        return rEducacion.findById(id);
    }

    public Optional<Educacion> getByEstablecimiento(String establecimiento) {
        return rEducacion.findByEstablecimiento(establecimiento);
    }

    public void Save(Educacion expe) {
        rEducacion.save(expe);
    }

    public void Delete(Long id) {
        rEducacion.deleteById(id);
    }

    public boolean existById(Long id) {
        return rEducacion.existsById(id);
    }

    public boolean existByEstablecimiento(String establecimiento) {
        return rEducacion.existsByEstablecimiento(establecimiento);
    }

}
