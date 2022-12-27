package com.web.portfolio.service;

import com.web.portfolio.model.Proyecto;
import com.web.portfolio.repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SProyecto {

    @Autowired
    RProyecto rProyecto;

    public List<Proyecto> list() {
        return rProyecto.findAll();
    }

    public Optional<Proyecto> getOne(Long id) {
        return rProyecto.findById(id);
    }

    public Optional<Proyecto> getByProyecto(String proyecto) {
        return rProyecto.findByProyecto(proyecto);
    }

    public void Save(Proyecto habi) {
        rProyecto.save(habi);
    }

    public void Delete(Long id) {
        rProyecto.deleteById(id);
    }

    public boolean existById(Long id) {
        return rProyecto.existsById(id);
    }

    //public boolean existByEmpresa(String empresa) {
        //return rExperiencia.existByEmpresa(empresa);
    //}

}
