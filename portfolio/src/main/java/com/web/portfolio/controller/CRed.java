package com.web.portfolio.controller;

import com.web.portfolio.dto.DtoRed;
import com.web.portfolio.dto.Mensaje;
import com.web.portfolio.model.Educacion;
import com.web.portfolio.model.Red;
import com.web.portfolio.service.SRed;
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
@RequestMapping("red")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-8cf55.web.app")
public class CRed {

    @Autowired
    SRed RedServ;

    @GetMapping("/list")
    public ResponseEntity<List<Red>> list() {
        List<Red> list = RedServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") long id) {
        if (!RedServ.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Red red = RedServ.getOne(id).get();
        return new ResponseEntity(red, HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DtoRed dtored) {
        if (StringUtils.isBlank(dtored.getRed())) {
            return new ResponseEntity(new Mensaje("Nombre de la Red Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (RedServ.existByRed(dtored.getRed())) {
            return new ResponseEntity(new Mensaje("Nombre de la Red Ya Existe"), HttpStatus.BAD_REQUEST);
        }

        Red red = new Red(dtored.getRed(), dtored.getLink());

        RedServ.Save(red);

        return new ResponseEntity(new Mensaje("Red Agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoRed dtored) {
        if (!RedServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        //        if(EducacionServ.existByEmpresa(dtoexp.getEmpresa()))
//            return new ResponseEntity(new Mensaje("Esa Experiencia YA Existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtored.getRed())) {
            return new ResponseEntity(new Mensaje("Nombre de la Red no debe ser blanco"), HttpStatus.BAD_REQUEST);
        }

        Red red = RedServ.getOne(id).get();
        red.setRed(dtored.getRed());
        red.setLink(dtored.getLink());

        RedServ.Save(red);

        return new ResponseEntity(new Mensaje("Red Actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestBody DtoRed dtored) {
        if (!RedServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        RedServ.Delete(id);

        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);
    }

}
