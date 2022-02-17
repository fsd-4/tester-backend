package net.idrok.tester.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.idrok.tester.entity.Fan;
import net.idrok.tester.entity.Savol;

@Repository
@Transactional
public interface SavolRepository extends JpaRepository<Savol, Long> {
    Page<Savol> findAllByMatnContainingIgnoreCaseOrFanNomContainingIgnoreCase(String k1, String k2, Pageable pageable);
    
}
