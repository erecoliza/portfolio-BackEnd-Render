package com.web.portfolio.service;

import com.web.portfolio.model.Red;
import com.web.portfolio.repository.RRed;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SRed {

    @Autowired
    RRed rRed;

    public List<Red> list() {
        return rRed.findAll();
    }

    public Optional<Red> getOne(Long id) {
        return rRed.findById(id);
    }

    public Optional<Red> getByRed(String red) {
        return rRed.findByRed(red);
    }

    public void Save(Red red) {
        rRed.save(red);
    }

    public void Delete(Long id) {
        rRed.deleteById(id);
    }

    public boolean existById(Long id) {
        return rRed.existsById(id);
    }

    public boolean existByRed(String red) {
        return rRed.existsByRed(red);
    }

}
