package com.web.portfolio.controller;

import com.web.portfolio.dto.DtoEducacion;
import com.web.portfolio.dto.Mensaje;
import com.web.portfolio.model.Educacion;
import com.web.portfolio.service.SEducacion;
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
@RequestMapping("educacion")
@CrossOrigin(origins = {"http://localhost:4200","http://portfolio-8cf55.web.app"})
public class CEducacion {

    @Autowired SEducacion EducacionServ;

    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = EducacionServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") long id) {
        if (!EducacionServ.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = EducacionServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getEstablecimiento())) {
            return new ResponseEntity(new Mensaje("Nombre del establecimiento Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (EducacionServ.existByEstablecimiento(dtoedu.getEstablecimiento())) {
            return new ResponseEntity(new Mensaje("Nombre de Establecimiento Ya Existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getEstablecimiento(), dtoedu.getWeb(), dtoedu.getLogo(), dtoedu.getCarrera(),
                dtoedu.getPeriodo_desde(), dtoedu.getPeriodo_hasta(), dtoedu.getDescripcion());

        EducacionServ.Save(educacion);

        return new ResponseEntity(new Mensaje("Educacion Agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoEducacion dtoedu) {
        if (!EducacionServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        //        if(EducacionServ.existByEmpresa(dtoexp.getEmpresa()))
//            return new ResponseEntity(new Mensaje("Esa Experiencia YA Existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoedu.getEstablecimiento())) {
            return new ResponseEntity(new Mensaje("Nombre de Establecimiento no debe ser blanco"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = EducacionServ.getOne(id).get();
        educacion.setEstablecimiento(dtoedu.getEstablecimiento());
        educacion.setWeb(dtoedu.getWeb());
        educacion.setLogo(dtoedu.getLogo());
        educacion.setCarrera(dtoedu.getCarrera());
        educacion.setPeriodo_desde(dtoedu.getPeriodo_desde());
        educacion.setPeriodo_hasta(dtoedu.getPeriodo_hasta());
        educacion.setDescripcion(dtoedu.getDescripcion());

        EducacionServ.Save(educacion);

        return new ResponseEntity(new Mensaje("Educacion Actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestBody DtoEducacion dtoexp) {
        if (!EducacionServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        EducacionServ.Delete(id);

        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);
    }

}
