package com.web.portfolio.controller;

import com.web.portfolio.dto.DtoExperiencia;
import com.web.portfolio.dto.Mensaje;
import com.web.portfolio.model.Experiencia;
import com.web.portfolio.service.SExperiencia;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")

public class CExperiencia {

    @Autowired
    SExperiencia ExperienciaServ;

    @GetMapping("/ver/experiencias")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = ExperienciaServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/new/experiencia")
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

}
