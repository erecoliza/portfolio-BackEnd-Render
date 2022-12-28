package com.web.portfolio.controller;

import com.web.portfolio.dto.DtoExperiencia;
import com.web.portfolio.dto.Mensaje;
import com.web.portfolio.model.Experiencia;
import com.web.portfolio.service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia")

@CrossOrigin(origins = {"https://erecoliza-portfolio.web.app","http://localhost:4200"})

public class CExperiencia {

    @Autowired
    SExperiencia ExperienciaServ;

    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = ExperienciaServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") long id) {
        if (!ExperienciaServ.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = ExperienciaServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("Nombre de empresa Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ExperienciaServ.existByEmpresa(dtoexp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("Nombre de empresa Ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoexp.getEmpresa(), dtoexp.getWeb(),
                dtoexp.getLogo(), dtoexp.getPuesto(), dtoexp.getPeriodo_desde(), dtoexp.getPeriodo_hasta(), dtoexp.getDescripcion());

        ExperienciaServ.Save(experiencia);

        return new ResponseEntity(new Mensaje("Empresa Agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoExperiencia dtoexp) {
        if (!ExperienciaServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        if (ExperienciaServ.existByEmpresa(dtoexp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("Esa Experiencia YA Existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoexp.getEmpresa())) {
            return new ResponseEntity(new Mensaje("Nombre de Empresa no debe ser blanco"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = ExperienciaServ.getOne(id).get();
        experiencia.setEmpresa(dtoexp.getEmpresa());
        experiencia.setWeb(dtoexp.getWeb());
        experiencia.setLogo(dtoexp.getLogo());
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setPeriodo_desde(dtoexp.getPeriodo_desde());
        experiencia.setPeriodo_hasta(dtoexp.getPeriodo_hasta());
        experiencia.setDescripcion(dtoexp.getDescripcion());

        ExperienciaServ.Save(experiencia);

        return new ResponseEntity(new Mensaje("Empresa Actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestBody DtoExperiencia dtoexp) {
        if (!ExperienciaServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        ExperienciaServ.Delete(id);

        return new ResponseEntity(new Mensaje("Empresa Eliminada"), HttpStatus.OK);
    }

}
