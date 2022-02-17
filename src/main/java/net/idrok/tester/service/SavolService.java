package net.idrok.tester.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.tester.entity.Savol;
import net.idrok.tester.repository.SavolRepository;

@Service
@Transactional
public class SavolService {
    @Autowired
    SavolRepository savolRepository;


    public Page<Savol> getAll(String key, Pageable pageable) {
        return savolRepository.findAllByMatnContainingIgnoreCaseOrFanNomContainingIgnoreCase(key, key, pageable);
    }


    public Savol getById(Long id) {
        return savolRepository.findById(id).get();
    }

    public Savol create(Savol savol) {
        if (savol.getId() == null)
            return savolRepository.save(savol);
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public Savol update(Savol savol) {
        if (savol.getId() != null)
          return  savolRepository.save(savol);
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public void delete(Savol savol) {
        savolRepository.delete(savol);
    }

    public void deleteById(Long savolId) {
        savolRepository.deleteById(savolId);
    }

}
