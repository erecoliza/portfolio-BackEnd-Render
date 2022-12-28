package com.web.portfolio.controller;

import com.web.portfolio.dto.DtoHabilidad;
import com.web.portfolio.dto.Mensaje;
import com.web.portfolio.model.Habilidad;
import com.web.portfolio.service.SHabilidad;
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
@RequestMapping("habilidad")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://portfolio-8cf55.web.app")
public class CHabilidad {

    @Autowired
    SHabilidad HabilidadServ;

    @GetMapping("/list")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = HabilidadServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") long id) {
        if (!HabilidadServ.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = HabilidadServ.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);

    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtohab) {
        if (StringUtils.isBlank(dtohab.getHabilidad())) {
            return new ResponseEntity(new Mensaje("Nombre de habilidad Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (HabilidadServ.existByHabilidad(dtohab.getHabilidad())) {
            return new ResponseEntity(new Mensaje("Nombre de habilidad Ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Habilidad habilidad = new Habilidad(dtohab.getHabilidad(), dtohab.getPorcentaje(), dtohab.getColor());

        HabilidadServ.Save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad Agregada"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoHabilidad dtohab) {
        if (!HabilidadServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        //        if(HabilidadServ.existByHabilidad(dtohab.getHabilidad()))
//            return new ResponseEntity(new Mensaje("Esa Habilidad YA Existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtohab.getHabilidad())) {
            return new ResponseEntity(new Mensaje("Nombre de Habilidad no debe ser blanco"), HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = HabilidadServ.getOne(id).get();
        habilidad.setHabilidad(dtohab.getHabilidad());
        habilidad.setPorcentaje(dtohab.getPorcentaje());
        habilidad.setColor(dtohab.getColor());

        HabilidadServ.Save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad Actualizada"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!HabilidadServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        HabilidadServ.Delete(id);

        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
    }

}
