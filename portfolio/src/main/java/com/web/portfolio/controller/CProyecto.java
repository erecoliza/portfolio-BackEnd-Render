package com.web.portfolio.controller;

import com.web.portfolio.dto.DtoProyecto;
import com.web.portfolio.dto.Mensaje;
import com.web.portfolio.model.Proyecto;
import com.web.portfolio.service.SProyecto;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {

    @Autowired
    SProyecto ProyectoServ;

    @GetMapping("/list")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = ProyectoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") long id) {
        if (!ProyectoServ.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = ProyectoServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);

    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproy) {
        if (StringUtils.isBlank(dtoproy.getProyecto())) {
            return new ResponseEntity(new Mensaje("Nombre de proyecto Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //if (ProyectoServ.existByProyecto(dtoproy.getProyecto())) {
        //    return new ResponseEntity(new Mensaje("Nombre de proyecto Ya Existe"), HttpStatus.BAD_REQUEST);
        //}
        Proyecto proyecto = new Proyecto(dtoproy.getProyecto(), dtoproy.getWeb(), dtoproy.getFecha(), dtoproy.getDescripcion());

        ProyectoServ.Save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoProyecto dtoproy) {
        if (!ProyectoServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        //        if(ProyectoServ.existByProyecto(dtoproy.getProyecto()))
//            return new ResponseEntity(new Mensaje("Esa Proyecto YA Existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoproy.getProyecto())) {
            return new ResponseEntity(new Mensaje("Nombre de Proyecto no debe ser blanco"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = ProyectoServ.getOne(id).get();
        proyecto.setProyecto(dtoproy.getProyecto());
        proyecto.setWeb(dtoproy.getWeb());
        proyecto.setFecha(dtoproy.getFecha());
        proyecto.setDescripcion(dtoproy.getDescripcion());

        ProyectoServ.Save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!ProyectoServ.existById(id)) {
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        ProyectoServ.Delete(id);

        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }

}
