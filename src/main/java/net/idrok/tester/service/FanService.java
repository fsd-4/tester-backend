package net.idrok.tester.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.idrok.tester.entity.Fan;
import net.idrok.tester.repository.FanRepository;

@Service
public class FanService {
    @Autowired
    FanRepository fanRepository;

    public List<Fan> getAll(String key) {
        return fanRepository.findAllByNomContainingOrMalumotContaining(key, key);
    }

    public Fan getById(Long id) {
        return fanRepository.findById(id).get();
    }

    public Fan create(Fan fan) {
        if (fan.getId() == null)
            return fanRepository.save(fan);
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public Fan update(Fan fan) {
        if (fan.getId() != null)
          return  fanRepository.save(fan);
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public void delete(Fan fan) {
        fanRepository.delete(fan);
    }

    public void deleteById(Long fanId) {
        fanRepository.deleteById(fanId);
    }

}
