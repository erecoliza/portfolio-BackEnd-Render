package com.web.portfolio.service;

import com.web.portfolio.model.Experiencia;
import com.web.portfolio.repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SExperiencia {

    @Autowired
    RExperiencia rExperiencia;

    public List<Experiencia> list() {
        return rExperiencia.findAll();
    }

    public Optional<Experiencia> getOne(Long id) {
        return rExperiencia.findById(id);
    }

    public Optional<Experiencia> getByEmpresa(String empresa) {
        return rExperiencia.findByEmpresa(empresa);
    }

    public void Save(Experiencia expe) {
        rExperiencia.save(expe);
    }

    public void Delete(Long id) {
        rExperiencia.deleteById(id);
    }

    public boolean existById(Long id) {
        return rExperiencia.existsById(id);
    }

    public boolean existByEmpresa(String empresa) {
        return rExperiencia.existsByEmpresa(empresa);
    }

}
