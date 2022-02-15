package net.idrok.tester.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.tester.entity.Variant;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Long>{
        
}
