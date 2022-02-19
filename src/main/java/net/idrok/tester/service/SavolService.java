package net.idrok.tester.service;

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
import net.idrok.tester.service.dto.SavolDTO;

@Service
@Transactional
public class SavolService {
    @Autowired
    SavolRepository savolRepository;


    public Page<SavolDTO> getAll(String key, Pageable pageable) {
        // return savolRepository.findAllByMatnContainingIgnoreCaseOrFanNomContainingIgnoreCase(key, key, pageable).map(savol-> new SavolDTO(savol));
        return savolRepository.findAllByMatnContainingIgnoreCaseOrFanNomContainingIgnoreCase(key, key, pageable).map(SavolDTO::new);
    }


    public SavolDTO getById(Long id) {
        return savolRepository.findById(id).map(SavolDTO::new).get();
    }
    public Savol getByIdEntity(Long id) {
        return savolRepository.findById(id).get();
    }

    public SavolDTO create(Savol savol) {
        if (savol.getId() == null)
            return new SavolDTO(savolRepository.save(savol));
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public SavolDTO update(Savol savol) {
        if (savol.getId() != null)
          return new SavolDTO(savolRepository.save(savol));
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public void delete(Savol savol) {
        savolRepository.delete(savol);
    }

    public void deleteById(Long savolId) {
        savolRepository.deleteById(savolId);
    }

}
