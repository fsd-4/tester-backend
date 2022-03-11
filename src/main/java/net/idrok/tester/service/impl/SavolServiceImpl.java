package net.idrok.tester.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.tester.entity.Savol;
import net.idrok.tester.repository.SavolRepository;
import net.idrok.tester.service.SavolService;
import net.idrok.tester.service.dto.SavolDTO;

@Service
@Transactional
public class SavolServiceImpl implements SavolService{
    @Autowired
    SavolRepository savolRepository;


    public Page<SavolDTO> getAll(String key, Pageable pageable) {
        // return savolRepository.findAllByMatnContainingIgnoreCaseOrFanNomContainingIgnoreCase(key, key, pageable).map(savol-> new SavolDTO(savol));
        return savolRepository.findAllByMatnContainingIgnoreCaseOrFanNomContainingIgnoreCase(key, key, pageable).map(SavolDTO::new);
    }


    public Savol getById(Long id) {
        return savolRepository.findById(id).get();
    }
    public Savol getByIdEntity(Long id) {
        return savolRepository.findById(id).get();
    }

    public Savol create(Savol savol) {
        if (savol.getId() == null)
            return (savolRepository.save(savol));
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public Savol update(Savol savol) {
        if (savol.getId() != null)
          return savolRepository.save(savol);
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public void delete(Savol savol) {
        savolRepository.delete(savol);
    }

    public void deleteById(Long savolId) {
        savolRepository.deleteById(savolId);
    }


    @Override
    public List<Savol> getAll(String key) {
        // TODO Auto-generated method stub
        return savolRepository.findAll();
    }




}
